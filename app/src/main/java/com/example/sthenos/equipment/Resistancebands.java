package com.example.sthenos.equipment;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sthenos.R;

import static com.example.sthenos.R.drawable.resistancebands1;
import static com.example.sthenos.R.drawable.weightveststhenos;

public class Resistancebands extends AppCompatActivity {

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
        productImage.setImageResource(resistancebands1);

        /*---------Setting TextView values--------------*/
        productTitle.setText("ResistanceBand");
        priceTag.setText("9.99$");
        descText.setText("Make your workouts harder with our resistance band that you can use for any" +
                "exercise to make it more difficult and your gains more rewarding!");

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
