package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    String billName, dueDate, paymentLink;
    TextView bill, duedate, paymentlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent i = getIntent();
        billName = i.getStringExtra("BILL");
        dueDate = i.getStringExtra("DATE");
        paymentLink = i.getStringExtra("LINK");

        bill = (TextView) findViewById(R.id.billnameTV);
        bill.setText(billName);
        duedate = (TextView) findViewById(R.id.billduedate_TV);
        duedate.setText(dueDate);
        paymentlink = (TextView) findViewById(R.id.paymentlinkTV);
        paymentlink.setText(paymentLink);


    }
}