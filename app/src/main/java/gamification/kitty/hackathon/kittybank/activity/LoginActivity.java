package gamification.kitty.hackathon.kittybank.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import gamification.kitty.hackathon.kittybank.R;
import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.entity.User;
import gamification.kitty.hackathon.kittybank.request.LoginRequest;
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
                String accountNumber = etAccount.getText().toString();
                String password = etPassword.getText().toString();
                if (accountNumber.length() != 0 && password.length() != 0) {
                    final User user = new User(accountNumber, password);
                    lrm.authenticate(new IVolleyCallback() {
                        @Override
                        public void onSuccess(String result) {
                            try {
                                Log.d("json", result);
                                Gson gson = new Gson();
                                LoginRequest loginRequest = gson.fromJson(result, LoginRequest.class);
                                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                                java.util.Date dob = sdf1.parse(loginRequest.getDob());
                                java.sql.Date dobSqlDate = new java.sql.Date(dob.getTime());
                                User user1 = new User();
                                user1.setId(loginRequest.getId());
                                user1.setAccountNumber(loginRequest.getAccountNumber());
                                user1.setFullName(loginRequest.getFullName());
                                user1.setDob(dobSqlDate);
                                user1.setBalance(loginRequest.getBalance());
                                user1.setCreditPoint(loginRequest.getCreditPoint());
                                Utils.saveUserToSharedPreferences(getApplicationContext(), user1);
                                startActivity(new Intent(LoginActivity.this, BankActivity.class));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(String message) {
                            Toast.makeText(getApplicationContext(), "Xin vui lòng nhập lại số tài khoản và mật khẩu", Toast.LENGTH_LONG).show();
                        }
                    }, user);
                } else {
                    Toast.makeText(getApplicationContext(), "Xin vui lòng nhập lại số tài khoản và mật khẩu", Toast.LENGTH_LONG).show();
                }
                final User user = new User(etAccount.getText().toString(), etPassword.getText().toString());
                Log.d("user", user.getAccountNumber());
                lrm.authenticate(new IVolleyCallback() {
                    @Override
                    public void onSuccess(String result) {
                        Utils.saveUserToSharedPreferences(getApplicationContext(), user);
                        startActivity(new Intent(LoginActivity.this, BankActivity.class));
                    }
                    @Override
                    public void onFailure(String result) {
                        Toast.makeText(getApplicationContext(), "Xin vui lòng nhập lại số tài khoản và mật khẩu", Toast.LENGTH_LONG).show();
                    }
                }, user);
            }
        });

    }
}
