package com.example.sthenos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class Stopwatch extends AppCompatActivity {

    //Variables
    TextView titleText;
    ImageView arrow, circle;
    Button startbtn, stopbtn;
    Animation raundingalone;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        /*--------------------Hooks------------------*/
        //TextView
        titleText = findViewById(R.id.stopwatchTitleTextView);

        //ImageView
        arrow = findViewById(R.id.arrowImageView);
        circle = findViewById(R.id.circleImageView);

        //Button
        startbtn = findViewById(R.id.btnStart);
        stopbtn = findViewById(R.id.btnStop);

        //Chronometer
        chronometer = findViewById(R.id.timerHere);

        //Btn anim
        stopbtn.setAlpha(0);

        /*-----------------Load animations-----------*/
        raundingalone = AnimationUtils.loadAnimation(this,R.anim.raundingalone);

        /*-----------------OnClickListner------------*/
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing animation
                arrow.startAnimation(raundingalone);
                stopbtn.animate().alpha(1).setDuration(300).start();
                startbtn.animate().alpha(0).setDuration(300).start();
                //start timer
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });

        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stop timer
                chronometer.stop();
                //passing animation
                arrow.clearAnimation();
                stopbtn.animate().alpha(0).setDuration(300).start();
                startbtn.animate().alpha(1).setDuration(300).start();
            }
        });

    }
}