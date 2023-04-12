package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SalaryMain extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Button next;
    EditText salaryAmount;

    String[] items = {"Weekly", "Biweekly", "Monthly"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapter;
    Spinner salary_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_main);

        salary_spinner = (Spinner) findViewById(R.id.salarySpinner);
        adapter = new ArrayAdapter<String>(SalaryMain.this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        salary_spinner.setAdapter(adapter);
        salary_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: + " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        salaryAmount = (EditText) findViewById(R.id.earnAmountSalary_ET);

        next = (Button) findViewById(R.id.button_SM);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAnotherJob();
            }
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