package com.example.sthenos.equipment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
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
import com.example.sthenos.indoor.pushups.InclinePushUp;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.sthenos.R.drawable.inclinepushups;
import static com.example.sthenos.R.drawable.wristwraps;

public class WristWraps extends AppCompatActivity {

    //Variables
    TextView productTitle, priceTag, descText;
    ImageView productImage;
    Button addToCart;
    BottomNavigationView bottomNavbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This Line will make the status bar from the screen see through
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.collapsing_toolbar_equipment_activity);

        /*--------Hooks---------*/
        //Image
        productImage = findViewById(R.id.productImageView);

        //TextView
        productTitle = findViewById(R.id.productTitleTextView);
        priceTag = findViewById(R.id.priceTagTextView);
        descText = findViewById(R.id.productDescriptionTextTextView);

        //Buttons
        addToCart = findViewById(R.id.btnAddToCart);

        //Bottom Navigation Bar
        bottomNavbar = findViewById(R.id.BottomNavBar);

        /*---------Setting ImageView values--------------*/
        productImage.setImageResource(wristwraps);

        /*---------Setting TextView values--------------*/
        productTitle.setText("Wrist wraps");
        priceTag.setText("19.99$");
        descText.setText("Support your wrists with these comfortable wrist wraps! These wrist wraps" +
                "will help reduce stress on your wrists helping you workout longer and with no wrist pain," +
                "making it easier to put more control in your hands!");

        /*---------Button onClickListener--------------*/
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), " Item Added To Cart", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        bottomNavbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_indoor:
                        Intent indoor = new Intent(WristWraps.this, IndoorActivity.class);
                        Toast.makeText(WristWraps.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(indoor);
                        break;
                    case R.id.nav_outdoor:
                        Intent outdoor = new Intent(WristWraps.this, OutdoorActivity.class);
                        Toast.makeText(WristWraps.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(outdoor);
                        break;
                    case R.id.nav_home:
                        Intent home = new Intent(WristWraps.this, MainActivity.class);
                        Toast.makeText(WristWraps.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(home);
                        break;
                    case R.id.nav_mobility:
                        Intent mobility = new Intent(WristWraps.this, MobilityActivity.class);
                        Toast.makeText(WristWraps.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(mobility);
                        break;
                    case R.id.nav_equipment:
                        Intent equipment = new Intent(WristWraps.this, Equipment.class);
                        Toast.makeText(WristWraps.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(equipment);
                        break;
                }
                return true;
            }
        });

    }
}
