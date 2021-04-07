package com.example.sthenos.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.sthenos.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UserProfile extends AppCompatActivity {

    //Variables
    TextInputLayout nameLayout, emailLayout,usernameLayout, passwordLayout;
    TextInputEditText nameText, emailText, usernameText, passwordText;
    TextView fullnameLabel, usernameLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This Line will make the status bar from the screen see through
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_user_profile);

        /*---------------------Hooks-------------------------*/
        //Layout
        nameLayout = findViewById(R.id.nameProfileLayout);
        emailLayout = findViewById(R.id.emailProfileLayout);
        usernameLayout = findViewById(R.id.usernameProfileLayout);
        passwordLayout = findViewById(R.id.passwordProfileLayout);

        //TextView/Label
        fullnameLabel = findViewById(R.id.full_nameLabel);
        usernameLabel = findViewById(R.id.usernameLabel);

        //TextInputEditText
        nameText = findViewById(R.id.nameProfileText);
        emailText = findViewById(R.id.emailProfileText);
        usernameText = findViewById(R.id.usernameProfileText);
        passwordText = findViewById(R.id.passwordProfileText);

        //Show all data
        //showAllUserData();

    }

    private void showAllUserData() {

        Intent intent = getIntent();
        String user_username = intent.getStringExtra(("username"));
        String user_name = intent.getStringExtra(("name"));
        String user_email = intent.getStringExtra(("email"));
        String user_password = intent.getStringExtra("password");

        //TextView
        fullnameLabel.setText(user_name);
        usernameLabel.setText(user_username);

        //InputText
        nameText.setText(user_name);
        emailText.setText(user_email);
        usernameText.setText(user_username);
        passwordText.setText(user_password);
    }
}