package com.example.sthenos.indoor.pullups;

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

import static com.example.sthenos.R.drawable.jumppullups;
import static com.example.sthenos.R.drawable.negativepullups;

public class JumpPullUps extends AppCompatActivity {

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
        exerciseImage.setImageResource(jumppullups);

        /*---------Setting TextView values--------------*/

        exerciseTitle.setText("Negative Pull Ups");

        levelTag.setText("Rookie");
        levelTag.setBackground(Drawable.createFromPath("@drawable/gradient_cyangreen"));

        muscleGroupText.setText("Biceps, Back");

        descText.setText("Get on top of the bar by jumping on it. Then slowly go down to train the" +
                "necessary muscles to learn the regular pull up");

        /*---------Button onClickListener--------------*/
        repRandomizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JumpPullUps.this, RepRangeRandomizer.class);
                startActivity(intent);
            }
        });

        stopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JumpPullUps.this, Stopwatch.class);
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
                        Intent indoor = new Intent(JumpPullUps.this, IndoorActivity.class);
                        Toast.makeText(JumpPullUps.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(indoor);
                        break;
                    case R.id.nav_outdoor:
                        Intent outdoor = new Intent(JumpPullUps.this, OutdoorActivity.class);
                        Toast.makeText(JumpPullUps.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(outdoor);
                        break;
                    case R.id.nav_home:
                        Intent home = new Intent(JumpPullUps.this, MainActivity.class);
                        Toast.makeText(JumpPullUps.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(home);
                        break;
                    case R.id.nav_mobility:
                        Intent mobility = new Intent(JumpPullUps.this, MobilityActivity.class);
                        Toast.makeText(JumpPullUps.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(mobility);
                        break;
                    case R.id.nav_equipment:
                        Intent equipment = new Intent(JumpPullUps.this, Equipment.class);
                        Toast.makeText(JumpPullUps.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(equipment);
                        break;
                }
                return true;
            }
        });
    }
}
