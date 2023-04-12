package edu.wit.mobileapp.ez_expense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class remindMe_Time extends AppCompatActivity {

    Button doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind_me_time);

        doneBtn = (Button) findViewById(R.id.doneBtnRemindTime);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRemindersCalendar();
            }
        });

    }

    public void openRemindersCalendar(){
        Intent intent = new Intent(this,remindersCalendar.class);
        startActivity(intent);
    }
}