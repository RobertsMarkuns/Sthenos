package com.example.sthenos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

public class OutdoorActivity extends AppCompatActivity {

    //variables
    CardView pushupsOutdoorCardView, plankCardView, absOutdoorCardView, jumpOutdoorCardView,
    balanceOutdoorCardView, squatsOutdoorCardView, pullupsOutdoorCardView, cardioOutdoorCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor);


        /*--------Hooks---------*/
        pushupsOutdoorCardView = findViewById(R.id.PushUpOutdoorCardView);
        plankCardView = findViewById(R.id.PlankCardView);
        absOutdoorCardView = findViewById(R.id.AbsOutdoorCardView);
        jumpOutdoorCardView = findViewById(R.id.JumpOutdoorCardView);
        balanceOutdoorCardView = findViewById(R.id.BalanceOutdoorCardView);
        squatsOutdoorCardView = findViewById(R.id.SquatsOutdoorCardView);
        pullupsOutdoorCardView = findViewById(R.id.PullUpOutdoorCardView);
        cardioOutdoorCardView = findViewById(R.id.CardioOutdoorCardView);


        /*---------CardView onClickListener--------------*/

        pushupsOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, PushUpLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        plankCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, PlankLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        absOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, AbsLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        jumpOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, JumpLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        balanceOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, SquatsLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        squatsOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, PullUpOutdoorLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        pullupsOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, CardioLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });

        cardioOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(IndoorActivity.this, BalanceLibrary.class);
                //startActivity(intent);
                //finish();
            }
        });



    }

}