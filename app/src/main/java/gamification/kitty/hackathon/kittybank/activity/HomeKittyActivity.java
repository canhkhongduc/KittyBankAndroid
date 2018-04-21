package gamification.kitty.hackathon.kittybank.activity;

import android.os.Bundle;
import android.util.Log;

import com.twotoasters.android.horizontalimagescroller.image.ImageToLoad;
import com.twotoasters.android.horizontalimagescroller.image.ImageToLoadDrawableResource;
import com.twotoasters.android.horizontalimagescroller.widget.HorizontalImageScroller;
import com.twotoasters.android.horizontalimagescroller.widget.HorizontalImageScrollerAdapter;

import java.util.ArrayList;
import java.util.List;

import gamification.kitty.hackathon.kittybank.callback.IVolleyCallback;
import gamification.kitty.hackathon.kittybank.request.KittyRequestManagement;

public class HomeKittyActivity extends BaseActivity {
    KittyRequestManagement kittyRequestManagement;
    HorizontalImageScroller imageScroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_kitty);

        imageScroller = findViewById(R.id.pet_slider);
        List<ImageToLoad> images = new ArrayList<>();

        images.add(new ImageToLoadDrawableResource(R.drawable.dragon1));
        images.add(new ImageToLoadDrawableResource(R.drawable.dragon2));

        HorizontalImageScrollerAdapter adapter = new HorizontalImageScrollerAdapter(this, images);
        adapter.setImageSize(550);
        imageScroller.setAdapter(adapter);

        //test for get kitty request
        kittyRequestManagement = new KittyRequestManagement(getApplicationContext());
        kittyRequestManagement.getKittyById(new IVolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Log.d("test", result);
            }
            @Override
            public void onFailure(String result) {
                Log.d("test", result);
            }
        }, 1);
    }
}
