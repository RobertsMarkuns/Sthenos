package com.example.sthenos.outdoor.cardio;

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

import static com.example.sthenos.R.drawable.jumprope;

public class JumpRopeOutdoor extends AppCompatActivity {

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
        exerciseImage.setImageResource(jumprope);

        /*---------Setting TextView values--------------*/

        exerciseTitle.setText("Jump Rope");

        levelTag.setText("None");
        levelTag.setBackground(Drawable.createFromPath("@drawable/gradient_cyangreen"));

        muscleGroupText.setText("Wrists, Legs, Core, Cardio");

        descText.setText("Jump with both legs together and body straight. Once you feel comfortable " +
                "jumping with legs together be sure to find other ways to jump rope like running on the spot or " +
                "by twisting the rope or just by speeding up and slowing down the speed of the rope." +
                "There are many skills to be learned and an ideal way to lose weight or keep yourself in a good shape " +
                " make sure to stay straight and engage your entire body.");

        /*---------Button onClickListener--------------*/
        repRandomizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JumpRopeOutdoor.this, RepRangeRandomizer.class);
                startActivity(intent);
            }
        });

        stopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JumpRopeOutdoor.this, Stopwatch.class);
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
                        Intent indoor = new Intent(JumpRopeOutdoor.this, IndoorActivity.class);
                        Toast.makeText(JumpRopeOutdoor.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(indoor);
                        break;
                    case R.id.nav_outdoor:
                        Intent outdoor = new Intent(JumpRopeOutdoor.this, OutdoorActivity.class);
                        Toast.makeText(JumpRopeOutdoor.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(outdoor);
                        break;
                    case R.id.nav_home:
                        Intent home = new Intent(JumpRopeOutdoor.this, MainActivity.class);
                        Toast.makeText(JumpRopeOutdoor.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(home);
                        break;
                    case R.id.nav_mobility:
                        Intent mobility = new Intent(JumpRopeOutdoor.this, MobilityActivity.class);
                        Toast.makeText(JumpRopeOutdoor.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(mobility);
                        break;
                    case R.id.nav_equipment:
                        Intent equipment = new Intent(JumpRopeOutdoor.this, Equipment.class);
                        Toast.makeText(JumpRopeOutdoor.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(equipment);
                        break;
                }
                return true;
            }
        });
    }
}
