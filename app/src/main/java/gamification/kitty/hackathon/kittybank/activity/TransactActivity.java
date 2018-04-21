package gamification.kitty.hackathon.kittybank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class TransactActivity extends BaseActivity {
    private CardView cvAccount;
    private CardView cvMoneyTransact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transact);
        cvAccount = findViewById(R.id.cvAccount);
        cvAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TransactActivity.this, AccountDetailActivity.class));
            }
        });
        cvMoneyTransact = findViewById(R.id.cvMoneyTransact);
        cvMoneyTransact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TransactActivity.this, TransactMoneyActivity.class));
            }
        });
    }
}
