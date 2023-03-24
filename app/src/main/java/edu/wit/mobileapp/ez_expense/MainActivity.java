package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button makeAccountButton, signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* Initializes buttons */
        makeAccountButton = (Button) findViewById(R.id.create_an_account_button);
        signIn = (Button) findViewById(R.id.sign_in_button);

        /* Sign-In Button Listener*/
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });

        /* Once the "Create an Account" button is clicked, activity AccountCreation
           will be opened*/
        makeAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccountCreation();
            }
        });
    }

    public void openAccountCreation() {
        Intent intent = new Intent(this, AccountCreation.class);
        startActivity(intent);
    }

    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}