package com.example.sthenos.equipment;

import android.content.Intent;
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

import static com.example.sthenos.R.drawable.parallettessthenos;
import static com.example.sthenos.R.drawable.wristwraps;

public class ParalletteBars extends AppCompatActivity {

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
        productImage.setImageResource(parallettessthenos);

        /*---------Setting TextView values--------------*/
        productTitle.setText("Parallettes");
        priceTag.setText("29.99$");
        descText.setText("Need good and stable bars to make your exercises more efficient?" +
                "We got you covered with our metal parallettes! These parallettes will help you" +
                "improve Handstands, Planches and Push ups!");

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
                        Intent indoor = new Intent(ParalletteBars.this, IndoorActivity.class);
                        Toast.makeText(ParalletteBars.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(indoor);
                        break;
                    case R.id.nav_outdoor:
                        Intent outdoor = new Intent(ParalletteBars.this, OutdoorActivity.class);
                        Toast.makeText(ParalletteBars.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(outdoor);
                        break;
                    case R.id.nav_home:
                        Intent home = new Intent(ParalletteBars.this, MainActivity.class);
                        Toast.makeText(ParalletteBars.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(home);
                        break;
                    case R.id.nav_mobility:
                        Intent mobility = new Intent(ParalletteBars.this, MobilityActivity.class);
                        Toast.makeText(ParalletteBars.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(mobility);
                        break;
                    case R.id.nav_equipment:
                        Intent equipment = new Intent(ParalletteBars.this, Equipment.class);
                        Toast.makeText(ParalletteBars.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        startActivity(equipment);
                        break;
                }
                return true;
            }
        });

    }
}
