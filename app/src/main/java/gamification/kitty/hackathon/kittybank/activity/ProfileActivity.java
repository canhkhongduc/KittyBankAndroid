package gamification.kitty.hackathon.kittybank.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import gamification.kitty.hackathon.kittybank.adapter.FoodAdapter;
import gamification.kitty.hackathon.kittybank.entity.Food;

public class ProfileActivity extends BaseActivity {
    private Button btnFeed;
    private Context activityContext;
    private RecyclerView foodList;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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

        btnFeed = findViewById(R.id.profile_btn_feed);
        btnFeed.setOnClickListener(new onBtnFeedClickListener());
    }

    private class onBtnFeedClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            foodList.setVisibility(View.VISIBLE);
        }
    }

    public void hideFoodList() {
        foodList.setVisibility(View.GONE);
    }
}
