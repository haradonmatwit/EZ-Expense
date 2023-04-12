package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class EarningsPage extends AppCompatActivity {

    private CheckBox checkBoxA, checkBoxB, checkBoxC;
    Button salaryBtn, hourlyBtn;
    EditText dayEarnings, eveningEarnings, nightEarnings, earnings;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earnings_page);

        dayEarnings = (EditText) findViewById(R.id.dayEarnings_ET);
        eveningEarnings = (EditText) findViewById(R.id.eveningEarnings_ET);
        nightEarnings = (EditText) findViewById(R.id.nightEarnings_ET);

        checkBoxA = (CheckBox) findViewById(R.id.checkBoxA);
        checkBoxB = (CheckBox) findViewById(R.id.checkBoxB);
        checkBoxC = (CheckBox) findViewById(R.id.checkBoxC);

        if(((CheckBox)checkBoxA).isChecked()) {
            earnings = (EditText) findViewById(R.id.dayEarnings_ET);
        } else if (((CheckBox)checkBoxB).isChecked()) {
            earnings = (EditText) findViewById(R.id.eveningEarnings_ET);
        } else {
            earnings = (EditText) findViewById(R.id.nightEarnings_ET);
        }

        /* Gets username from previous activity*/
       /* Intent i = getIntent();
        String username = i.getStringExtra("USERNAME");
        user.setText(username); */

        salaryBtn = (Button) findViewById(R.id.salary_button);
        hourlyBtn = (Button) findViewById(R.id.hourly_button);

        salaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //openSalaryMain(user, earnings);
                openSalaryMain();
            }
        });

        hourlyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //openPayFreqHourly(user, earnings);
                openPayFreqHourly();
            }
        });
    }

    /* allows only 1 checkbox to be checked off at a time */
    public void onCheckboxClicked(View view) {

        switch(view.getId()) {

            case R.id.checkBoxA:

                checkBoxB.setChecked(false);
                checkBoxC.setChecked(false);

                break;

            case R.id.checkBoxB:

                checkBoxC.setChecked(false);
                checkBoxA.setChecked(false);

                break;

            case R.id.checkBoxC:

                checkBoxA.setChecked(false);
                checkBoxB.setChecked(false);

                break;
        }
    }

    public void openSalaryMain() {
        Intent intent = new Intent(this, SalaryMain.class);
        startActivity(intent);


    }

    /* earnings amount and username are passed onto PayFreqHourly */
    public void openPayFreqHourly() {
        Intent intent = new Intent(this, PayFreqHourly.class);
        startActivity(intent);

    }

    /* earnings amount and username are passed onto SalaryMain */
//    public void openSalaryMain(TextView user, EditText earningsAmount) {
//        Intent intent = new Intent(this, SalaryMain.class);
//        startActivity(intent);
//        String u = user.getText().toString();
//        String e = earningsAmount.getText().toString();
//        intent.putExtra("USERNAME", u);
//        intent.putExtra("EARNINGSAMOUNT", e);
//
//    }
//
//    /* earnings amount and username are passed onto PayFreqHourly */
//    public void openPayFreqHourly(TextView user, EditText earningsAmount) {
//        Intent intent = new Intent(this, PayFreqHourly.class);
//        startActivity(intent);
//        String u = user.getText().toString();
//        String e = earningsAmount.getText().toString();
//        intent.putExtra("USERNAME", u);
//        intent.putExtra("EARNINGSAMOUNT", e);
//    }
}