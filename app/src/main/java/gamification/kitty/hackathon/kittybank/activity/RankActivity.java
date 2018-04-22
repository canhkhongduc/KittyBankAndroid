package gamification.kitty.hackathon.kittybank.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import gamification.kitty.hackathon.kittybank.adapter.RankAdapter;
import gamification.kitty.hackathon.kittybank.entity.Kitty;

public class RankActivity extends BaseActivity {

    private RecyclerView rankList;
    private LinearLayoutManager layoutManager;
    private RankAdapter rankAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        rankList = findViewById(R.id.rank_list);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rankList.setLayoutManager(layoutManager);

        List<Kitty> kittyList = new ArrayList<>();

        kittyList.add(new Kitty());
        kittyList.add(new Kitty());
        kittyList.add(new Kitty());
        kittyList.add(new Kitty());
        kittyList.add(new Kitty());

        rankAdapter = new RankAdapter(kittyList);

        rankList.setAdapter(rankAdapter);
    }
}
