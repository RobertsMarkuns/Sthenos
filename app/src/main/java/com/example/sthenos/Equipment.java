package com.example.sthenos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sthenos.equipment.ParalletteBars;
import com.example.sthenos.equipment.PullUpBar;
import com.example.sthenos.equipment.Resistancebands;
import com.example.sthenos.equipment.WeightVest;
import com.example.sthenos.equipment.WristWraps;
import com.example.sthenos.indoor.pushups.PushUpSelection;

public class Equipment extends AppCompatActivity {

    //Variables
    CardView pullUpBar, paralletteBars, resistancebands, weightVest, wristWraps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);

        /*--------Hooks---------*/
        pullUpBar = findViewById(R.id.pullUpBarCardView);
        paralletteBars = findViewById(R.id.paralletteBarsCardView);
        resistancebands = findViewById(R.id.resistancebandsCardView);
        weightVest = findViewById(R.id.weightVestCardView);
        wristWraps = findViewById(R.id.wristWrapsCardView);

        /*---------CardView onClickListener--------------*/
        pullUpBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Equipment.this, PullUpBar.class);
                startActivity(intent);
                //finish();
            }
        });

        paralletteBars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Equipment.this, ParalletteBars.class);
                startActivity(intent);
                //finish();
            }
        });

        resistancebands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Equipment.this, Resistancebands.class);
                startActivity(intent);
                //finish();
            }
        });

        weightVest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Equipment.this, WeightVest.class);
                startActivity(intent);
                //finish();
            }
        });

        wristWraps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Equipment.this, WristWraps.class);
                startActivity(intent);
                //finish();
            }
        });

    }
}