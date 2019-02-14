package com.example.daisy.lightsout;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    int clickCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final ImageButton lightsImg1 = (ImageButton) findViewById(R.id.lightsImg1);
        final ImageView lightsImg2 = (ImageView) findViewById(R.id.lightsImg2);
        final ImageView lightsImg3 = (ImageView) findViewById(R.id.lightsImg3);

        final AlphaAnimation animation1 = new AlphaAnimation(0f, 1.0f);
        animation1.setDuration(500);
        animation1.setStartOffset(500);
        animation1.setFillAfter(true);

        final AlphaAnimation animation2 = new AlphaAnimation(1.0f, 0f);
        animation2.setDuration(500);
        animation2.setStartOffset(500);
        animation2.setFillAfter(true);
        final ToggleButton lightSwitch = (ToggleButton) findViewById(R.id.lightSwitch);
        lightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                TextView resultText = (TextView) findViewById(R.id.resultText);
                clickCounter = clickCounter+1;
                resultText.setText(Integer.toString(clickCounter));

                TextView tooManyClicks  = (TextView) findViewById(R.id.tooManyClicks);
                if(clickCounter >= 100) {
                    tooManyClicks.setText("Haven't you clicked me enough?");
                }

                if(isChecked) {
                    lightSwitch.setChecked(true);

                    lightsImg1.setVisibility(View.VISIBLE);
                    lightsImg2.setVisibility(View.VISIBLE);
                    lightsImg3.setVisibility(View.VISIBLE);

                    lightsImg1.startAnimation(animation1);
                    lightsImg2.startAnimation(animation1);
                    lightsImg3.startAnimation(animation1);

                }else {
                    lightSwitch.setChecked(false);

                    lightsImg1.setVisibility(View.INVISIBLE);
                    lightsImg2.setVisibility(View.INVISIBLE);
                    lightsImg3.setVisibility(View.INVISIBLE);

                    lightsImg1.startAnimation(animation2);
                    lightsImg2.startAnimation(animation2);
                    lightsImg3.startAnimation(animation2);

                }

            }
        });
    }

}
