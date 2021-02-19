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

import com.example.sthenos.MainActivity;
import com.example.sthenos.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class LoginActivity extends AppCompatActivity {

    //Variables
    ImageView logo;
    TextView Welcome, Descrip;
    TextInputLayout usernameTextInputLayout, passwordTextInputLayout;
    TextInputEditText usernameTextInputEditText, passwordTextInputEditText;
    Button btnLogin, btnSignUpHere;
    ProgressBar progressBar;
    RelativeLayout pgLoginLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*---------------------Hooks---------------------*/
        //logo
        logo = findViewById(R.id.logoLoginImageView);

        //Layout
        usernameTextInputLayout = findViewById(R.id.usernameLoginLayout);
        passwordTextInputLayout = findViewById(R.id.passwordLoginLayout);
        pgLoginLayout = findViewById(R.id.progressBarLoginLayout);

        //Text
        Welcome = findViewById(R.id.welcomeLoginTextView);
        Descrip = findViewById(R.id.subLoginTextView);
        usernameTextInputEditText = findViewById(R.id.usernameLoginInputEditText);
        passwordTextInputEditText = findViewById(R.id.passwordLoginInputEditText);

        //Buttons
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUpHere = findViewById(R.id.btnSignUpHere);

        //ProgressBar
        progressBar = findViewById(R.id.progressBarLogin);

        /*------------------onClickListener-----------------*/

        //ONLY FOR DEV, DELETE BEFORE PUSHING TO GIT OR FINAL PROJECT SEND IN
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //On button click opens sign up
        btnSignUpHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);

                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(logo, "logoAnim");
                pairs[1] = new Pair<View, String>(Welcome, "welcomeAnim");
                pairs[2] = new Pair<View, String>(Descrip, "subTextAnim");
                pairs[3] = new Pair<View, String>(usernameTextInputLayout, "userAnim");
                pairs[4] = new Pair<View, String>(passwordTextInputLayout, "passAnim");
                pairs[5] = new Pair<View, String>(btnLogin, "btnAnim");
                pairs[6] = new Pair<View, String>(btnSignUpHere, "logSignAnim");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });

        //On button click Will take inputs and check with DB to Login user
        /*------------------------------MySQL------------------------------------------------------*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String  username, password;
                username = String.valueOf(usernameTextInputEditText.getText());
                password = String.valueOf(passwordTextInputEditText.getText());

                if (!username.equals("") && !password.equals("")){
                    pgLoginLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.VISIBLE);

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";

                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;

                            PutData putData = new PutData("http://192.168.43.53:8080/Sthenos/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {

                                    pgLoginLayout.setVisibility(View.INVISIBLE);
                                    progressBar.setVisibility(View.INVISIBLE);
                                    String result = putData.getResult();

                                    if(result.equals("Login Success")){

                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
