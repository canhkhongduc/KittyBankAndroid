package gamification.kitty.hackathon.kittybank.kitty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import gamification.kitty.hackathon.kittybank.R;
import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.request.KittyRequestManagement;

public class HomeKittyActivity extends AppCompatActivity {
    KittyRequestManagement kittyRequestManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_kitty);
        //test for get kitty request
        kittyRequestManagement = new KittyRequestManagement(getApplicationContext());
        kittyRequestManagement.getKitties(new IVolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Log.d("test",result);
            }
        });
    }
}