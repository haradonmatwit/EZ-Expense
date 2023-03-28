package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountCreation extends AppCompatActivity {

    EditText username, email, password, confirmPassword;
    Button submit;
    DBSQlite DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);

        username = (EditText) findViewById(R.id.username_ET);
        email = (EditText) findViewById(R.id.email_ET);
        password = (EditText) findViewById(R.id.password_ET);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword_ET);
        submit = (Button) findViewById(R.id.submit_Btn);
        DB = new DBSQlite(this);

        /* Submit Button Listener*/
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String em = email.getText().toString();
                String pass = password.getText().toString();
                String repass = confirmPassword.getText().toString();

                /* checking if any of the edit text boxes are empty
                   if empty it will show tost message
                   else if all edit text boxes have some value it will go for checking whether user exists or not*/
                if(user.equals("") || em.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(AccountCreation.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    /* checks whether the two passwords match
                       if matching, we have username and two passwords matching
                       then will check if username exists*/
                    if(pass.equals(repass)) {
                        /* check in database if user already exists or not */
                        Boolean checkuser = DB.checkUsername(user);

                        /* if user does not exist, data will be inserted
                           function will execute the insertion of the data of the given name, email, and password
                            if checkuser return true display message toast that user already exists*/
                        if(checkuser == false ) {
                            Boolean insert = DB.insertData(user, em, pass);

                            /*if database has been writen a toast will be shown and will go to Home Activity
                              if not then say toast message registration failed*/
                            if(insert == true) {
                                Toast.makeText(AccountCreation.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), RegistrationWelcomePage.class);
                                intent.putExtra("USERNAME", user);
                                startActivity(intent);
                            } else {
                                Toast.makeText(AccountCreation.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(AccountCreation.this, "User alreasy exist! Please Sign In", Toast.LENGTH_SHORT).show();

                        } /* end of checkuser if statement */



                    } else {

                        /* display message that passwords do not match
                           if they do not match it will not allow user to enter the database */
                        Toast.makeText(AccountCreation.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();


                    }
                }
            }
        });

    }
}