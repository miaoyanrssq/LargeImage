package cn.zgy.large;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.io.IOException;
import java.io.InputStream;

import cn.zhy.largeimage.another.map.ImageSurfaceView;

public class TestActivity extends AppCompatActivity {

    ImageSurfaceView worldview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_test);

        worldview = findViewById(R.id.worldview);
        showView();
    }

    private void showView() {
        try{
            InputStream inputStream = getAssets().open("qm.jpg");
            worldview.setInputStream(inputStream);
            worldview.setViewportCenter();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
