package gamification.kitty.hackathon.kittybank.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import gamification.kitty.hackathon.kittybank.R;
import gamification.kitty.hackathon.kittybank.entity.User;
import gamification.kitty.hackathon.kittybank.utils.Utils;

public class HomeActivity extends AppCompatActivity {
    private TextView tvUserFullname;
    private TextView tvAccountNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvUserFullname = findViewById(R.id.tvUserFullname);
        tvAccountNumber = findViewById(R.id.tvUserCIF);
        User user = Utils.getUserFromSharedPreference(this);
        tvUserFullname.setText(user.getFullName());
        tvAccountNumber.setText("CIF: " + user.getAccountNumber());
    }
}
