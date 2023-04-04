package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WorkPositionQ extends AppCompatActivity {

    TextView welcome, user, workPositionQuestion;
    EditText workPosition;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_position_q);

        welcome = (TextView) findViewById(R.id.welcomeTV_WPQ);
        user = (TextView) findViewById(R.id.username_WPQ);
        workPositionQuestion = (TextView) findViewById(R.id.workPositionQuestion_TV);
        workPosition = (EditText) findViewById(R.id.workPositionName_ET);
        nextBtn = (Button) findViewById(R.id.nextBtn_WPQ);

        Intent i = getIntent();
        String username = i.getStringExtra("USERNAME");
        user.setText(username);

        /* String jobPosition = i.getStringExtra() --> get job location from previous activity ?*/

        /*nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorkPositionQ(user, workLocation);
            }
        });*/

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEarningsPage();
            }
        });
    }

    public void openEarningsPage() {
        Intent intent = new Intent(this, EarningsPage.class);
        startActivity(intent);
    }
}