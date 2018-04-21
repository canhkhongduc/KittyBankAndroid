package gamification.kitty.hackathon.kittybank.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import gamification.kitty.hackathon.kittybank.R;
import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.entity.User;
import gamification.kitty.hackathon.kittybank.request.LoginRequestManagement;
import gamification.kitty.hackathon.kittybank.utils.Utils;

public class LoginActivity extends AppCompatActivity {
    private EditText etAccount;
    private EditText etPassword;
    private Button submitButton;
    LoginRequestManagement lrm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etAccount = findViewById(R.id.input_account);
        etPassword = findViewById(R.id.input_password);
        lrm = new LoginRequestManagement(getApplicationContext());
        submitButton = findViewById(R.id.btn_login);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final User user = new User(etAccount.getText().toString(), etPassword.getText().toString());
                Log.d("user", user.getAccountNumber());
                lrm.authenticate(new IVolleyCallback() {
                    @Override
                    public void onSuccess(String result) {
                        Utils.saveUserToSharedPreferences(getApplicationContext(), user);
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    }
                }, user);
            }
        });
    }
}
