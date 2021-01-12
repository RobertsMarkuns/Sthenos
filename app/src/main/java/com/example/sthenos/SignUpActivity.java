package com.example.sthenos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    //Variables
    ImageView logo;
    TextView welcome, descrip;
    TextInputLayout fullnameTextInputLayout, emailTextInputLayout, usernameTextInputLayout, passwordTextInputLayout;
    TextInputEditText fullnameTextInputEditText, emailTextInputEditText, usernameTextInputEditText, passwordTextInputEditText;
    Button btnSignUp, btnLoginHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        /*---------------------Hooks---------------------*/
        //Image
        logo = findViewById(R.id.logoSignUpImageView);


        //Layout
        fullnameTextInputLayout = findViewById(R.id.fullNameSignUpLayout);
        emailTextInputLayout = findViewById(R.id.emailSignUpLayout);
        usernameTextInputLayout = findViewById(R.id.usernameSignUpLayout);
        passwordTextInputLayout = findViewById(R.id.passwordSignUpLayout);

        //Text
        welcome = findViewById(R.id.welcomeSignUpTextView);
        descrip = findViewById(R.id.subSignUpTextView);
        fullnameTextInputEditText = findViewById(R.id.fullNameSignUpInputEditText);
        emailTextInputEditText = findViewById(R.id.emailSignUpInputEditText);
        usernameTextInputEditText = findViewById(R.id.usernameSignUpInputEditText);
        passwordTextInputEditText = findViewById(R.id.passwordSignUpInputEditText);

        //Buttons
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLoginHere = findViewById(R.id.btnLoginHere);

        /*-----------onClickListener--------------*/

        //On button click opens Login
        btnLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View,String>(logo, "logoAnim");
                pairs[1] = new Pair<View,String>(welcome, "welcomeAnim");
                pairs[2] = new Pair<View,String>(descrip, "subTextAnim");
                pairs[3] = new Pair<View,String>(usernameTextInputLayout, "userAnim");
                pairs[4] = new Pair<View,String>(passwordTextInputLayout, "passAnim");
                pairs[5] = new Pair<View,String>(btnSignUp, "btnAnim");
                pairs[6] = new Pair<View,String>(btnLoginHere, "logSignAnim");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this,pairs);
                startActivity(intent, options.toBundle());
            }
        });


    }
}