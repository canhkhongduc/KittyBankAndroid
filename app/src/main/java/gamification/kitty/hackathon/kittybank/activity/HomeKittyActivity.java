package gamification.kitty.hackathon.kittybank.activity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.twotoasters.android.horizontalimagescroller.image.ImageToLoad;
import com.twotoasters.android.horizontalimagescroller.image.ImageToLoadDrawableResource;
import com.twotoasters.android.horizontalimagescroller.widget.HorizontalImageScroller;
import com.twotoasters.android.horizontalimagescroller.widget.HorizontalImageScrollerAdapter;

import java.util.ArrayList;
import java.util.List;

import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.entity.Kitty;
import gamification.kitty.hackathon.kittybank.request.KittyRequestManagement;

public class HomeKittyActivity extends BaseActivity {
    KittyRequestManagement kittyRequestManagement;
    HorizontalImageScroller imageScroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_kitty);

        imageScroller = findViewById(R.id.pet_slider);

        //test for get kitty request
        kittyRequestManagement = new KittyRequestManagement(getApplicationContext());
        kittyRequestManagement.getKittiesByUserId(new IVolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                List<Kitty> kitties = gson.fromJson(result, new TypeToken<List<Kitty>>(){}.getType());
                List<ImageToLoad> images = new ArrayList<>();
                for(Kitty kitty: kitties){
                    int drawableResourceId = HomeKittyActivity.this.getResources().getIdentifier(kitty.getImage(), "drawable", HomeKittyActivity.this.getPackageName());
                    images.add(new ImageToLoadDrawableResource(drawableResourceId));
                }

                HorizontalImageScrollerAdapter adapter = new HorizontalImageScrollerAdapter(HomeKittyActivity.this, images);
                adapter.setImageSize(550);
                imageScroller.setAdapter(adapter);
            }
            @Override
            public void onFailure(String result) {
                Log.d("test", result);
            }
        }, 1);
    }
}
