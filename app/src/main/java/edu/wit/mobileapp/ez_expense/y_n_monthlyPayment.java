package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class y_n_monthlyPayment extends AppCompatActivity {

    Button yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yn_monthly_payment);

        yes = (Button) findViewById(R.id.button);
        no = (Button) findViewById(R.id.button2);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRemindersCalendar();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeActivity();
            }
        });
    }

    public void openRemindersCalendar(){
        Intent intent = new Intent(this,remindersCalendar.class);
        startActivity(intent);
    }

    public void openHomeActivity(){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}