package gamification.kitty.hackathon.kittybank.request;

import android.content.Context;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.entity.Transaction;
import gamification.kitty.hackathon.kittybank.entity.User;
import gamification.kitty.hackathon.kittybank.enums.ERestApiEndpoints;

/**
 * Created by Khổng Cảnh on 4/21/2018.
 */

public class TransactionRequestManagement {
    private Context applicationContext;

    public TransactionRequestManagement(Context context) {
        applicationContext = context;
    }

    private Context getApplicationContext() {
        return applicationContext;
    }
    public void updateTransaction(final IVolleyCallback callback, final Transaction transaction){

        final int[] responseCode = new int[1];

        // Build a request to check if the login token is valid
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject json = new JSONObject();
        try {
            json.put("senderAccount", transaction.getSenderAccount());
            json.put("receiverAccount", transaction.getReceiverAccount());
            json.put("receiverName", transaction.getReceiverName());
            json.put("balance", transaction.getBalance());
            json.put("date", transaction.getDate());
            json.put("typeId", transaction.getTypeId());
            json.put("message", transaction.getMessage());
            json.put("creditPoint", transaction.getCreditPoint());
            Log.d("json", json.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST,
                ERestApiEndpoints.POST_UPDATE_TRANSACTION.toString(),
                json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (responseCode[0] == 200) {
                            if (response != null) {
                                callback.onSuccess(response.toString());
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
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                responseCode[0] = response.statusCode;
                return super.parseNetworkResponse(response);
            }
        };
        requestQueue.add(postRequest);
    }
}
