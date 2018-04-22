package gamification.kitty.hackathon.kittybank.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import gamification.kitty.hackathon.kittybank.adapter.CustomHistoryListAdapter;
import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.entity.ItemStore;
import gamification.kitty.hackathon.kittybank.entity.Transaction;
import gamification.kitty.hackathon.kittybank.entity.User;
import gamification.kitty.hackathon.kittybank.request.TransactionRequestManagement;
import gamification.kitty.hackathon.kittybank.utils.Utils;

public class HistoryActivity extends AppCompatActivity {
    private RecyclerView rvHistory;
    private List<Transaction> transactions;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        rvHistory = findViewById(R.id.rvHistory);
        final User user = Utils.getUserFromSharedPreference(this);
        TransactionRequestManagement trm = new TransactionRequestManagement(this);
        trm.getTransactions(new IVolleyCallback() {
            @Override
            public void onSuccess(String result) {
                //User user = Utils.getUserFromSharedPreference(getApplicationContext());
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                transactions = gson.fromJson(result, new TypeToken<List<Transaction>>(){}.getType());
                CustomHistoryListAdapter adapter = new CustomHistoryListAdapter(getApplicationContext(), transactions, user);
                LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                llm.setOrientation(LinearLayout.VERTICAL);
                rvHistory.setLayoutManager(llm);
                rvHistory.setAdapter(adapter);
            }

            @Override
            public void onFailure(String message) {

            }
        }, user.getAccountNumber());
     btnBack = findViewById(R.id.btn_back_to_transact);
     btnBack.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            startActivity(new Intent(HistoryActivity.this, TransactActivity.class));
         }
     });
    }
}
