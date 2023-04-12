package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnotherActivity extends AppCompatActivity {

    Button yes, no;
    String billName, dueDate, paymentLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Intent i = getIntent();
        billName = i.getStringExtra("BILL");
        dueDate = i.getStringExtra("DATE");
        paymentLink = i.getStringExtra("BILL");

        yes = (Button) findViewById(R.id.yesBTnAnotherActivity);
        no = (Button) findViewById(R.id.noBtnAnotherActivity);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMonthlyPayment();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //openHomeActivity();
                openHomeActivity(billName,dueDate,paymentLink);
            }
        });
    }

    public void openMonthlyPayment(){
        Intent intent = new Intent(this,y_n_monthlyPayment.class);
        startActivity(intent);
    }

    public void openHomeActivity(String billname, String duedate, String paymentlink){
        Intent intent = new Intent(this,HomeActivity.class);
        intent.putExtra("BILL",billname);
        intent.putExtra("DATE", duedate);
        intent.putExtra("LINK",paymentlink);
        startActivity(intent);
    }

    /*
     public void openHomeActivity(){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }*/
}