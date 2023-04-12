package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class PayFreqHourly extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Button nextBtn;
    String[] items = {"Weekly", "Biweekly", "Monthly"};
    ArrayAdapter<String> adapter;
    Spinner pfh_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_freq_hourly);

         pfh_spinner = (Spinner) findViewById(R.id.spinnerPFH);
        adapter = new ArrayAdapter<String>(PayFreqHourly.this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pfh_spinner.setAdapter(adapter);
        pfh_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: + " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        nextBtn = (Button) findViewById(R.id.button_PFH);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openAnotherJob(); }
        });
    }

    public void openAnotherJob() {
        Intent intent = new Intent(this, MoreJobs.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}