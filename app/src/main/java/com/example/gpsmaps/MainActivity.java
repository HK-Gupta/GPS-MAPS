package com.example.gpsmaps;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView splashIMG;
    TextView logoName, developerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Google Maps");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#344955"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Animation topAnimation = AnimationUtils.loadAnimation(this, R.anim.top);
        Animation bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom);

        splashIMG = findViewById(R.id.splashImg);
        logoName = findViewById(R.id.logoName);
        developerName = findViewById(R.id.developerName);


        splashIMG.setAnimation(topAnimation);
        logoName.setAnimation(bottomAnimation);
        developerName.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        }, 3000);

    }
}