package com.example.sthenos.outdoor.plank;

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

import static com.example.sthenos.R.drawable.plank;
import static com.example.sthenos.R.drawable.regularplank;

public class RegularPlank extends AppCompatActivity {

    //Variables
    TextView exerciseTitle, levelTag, muscleGroupText, descText;
    ImageView exerciseImage;
    Button repRandomizer, stopWatch;
    BottomNavigationView bottomNavbar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_toolbar_outdoor_activity);

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
        exerciseImage.setImageResource(regularplank);

        /*---------Setting TextView values--------------*/

        exerciseTitle.setText("Regular plank");

        levelTag.setText("Novice");
        levelTag.setBackground(Drawable.createFromPath("@drawable/gradient_cyangreen"));

        muscleGroupText.setText("Back, Shoulders");

        descText.setText("Make sure your hands are 90 degrees and you should be extend your shoulders downwards and " +
                "remember to keep your body straight");

        /*---------Button onClickListener--------------*/
        repRandomizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegularPlank.this, RepRangeRandomizer.class);
                startActivity(intent);
            }
        });

        stopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegularPlank.this, Stopwatch.class);
                startActivity(intent);
            }
        });

        //Bottom Navigation Bar
        bottomNavbar = findViewById(R.id.BottomNavBar);

        bottomNavbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_indoor:
                        Intent indoor = new Intent(RegularPlank.this, IndoorActivity.class);
                        Toast.makeText(RegularPlank.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(indoor);
                        break;
                    case R.id.nav_outdoor:
                        Intent outdoor = new Intent(RegularPlank.this, OutdoorActivity.class);
                        Toast.makeText(RegularPlank.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(outdoor);
                        break;
                    case R.id.nav_home:
                        Intent home = new Intent(RegularPlank.this, MainActivity.class);
                        Toast.makeText(RegularPlank.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(home);
                        break;
                    case R.id.nav_mobility:
                        Intent mobility = new Intent(RegularPlank.this, MobilityActivity.class);
                        Toast.makeText(RegularPlank.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(mobility);
                        break;
                    case R.id.nav_equipment:
                        Intent equipment = new Intent(RegularPlank.this, Equipment.class);
                        Toast.makeText(RegularPlank.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(equipment);
                        break;
                }
                return true;
            }
        });
    }
}
