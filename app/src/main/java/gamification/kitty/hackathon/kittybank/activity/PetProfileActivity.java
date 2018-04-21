package gamification.kitty.hackathon.kittybank.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.text.ParseException;

import butterknife.BindView;
import butterknife.ButterKnife;
import gamification.kitty.hackathon.kittybank.R;
import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.entity.Kitty;
import gamification.kitty.hackathon.kittybank.request.KittyRequestManagement;

public class PetProfileActivity extends AppCompatActivity {

    private KittyRequestManagement kittyRequestManagement;

    private final int HUNGRY_RATE = 1;  // lose 1 point of hunger per minute (60.000 milli seconds)
    private final int HYGIENE_RATE = 1; // lose 1 point of hygiene per minute (60.000 milli seconds)

    private Kitty kitty;

    @BindView(R.id.progressBarHunger)
    ProgressBar progressBarHunger;
    @BindView(R.id.progressBarHygiene)
    ProgressBar progressBarHygiene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_profile);
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
                Log.d("HelloKitty", result);

                try {
                    pseudoCode(kitty);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }, 1); // TODO: change this to dynamic id later


    }

    private void pseudoCode(Kitty kitty) throws ParseException {
        this.kitty = kitty;

        progressBarHunger.setProgress(kitty.getHunger());
        progressBarHygiene.setProgress(kitty.getHygiene());

        // Before perform activity close, send the updated hunger/hygiene value to the server
    }

    private void loadKittyInfoToView() {
        // TODO: implement after view is completed
    }

    private void feedPet(int foodId) {
        kittyRequestManagement.feedKittyRequest(new IVolleyCallback() {
            @Override
            public void onSuccess(String result) {

            }
        }, kitty.getId(), foodId);
    }

    private void bathPet() {
        kittyRequestManagement.bathKittyRequest(new IVolleyCallback() {
            @Override
            public void onSuccess(String result) {

            }
        }, kitty.getId());
    }
}
