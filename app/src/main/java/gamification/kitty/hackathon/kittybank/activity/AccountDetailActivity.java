package gamification.kitty.hackathon.kittybank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

import gamification.kitty.hackathon.kittybank.entity.User;
import gamification.kitty.hackathon.kittybank.utils.Utils;

public class AccountDetailActivity extends BaseActivity {
    private TextView tvAccountNumber;
    private TextView tvAccountFullName;
    private TextView tvAccountBalance;
    private TextView tvAccountSpendable;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);
        tvAccountNumber = findViewById(R.id.tvAccountNumber);
        tvAccountFullName = findViewById(R.id.tvAccountFullName);
        tvAccountBalance = findViewById(R.id.tvAccountBalance);
        tvAccountSpendable = findViewById(R.id.tvAccountSpendable);
        User user = Utils.getUserFromSharedPreference(this);
        tvAccountNumber.setText(user.getAccountNumber());
        tvAccountFullName.setText(user.getFullName());
        tvAccountBalance.setText(new DecimalFormat("#,###.##").format(user.getBalance()) + " VND");
        tvAccountSpendable.setText(new DecimalFormat("#,###.##").format(user.getBalance()) + " VND");
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountDetailActivity.this, TransactActivity.class));
            }
        });
    }
}
