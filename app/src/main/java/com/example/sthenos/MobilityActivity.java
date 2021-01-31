package com.example.sthenos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sthenos.mobility.LowerBodySelection;
import com.example.sthenos.mobility.UpperBodySelection;

public class MobilityActivity extends AppCompatActivity {

    //variables
    CardView upperCardView, lowerCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobility);

        /*--------Hooks---------*/
        upperCardView = findViewById(R.id.UpperbodyCardView);
        lowerCardView = findViewById(R.id.LowerbodyCardView);

        /*---------CardView onClickListener--------------*/
        upperCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MobilityActivity.this, UpperBodySelection.class);
                startActivity(intent);
                //finish();
            }
        });

        lowerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MobilityActivity.this, LowerBodySelection.class);
                startActivity(intent);
                //finish();
            }
        });

    }
}