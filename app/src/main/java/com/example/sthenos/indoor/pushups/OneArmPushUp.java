package com.example.sthenos.indoor.pushups;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sthenos.Equipment;
import com.example.sthenos.IndoorActivity;
import com.example.sthenos.MainActivity;
import com.example.sthenos.MobilityActivity;
import com.example.sthenos.OutdoorActivity;
import com.example.sthenos.R;
import com.example.sthenos.gadgets.RepRangeRandomizer;
import com.example.sthenos.gadgets.Stopwatch;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.sthenos.R.drawable.onearmpushups;

public class OneArmPushUp extends AppCompatActivity {

    //Variables
    TextView exerciseTitle, levelTag, muscleGroupText, descText;
    ImageView exerciseImage;
    Button repRandomizer, stopWatch;
    BottomNavigationView bottomNavbar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_toolbar_indoor_activity);

        /*--------Hooks---------*/
        //Image
        exerciseImage = findViewById(R.id.imageViewForCollapsingToolBar);

        //TextView
        exerciseTitle = findViewById(R.id.exerciseTitleTextView);
        levelTag = findViewById(R.id.levelTagTextView);
        muscleGroupText = findViewById(R.id.muscleGroupDescTextView);
        descText = findViewById(R.id.descriptionTextTextView);

        //Buttons
        repRandomizer = findViewById(R.id.btnRepRandomizer);
        stopWatch = findViewById(R.id.btnStopWatch);

        /*---------Setting ImageView values--------------*/
        exerciseImage.setImageResource(onearmpushups);

        /*---------Setting TextView values--------------*/

        exerciseTitle.setText("One arm push-ups (Level 65)");

        levelTag.setText("Advanced");
        levelTag.setBackground(Drawable.createFromPath("@drawable/gradient_cyangreen"));

        muscleGroupText.setText("Triceps, Chest, Shoulder");

        descText.setText("Put your legs wide for balance and your arm behind your back");

        /*---------Button onClickListener--------------*/
        repRandomizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneArmPushUp.this, RepRangeRandomizer.class);
                startActivity(intent);
            }
        });

        stopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneArmPushUp.this, Stopwatch.class);
                startActivity(intent);
            }
        });

        //Bottom Navigation Bar
        bottomNavbar = findViewById(R.id.BottomNavBar);

        bottomNavbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_indoor:
                        Intent indoor = new Intent(OneArmPushUp.this, IndoorActivity.class);
                        Toast.makeText(OneArmPushUp.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(indoor);
                        break;
                    case R.id.nav_outdoor:
                        Intent outdoor = new Intent(OneArmPushUp.this, OutdoorActivity.class);
                        Toast.makeText(OneArmPushUp.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(outdoor);
                        break;
                    case R.id.nav_home:
                        Intent home = new Intent(OneArmPushUp.this, MainActivity.class);
                        Toast.makeText(OneArmPushUp.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(home);
                        break;
                    case R.id.nav_mobility:
                        Intent mobility = new Intent(OneArmPushUp.this, MobilityActivity.class);
                        Toast.makeText(OneArmPushUp.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(mobility);
                        break;
                    case R.id.nav_equipment:
                        Intent equipment = new Intent(OneArmPushUp.this, Equipment.class);
                        Toast.makeText(OneArmPushUp.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(equipment);
                        break;
                }
                return true;
            }
        });
    }
}
