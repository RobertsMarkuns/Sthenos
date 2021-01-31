package com.example.sthenos.equipment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sthenos.R;

import static com.example.sthenos.R.drawable.inclinepushups;
import static com.example.sthenos.R.drawable.wristwraps;

public class WristWraps extends AppCompatActivity {

    //Variables
    TextView productTitle, priceTag, descText;
    ImageView productImage;
    Button addToCart;

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

    }
}
