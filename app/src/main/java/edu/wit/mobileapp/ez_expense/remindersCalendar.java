package edu.wit.mobileapp.ez_expense;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class remindersCalendar extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Button next, remindMe;

    String[] items = {"Utilities", "Rent/Mortgage", "Subscription", "Other"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapter;
    Spinner bill_spinner;

    CalendarView calendar_View;
    TextView bill_due_date;

    EditText paymentLink, billName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders_calendar);

        billName = (EditText) findViewById(R.id.billName_ET);

        bill_spinner = (Spinner) findViewById(R.id.billSpinner);
        adapter = new ArrayAdapter<String>(remindersCalendar.this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bill_spinner.setAdapter(adapter);
        bill_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: + " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calendar_View = (CalendarView) findViewById(R.id.calendarView);
        bill_due_date = (TextView) findViewById(R.id.billDueDate);

        calendar_View.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String dueDate = (month+1)+"/"+dayOfMonth+"/"+year;
                Log.d("bill_due_date", dueDate);
                bill_due_date.setText(dueDate);
            }
        });

        paymentLink = (EditText) findViewById(R.id.paymentLink_ET);
        paymentLink.setMovementMethod(LinkMovementMethod.getInstance());

        next = (Button) findViewById(R.id.remindersNext_btn);
        //remindMe = (Button) findViewById(R.id.remindMe_btn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openAnotherActivity(billName,bill_due_date,paymentLink);
                //openAnotherActivity();
            }
        });

       /* remindMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRemindMeTime();
            }
        }); */

    }

    public void openAnotherActivity(EditText billname, TextView duedate, EditText paymentlink){
        Intent intent = new Intent(this,AnotherActivity.class);
        String bill = billname.getText().toString();
        String date = duedate.getText().toString();
        String link = paymentlink.getText().toString();
        intent.putExtra("BILL",bill);
        intent.putExtra("DATE", date);
        intent.putExtra("LINK",link);
        startActivity(intent);
    }

    public void openRemindMeTime(){
        Intent intent = new Intent(this,remindMe_Time.class);
        startActivity(intent);
    }

    /*
     public void openAnotherActivity(){
        Intent intent = new Intent(this,AnotherActivity.class);
        startActivity(intent);
    }

    public void openRemindMeTime(){
        Intent intent = new Intent(this,remindMe_Time.class);
        startActivity(intent);
    }
    */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}