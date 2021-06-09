package com.example.sthenos.database;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sthenos.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignUpActivity extends AppCompatActivity {

    //Variables
    ImageView logo;
    TextView welcome, descrip;
    TextInputLayout fullnameTextInputLayout, emailTextInputLayout, usernameTextInputLayout,
            passwordTextInputLayout;
    TextInputEditText fullnameTextInputEditText, emailTextInputEditText, usernameTextInputEditText,
            passwordTextInputEditText;
    Button btnSignUp, btnLoginHere;
    ProgressBar progressBar;
    RelativeLayout pgSignUpLayout;

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
        pgSignUpLayout = findViewById(R.id.progressBarSignUpLayout);

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

        //ProgressBar
        progressBar = findViewById(R.id.progressBarSignUp);

        //On button click opens Login with animation
        btnLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(logo, "logoAnim");
                pairs[1] = new Pair<View, String>(welcome, "welcomeAnim");
                pairs[2] = new Pair<View, String>(descrip, "subTextAnim");
                pairs[3] = new Pair<View, String>(usernameTextInputLayout, "userAnim");
                pairs[4] = new Pair<View, String>(passwordTextInputLayout, "passAnim");
                pairs[5] = new Pair<View, String>(btnSignUp, "btnAnim");
                pairs[6] = new Pair<View, String>(btnLoginHere, "logSignAnim");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });

        /*------------------------------MySQL------------------------------------------------------*/

        btnSignUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String fullname, username, password, email;
            fullname = String.valueOf(fullnameTextInputEditText.getText());
            username = String.valueOf(usernameTextInputEditText.getText());
            password = String.valueOf(passwordTextInputEditText.getText());
            email = String.valueOf(emailTextInputEditText.getText());

            if (!fullname.equals("") && !username.equals("") && !password.equals("") && !email.equals("")){

                pgSignUpLayout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[4];
                        field[0] = "fullname";
                        field[1] = "username";
                        field[2] = "password";
                        field[3] = "email";

                        String[] data = new String[4];
                        data[0] = fullname;
                        data[1] = username;
                        data[2] = password;
                        data[3] = email;

                        PutData putData = new PutData("http://IPv4Adress:8080/SthenosPHP/signup.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {

                                pgSignUpLayout.setVisibility(View.INVISIBLE);
                                progressBar.setVisibility(View.INVISIBLE);
                                String result = putData.getResult();

                                if(result.equals("Sign Up Success")){

                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                    finish();

                                }else{
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                });
            } else {
                Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }
}