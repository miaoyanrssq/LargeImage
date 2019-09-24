package cn.zgy.large;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.io.IOException;
import java.io.InputStream;

import cn.zhy.largeimage.LargeImageView;

public class MainActivity extends AppCompatActivity {

    LargeImageView largeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        largeImageView = findViewById(R.id.large);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));

            }
        });
        showView();
    }

    private void showView() {
        try{
            InputStream inputStream = getAssets().open("qm.jpg");
            largeImageView.setInputStream(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
