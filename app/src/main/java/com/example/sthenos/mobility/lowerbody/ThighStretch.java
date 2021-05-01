package com.example.sthenos.mobility.lowerbody;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import com.example.sthenos.gadgets.Stopwatch;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.sthenos.R.drawable.thighstretch_standingononeleg;

public class ThighStretch extends AppCompatActivity {

    //Variables
    TextView exerciseTitle, muscleGroupText, descText;
    ImageView exerciseImage;
    Button stopWatch;
    BottomNavigationView bottomNavbar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_toolbar_mobility_activity);

        /*--------Hooks---------*/
        //Image
        exerciseImage = findViewById(R.id.imageViewForCollapsingToolBar);

        //TextView
        exerciseTitle = findViewById(R.id.exerciseTitleTextView);
        muscleGroupText = findViewById(R.id.muscleGroupDescTextView);
        descText = findViewById(R.id.descriptionTextTextView);

        //Buttons
        stopWatch = findViewById(R.id.btnStopWatch);

        /*---------Setting ImageView values--------------*/
        exerciseImage.setImageResource(thighstretch_standingononeleg);

        /*---------Setting TextView values--------------*/

        exerciseTitle.setText("Thigh stretch");

        muscleGroupText.setText("Thigh");

        descText.setText("Stretch your Thigh by keeping legs straight and leaning as far backwards as possible");

        /*---------Button onClickListener--------------*/

        stopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThighStretch.this, Stopwatch.class);
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
                        Intent indoor = new Intent(ThighStretch.this, IndoorActivity.class);
                        Toast.makeText(ThighStretch.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(indoor);
                        break;
                    case R.id.nav_outdoor:
                        Intent outdoor = new Intent(ThighStretch.this, OutdoorActivity.class);
                        Toast.makeText(ThighStretch.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(outdoor);
                        break;
                    case R.id.nav_home:
                        Intent home = new Intent(ThighStretch.this, MainActivity.class);
                        Toast.makeText(ThighStretch.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(home);
                        break;
                    case R.id.nav_mobility:
                        Intent mobility = new Intent(ThighStretch.this, MobilityActivity.class);
                        Toast.makeText(ThighStretch.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(mobility);
                        break;
                    case R.id.nav_equipment:
                        Intent equipment = new Intent(ThighStretch.this, Equipment.class);
                        Toast.makeText(ThighStretch.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(equipment);
                        break;
                }
                return true;
            }
        });
    }
}
