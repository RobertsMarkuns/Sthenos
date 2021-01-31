package com.example.sthenos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sthenos.indoor.pushups.PushUpSelection;

public class IndoorActivity extends AppCompatActivity {

    //Variables
    CardView pushupIndoorCardView, weightsCardView, absIndoorCardView,
            jumpIndoorCardView, squatsIndoorCardView, pullupsIndoorCardView,
            cardioInddorCardView, balanceIndoorCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoor);

        /*--------Hooks---------*/
        pushupIndoorCardView = findViewById(R.id.PushUpIndoorCardView);
        weightsCardView = findViewById(R.id.WeightsCardView);
        absIndoorCardView = findViewById(R.id.AbsIndoorCardView);
        jumpIndoorCardView = findViewById(R.id.JumpIndoorCardView);
        squatsIndoorCardView = findViewById(R.id.SquatIndoorCardView);
        pullupsIndoorCardView = findViewById(R.id.PullUpIndoorCardView);
        cardioInddorCardView = findViewById(R.id.CardioIndoorCardView);
        balanceIndoorCardView = findViewById(R.id.BalanceIndoorCardView);


        /*---------CardView onClickListener--------------*/
        pushupIndoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndoorActivity.this, PushUpSelection.class);
                startActivity(intent);
                //finish();
            }
        });

        weightsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, WeightLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        absIndoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, AbsLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        jumpIndoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, JumpLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        squatsIndoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, SquatsLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        pullupsIndoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, PullUpIndoorLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        cardioInddorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, CardioLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        balanceIndoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, BalanceLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });


    }
}