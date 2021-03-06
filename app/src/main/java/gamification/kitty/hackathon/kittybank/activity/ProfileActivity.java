package gamification.kitty.hackathon.kittybank.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import gamification.kitty.hackathon.kittybank.adapter.FoodAdapter;
import gamification.kitty.hackathon.kittybank.entity.Food;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.entity.Kitty;
import gamification.kitty.hackathon.kittybank.request.KittyRequestManagement;

public class ProfileActivity extends BaseActivity {
    private Button btnFeed;
    private Context activityContext;
    private RecyclerView foodList;
    private LinearLayoutManager layoutManager;

    private KittyRequestManagement kittyRequestManagement;
    private Kitty kitty;

    @BindView(R.id.profile_hunger_progress)
    ProgressBar progressBarHunger;
    @BindView(R.id.profile_hygiene_progress)
    ProgressBar progressBarHygiene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        kittyRequestManagement = new KittyRequestManagement(this);

        setupUI();
        loadHungerAndHygieneToBars();
    }

    private void setupUI() {
        ButterKnife.bind(this);
    }

    private void loadHungerAndHygieneToBars() {
        kittyRequestManagement.getKittyById(new IVolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Kitty kitty = new Gson().fromJson(result, Kitty.class);
                updateProgressBars(kitty);
            }

            @Override
            public void onFailure(String message) {

            }
        }, 1); // TODO: change this to dynamic id later


    }

    private void loadKittyInfoToView() {
        // TODO: implement after view is completed
    }

    @OnClick(R.id.profile_btn_feed)
    void feedPet() {
        feedPet(1);
    }

    private void feedPet(int foodId) {
        kittyRequestManagement.feedKittyRequest(new IVolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Log.d("BLA", result);
                updateProgressBars(new Gson().fromJson(result, Kitty.class));
            }

            @Override
            public void onFailure(String message) {

            }
        }, kitty.getId(), foodId);
    }

    @OnClick(R.id.profile_btn_clean)
    void cleanPet() {
        kittyRequestManagement.bathKittyRequest(new IVolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Log.d("BLA", result);
                updateProgressBars(new Gson().fromJson(result, Kitty.class));
            }

            @Override
            public void onFailure(String message) {

            }
        }, kitty.getId());
    }

    private void updateProgressBars(Kitty kitty) {
        this.kitty = kitty;

        progressBarHunger.setProgress(kitty.getHunger());
        progressBarHygiene.setProgress(kitty.getHygiene());

        activityContext = this;

        foodList = findViewById(R.id.profile_food_list);

        List<Food> foods = new ArrayList<>();

        foods.add(new Food());
        foods.add(new Food());
        foods.add(new Food());
        foods.add(new Food());
        foods.add(new Food());

        FoodAdapter foodAdapter = new FoodAdapter(foods, this);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        foodList.setLayoutManager(layoutManager);

        foodList.setAdapter(foodAdapter);
    }

    public void hideFoodList() {
        foodList.setVisibility(View.GONE);
    }
}
