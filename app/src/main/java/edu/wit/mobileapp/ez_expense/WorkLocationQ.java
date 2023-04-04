package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WorkLocationQ extends AppCompatActivity {

    TextView welcome, user, workLocationQuestion;
    EditText workLocation;
    Button nextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_location_q);

        welcome = (TextView) findViewById(R.id.welcomeTV_WLQ);
        user = (TextView) findViewById(R.id.username_WLQ);
        workLocationQuestion = (TextView) findViewById(R.id.workLocationQuestion_TV);
        workLocation = (EditText) findViewById(R.id.workLocationName_ET);
        nextBtn = (Button) findViewById(R.id.nextBtn_WLQ);

        Intent i = getIntent();
        String username = i.getStringExtra("USERNAME");
        user.setText(username);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorkPositionQ(user, workLocation);
            }
        });
    }

    public void openWorkPositionQ(TextView user, EditText workLocation) {
        Intent intent = new Intent(this, WorkPositionQ.class);
        /* Gets text from TextView and assigns it to String variable*/
        String u = user.getText().toString();
        intent.putExtra("USERNAME", u);

        /* Gets text from EditText and assigns it to String variable*/
        intent.putExtra("WorkLocation",workLocation.getText().toString());
        startActivity(intent);
    }
}