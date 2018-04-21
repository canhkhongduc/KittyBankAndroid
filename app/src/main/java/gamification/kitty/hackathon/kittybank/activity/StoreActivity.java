package gamification.kitty.hackathon.kittybank.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import gamification.kitty.hackathon.kittybank.R;
import gamification.kitty.hackathon.kittybank.adapter.CustomStoreItemListAdapter;
import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.contract.GetItemStoreByResponse;
import gamification.kitty.hackathon.kittybank.entity.ItemStore;
import gamification.kitty.hackathon.kittybank.request.StoreRequestManagement;

public class StoreActivity extends AppCompatActivity {
    ListView lvItemStore;
    StoreRequestManagement storeRequestManagement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        storeRequestManagement = new StoreRequestManagement(getApplicationContext());
        storeRequestManagement.getFoods(new IVolleyCallback() {
            @Override
            public void onSuccess(String result) {
                try{
                    Gson gson = new Gson();
                    List<ItemStore> response = gson.fromJson(result, new TypeToken<List<ItemStore>>(){}.getType());
                    lvItemStore = (ListView) findViewById(R.id.lvItemStore);
                    lvItemStore.setAdapter(new CustomStoreItemListAdapter(getApplicationContext(), response));
                } catch (Exception e){
                    Log.d("error",e.toString());
                }
            }
        });


    }
}
