package com.example.sthenos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.sthenos.database.SignUpActivity;
import com.example.sthenos.database.UserProfile;
import com.example.sthenos.notification.NotificantonActivity;
import com.example.sthenos.todo.ToDoActivity;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    CardView mobilityCardView, outdoorCardView, indoorCardView, equipmentCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This Line will make the status bar from the screen see through 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);

        /*---------------------------Hooks------------------------------------------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        mobilityCardView = findViewById(R.id.mobilityCardView);
        outdoorCardView = findViewById(R.id.outdoorCardView);
        indoorCardView = findViewById(R.id.indoorCardView);
        equipmentCardView = findViewById(R.id.equipmentCardView);

        /*--------------------------Toolbar----------------------------------------------*/
        setSupportActionBar(toolbar);

        /*---------------------Navigation Drawer Menu-----------------------------------*/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

        /*--------------------CardView onClickListener----------------------------------*/
        mobilityCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MobilityActivity.class);
                startActivity(intent);
                //finish();
            }
        });

        outdoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IndoorActivity.class);
                startActivity(intent);
                //finish();
            }
        });

        indoorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OutdoorActivity.class);
                startActivity(intent);
                //finish();
            }
        });

        equipmentCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Equipment.class);
                startActivity(intent);
                //finish();
            }
        });

    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    /*---------------------------------Navigation-------------------------------------------*/
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_mobility:
                Intent mobility = new Intent(MainActivity.this,MobilityActivity.class);
                startActivity(mobility);
                break;
            case R.id.nav_indoor:
                Intent indoor = new Intent(MainActivity.this,IndoorActivity.class);
                startActivity(indoor);
                break;
            case R.id.nav_outdoor:
                Intent outdoor = new Intent(MainActivity.this,OutdoorActivity.class);
                startActivity(outdoor);
                break;
            case R.id.nav_equipment:
                Intent equipment = new Intent(MainActivity.this,Equipment.class);
                startActivity(equipment);
                break;
            case R.id.nav_profile:
                Intent profile = new Intent(MainActivity.this, UserProfile.class);
                startActivity(profile);
                break;
            case R.id.nav_notification:
                Intent notification = new Intent(MainActivity.this, NotificantonActivity.class);
                startActivity(notification);
                break;
            case R.id.nav_todo:
                Intent todo = new Intent(MainActivity.this, ToDoActivity.class);
                startActivity(todo);
                break;
            case R.id.nav_logout:
                Intent logout = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(logout);
                finish();
                break;
            case R.id.nav_share:
                Toast.makeText(getApplicationContext(),"Link saved to clipboard",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_rate:
                Toast.makeText(getApplicationContext(),"Thank you for rating us!",Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}