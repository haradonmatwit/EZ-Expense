package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RegistrationWelcomePage extends AppCompatActivity {

    TextView welcome, user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_welcome_page);

        welcome = findViewById(R.id.welcome_TV);

        user = findViewById(R.id.username_ARTV);


        Intent i = getIntent();
        String username = i.getStringExtra("USERNAME");
        user.setText(username);
    }
}