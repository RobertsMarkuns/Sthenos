package com.example.sthenos.indoor.pushups;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sthenos.Equipment;
import com.example.sthenos.IndoorActivity;
import com.example.sthenos.MainActivity;
import com.example.sthenos.MobilityActivity;
import com.example.sthenos.OutdoorActivity;
import com.example.sthenos.R;
import com.example.sthenos.RepRangeRandomizer;
import com.example.sthenos.Stopwatch;
import com.example.sthenos.UserProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.sthenos.R.drawable.inclinepushups;

public class InclinePushUp extends AppCompatActivity {

    //Variables
    TextView exerciseTitle, levelTag, muscleGroupText, descText;
    ImageView exerciseImage;
    Button repRandomizer, stopWatch;
    BottomNavigationView bottomNavbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_toolbar_activity);

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
        exerciseImage.setImageResource(inclinepushups);

        /*---------Setting TextView values--------------*/

        exerciseTitle.setText("Incline push-ups (Level 1)");

        levelTag.setText("Novice");
        levelTag.setBackground(Drawable.createFromPath("@drawable/gradient_cyangreen"));

        muscleGroupText.setText("Triceps, Chest");

        descText.setText("Push-up with your arms aloft in relation to feet, you can use a bench or a bar." +
                "The higher the bar or the bench, the easier. The lower the harder it is to push up.");

        /*---------Button onClickListener--------------*/
        repRandomizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InclinePushUp.this, RepRangeRandomizer.class);
                startActivity(intent);
            }
        });

        stopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InclinePushUp.this, Stopwatch.class);
                startActivity(intent);
            }
        });

        //Bottom Navigation Bar
        bottomNavbar = findViewById(R.id.BottomNavBar);

        bottomNavbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_indoor:
                        Intent indoor = new Intent(InclinePushUp.this, IndoorActivity.class);
                        Toast.makeText(InclinePushUp.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(indoor);
                        break;
                    case R.id.nav_outdoor:
                        Intent outdoor = new Intent(InclinePushUp.this, OutdoorActivity.class);
                        Toast.makeText(InclinePushUp.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(outdoor);
                        break;
                    case R.id.nav_home:
                        Intent home = new Intent(InclinePushUp.this, MainActivity.class);
                        Toast.makeText(InclinePushUp.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(home);
                        break;
                    case R.id.nav_mobility:
                        Intent mobility = new Intent(InclinePushUp.this, MobilityActivity.class);
                        Toast.makeText(InclinePushUp.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(mobility);
                        break;
                    case R.id.nav_equipment:
                        Intent equipment = new Intent(InclinePushUp.this, Equipment.class);
                        Toast.makeText(InclinePushUp.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(equipment);
                        break;
                }
                return true;
            }
        });
    }
}