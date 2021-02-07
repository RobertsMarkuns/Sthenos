package com.example.sthenos.gadgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sthenos.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Random;

public class RepRangeRandomizer extends AppCompatActivity {

    //Variables
    TextView titleRandomTextView, resultTextView;
    TextInputLayout minLayout, maxLayout;
    TextInputEditText minText, maxText;
    Button rollbtn;

    Random rand;
    int min, max , output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_range_randomizer);

        /*------------------Random------------------*/

        rand = new Random();

        /*------------------Hooks------------------*/
        //Text Views
        titleRandomTextView = findViewById(R.id.RrrTitleTextView);
        resultTextView = findViewById(R.id.numRandResultTextView);

        //Layout text
        minLayout = findViewById(R.id.minInputLayoutView);
        maxLayout = findViewById(R.id.maxInputLayoutView);

        //TextEditTextView
        minText = findViewById(R.id.minInputTextView);
        maxText = findViewById(R.id.maxInputTextView);

        //Buttons
        rollbtn = findViewById(R.id.btnRoll);


        /*-------------------OnClickListeners--------------*/
        rollbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempMin, tempMax;
                tempMin = minText.getText().toString();
                tempMax = maxText.getText().toString();

                if(!tempMin.equals("")&& !tempMax.equals("")) {
                    min = Integer.parseInt(tempMin);
                    max = Integer.parseInt(tempMax);

                    if(max > min) {
                        output = rand.nextInt((max - min) + 1) + min;
                        resultTextView.setText("" + output);
                    }
                }
            }
        });

    }
}