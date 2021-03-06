package gamification.kitty.hackathon.kittybank.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.enums.ERestApiEndpoints;

/**
 * Created by User on 4/21/2018.
 */

public class StoreRequestManagement {
    private Context applicationContext;

    public StoreRequestManagement(Context context) {
        applicationContext = context;
    }

    private Context getApplicationContext() {
        return applicationContext;
    }

    public void buyItem (final IVolleyCallback callback, final int id, final String name){
        final int[] responseCode = new int[1];

        // Build a request to check if the login token is valid
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest postRequest = new StringRequest(Request.Method.POST,
                ERestApiEndpoints.POST_BUY_ITEM_BY_ID.toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (responseCode[0] == 200) {
                            if (response != null) {
                                callback.onSuccess(response);
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", error.toString()); //fix hard code
                callback.onFailure(error.toString());
            }
        }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
                String accountNumber = preferences.getString("accountNumber", null);
                params.put("id", id+"");
                params.put("name", name);
                params.put("accountNumber", accountNumber);
                return params;
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                responseCode[0] = response.statusCode;
                return super.parseNetworkResponse(response);
            }
        };
        requestQueue.add(postRequest);
    }

    public void getItemStore(final IVolleyCallback callback){
        final int[] statusCode = new int[1];
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                ERestApiEndpoints.GET_ITEM_STORE_ENDPOINT.toString(),
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        if (statusCode[0] == 200) {
                            // Pass the response to callback functions to handle after volley has
                            // finished the request and receive response
                            callback.onSuccess(response);
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error.Response", error.toString());
                        String json = null;
                        NetworkResponse response = error.networkResponse;
                        if(response != null && response.data != null){
                            switch(response.statusCode){
                                case 400:

                                    json = new String(response.data);
                                    System.out.println(json);
                                    break;
                            }
                            //Additional cases
                        }
                    }
                })
        {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                statusCode[0] = response.statusCode;
                return super.parseNetworkResponse(response);
            }
        };
        // Send request to the server
        requestQueue.add(stringRequest);
    }
}
