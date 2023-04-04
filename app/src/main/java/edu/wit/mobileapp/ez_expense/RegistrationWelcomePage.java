package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegistrationWelcomePage extends AppCompatActivity {

    TextView welcome, user, message;
    Button nextBT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_welcome_page);

        welcome = (TextView) findViewById(R.id.welcome_TV);
        user = (TextView) findViewById(R.id.username_ARTV);
        message = (TextView) findViewById(R.id.welcome_TV);
        nextBT = (Button) findViewById(R.id.nextBtn_ARW_page);


        Intent i = getIntent();
        String username = i.getStringExtra("USERNAME");
        user.setText(username);

        nextBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorkLocationQ(user);
            }
        });
    }

    public void openWorkLocationQ(TextView user) {
        Intent intent = new Intent(this, WorkLocationQ.class);
        /* Gets text from TextView and assigns it to String variable*/
        String u = user.getText().toString();
        intent.putExtra("USERNAME", u);
        startActivity(intent);
    }
}

