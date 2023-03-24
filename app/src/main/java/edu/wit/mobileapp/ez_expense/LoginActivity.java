package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button loginBtn;
    DBSQlite DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1_ET);
        password = (EditText) findViewById(R.id.password1_ET);
        loginBtn = (Button) findViewById(R.id.login_Btn);
        DB = new DBSQlite(this);

        /* stores variables */
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                /* if fields are empty
                   if not then if username and password entered match one in database stored*/
                if(user.equals("") || pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass = DB.checkUsernamePassword(user,pass);
                    /* if username and password entered match  user and pass stored in database (information exists) display
                       successful sign in toast message and will send user to Home Activity

                       if user pass dont match stored values display invalid credential values */
                    if(checkuserpass == true) {
                        Toast.makeText(LoginActivity.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}