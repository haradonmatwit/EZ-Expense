package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoreJobs extends AppCompatActivity {

    Button yesBtn,noBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_jobs);

        yesBtn = (Button) findViewById(R.id.yesBtnMOreJobs);
        noBtn = (Button) findViewById(R.id.noBtnMoreJob);

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWorkLocation();
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMonthlyPayments();
            }
        });
    }

    public void openWorkLocation() {
        Intent intent = new Intent(this, WorkLocationQ.class);
        startActivity(intent);
    }

    public void openMonthlyPayments() {
        Intent intent = new Intent(this, y_n_monthlyPayment.class);
        startActivity(intent);
    }
}