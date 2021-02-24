package com.example.sthenos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sthenos.indoor.squats.SquatSelection;
import com.example.sthenos.outdoor.abs.AbSelectionOutdoor;
import com.example.sthenos.outdoor.balance.BalanceSelectionOutdoor;
import com.example.sthenos.outdoor.cardio.CardioSelectionOutdoor;
import com.example.sthenos.outdoor.jump.JumpSelectionOutdoor;
import com.example.sthenos.outdoor.plank.PlankSelection;
import com.example.sthenos.outdoor.pullups.PullUpSelectionOutdoor;
import com.example.sthenos.outdoor.pushups.PushUpSelectionOutdoor;
import com.example.sthenos.outdoor.squats.SquatSelectionOutdoor;

public class OutdoorActivity extends AppCompatActivity {

    //variables
    CardView pushupsOutdoorCardView, plankCardView, absOutdoorCardView, jumpOutdoorCardView,
    balanceOutdoorCardView, squatsOutdoorCardView, pullupsOutdoorCardView, cardioOutdoorCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor);


        /*---------------------------Hooks--------------------------------------*/
        pushupsOutdoorCardView = findViewById(R.id.PushUpOutdoorCardView);
        plankCardView = findViewById(R.id.PlankCardView);
        absOutdoorCardView = findViewById(R.id.AbsOutdoorCardView);
        jumpOutdoorCardView = findViewById(R.id.JumpOutdoorCardView);
        balanceOutdoorCardView = findViewById(R.id.BalanceOutdoorCardView);
        squatsOutdoorCardView = findViewById(R.id.SquatsOutdoorCardView);
        pullupsOutdoorCardView = findViewById(R.id.PullUpOutdoorCardView);
        cardioOutdoorCardView = findViewById(R.id.CardioOutdoorCardView);


        /*--------------------CardView onClickListener----------------------------*/

        pushupsOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OutdoorActivity.this, PushUpSelectionOutdoor.class);
                startActivity(intent);
                //finish();
            }
        });

        plankCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OutdoorActivity.this, PlankSelection.class);
                startActivity(intent);
                //finish();
            }
        });

        absOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OutdoorActivity.this, AbSelectionOutdoor.class);
                startActivity(intent);
                //finish();
            }
        });

        jumpOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OutdoorActivity.this, JumpSelectionOutdoor.class);
                startActivity(intent);
                //finish();
            }
        });

        balanceOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OutdoorActivity.this, BalanceSelectionOutdoor.class);
                startActivity(intent);
                //finish();
            }
        });

        squatsOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OutdoorActivity.this, SquatSelectionOutdoor.class);
                startActivity(intent);
                //finish();
            }
        });

        pullupsOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OutdoorActivity.this, PullUpSelectionOutdoor.class);
                startActivity(intent);
                //finish();
            }
        });

        cardioOutdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OutdoorActivity.this, CardioSelectionOutdoor.class);
                startActivity(intent);
                //finish();
            }
        });

    }
}