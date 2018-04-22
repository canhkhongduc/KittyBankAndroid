package gamification.kitty.hackathon.kittybank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import gamification.kitty.hackathon.kittybank.adapter.KittyAdapter;
import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.entity.Kitty;
import gamification.kitty.hackathon.kittybank.listener.RecyclerViewClickListener;
import gamification.kitty.hackathon.kittybank.request.KittyRequestManagement;

public class HomeKittyActivity extends BaseActivity implements RecyclerViewClickListener {
    private KittyRequestManagement kittyRequestManagement;
    private RecyclerView imageScroller;
    private LinearLayoutManager layoutManager;
    private List<Kitty> kitties;
    private HomeKittyActivity activity;
    CardView cvHybrid, cvStore, cvRank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_kitty);

        activity = this;

        imageScroller = findViewById(R.id.pet_slider);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        imageScroller.setLayoutManager(layoutManager);
        cvHybrid = findViewById(R.id.kitty_home_hybridbtn);
        cvRank = findViewById(R.id.kitty_home_rankbtn);
        cvStore = findViewById(R.id.kitty_home_shopbtn);

        cvHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeKittyActivity.this, HybridActivity.class);
                HomeKittyActivity.this.startActivity(intent);
            }
        });

        cvStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeKittyActivity.this, StoreActivity.class);
                HomeKittyActivity.this.startActivity(intent);
            }
        });

        //test for get kitty request
        kittyRequestManagement = new KittyRequestManagement(getApplicationContext());
        kittyRequestManagement.getKittiesByUserId(new IVolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                kitties = gson.fromJson(result, new TypeToken<List<Kitty>>() {
                }.getType());

                KittyAdapter adapter = new KittyAdapter(kitties, activity);

                imageScroller.setAdapter(adapter);
            }

            @Override
            public void onFailure(String result) {
                Log.d("test", result + "abc");
            }
        }, 1);
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        int itemPosition = imageScroller.getChildLayoutPosition(v);
        int id = kitties.get(itemPosition).getId();
        Log.d("test", id + "");

        Intent intent = new Intent(HomeKittyActivity.this, ProfileActivity.class);
        intent.putExtra("id", id);

        startActivity(intent);
    }
}
