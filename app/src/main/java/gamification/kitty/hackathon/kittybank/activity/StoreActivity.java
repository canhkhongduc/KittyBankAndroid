package gamification.kitty.hackathon.kittybank.activity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import gamification.kitty.hackathon.kittybank.R;
import gamification.kitty.hackathon.kittybank.adapter.CustomStoreItemListAdapter;
import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.contract.GetItemStoreByResponse;
import gamification.kitty.hackathon.kittybank.entity.Food;
import gamification.kitty.hackathon.kittybank.entity.ItemStore;
import gamification.kitty.hackathon.kittybank.entity.KittyType;
import gamification.kitty.hackathon.kittybank.request.StoreRequestManagement;

public class StoreActivity extends AppCompatActivity {
    ListView lvItemStore;
    StoreRequestManagement storeRequestManagement;
    TextView tvCreditPoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        tvCreditPoint = findViewById(R.id.tvCreditPoint);
        lvItemStore = (ListView) findViewById(R.id.lvItemStore);
        //Get CP from sharedPreference
        SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(this);
        String creditPoint = preference.getString("creditPoint", null);
        tvCreditPoint.setText("CP: "+creditPoint);
        storeRequestManagement = new StoreRequestManagement(getApplicationContext());
        storeRequestManagement.getItemStore(new IVolleyCallback() {
            @Override
            public void onSuccess(String result) {
                try{
                    Gson gson = new Gson();
                    GetItemStoreByResponse response = gson.fromJson(result, GetItemStoreByResponse.class);
                    List<KittyType> kittyTypes = response.getListEggs();
                    List<Food> foods = response.getListFoods();
                    List<ItemStore> itemStores = new ArrayList<>();
                    for (KittyType egg:kittyTypes) {
                        ItemStore itemStore = new ItemStore(
                                egg.getId(),
                                egg.getName(),
                                egg.getPrice(),
                                egg.getImage(),
                                egg.getDescription()
                        );
                        itemStores.add(itemStore);
                    }
                    for(Food food: foods){
                        ItemStore itemStore = new ItemStore(
                                food.getId(),
                                food.getName(),
                                food.getPrice(),
                                food.getImage(),
                                food.getDescription()
                        );
                        itemStores.add(itemStore);
                    }

                    lvItemStore.setAdapter(new CustomStoreItemListAdapter(StoreActivity.this, itemStores));
                } catch (Exception e){
                    Log.d("error",e.toString());
                }
            }

            @Override
            public void onFailure(String message) {

            }
        });


    }
}
