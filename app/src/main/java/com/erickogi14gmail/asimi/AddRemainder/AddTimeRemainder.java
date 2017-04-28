package com.erickogi14gmail.asimi.AddRemainder;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.erickogi14gmail.asimi.Data.DBHandler;
import com.erickogi14gmail.asimi.Data.DBKeys;
import com.erickogi14gmail.asimi.Data.DBOperations;
import com.erickogi14gmail.asimi.Data.DBPojo;
import com.erickogi14gmail.asimi.Fragments.DatePickerFragment;
import com.erickogi14gmail.asimi.Fragments.TimePickerFragment;
import com.erickogi14gmail.asimi.MainActivity;
import com.erickogi14gmail.asimi.R;

public class AddTimeRemainder extends AppCompatActivity
                implements DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener{


    DBOperations mDBOperations;
    DBPojo pojo;

    private int pickerHour, pickerMin, pickerYear, pickerDay, pickerMonth;
    TextView txtDate, txtTime;

    Button mSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time_remainder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mSet = (Button) findViewById(R.id.set_reminder);
        mDBOperations = new DBOperations(this);
        mDBOperations.open();


        storeData();

    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        pickerYear = year;
        pickerMonth = month;
        pickerDay = dayOfMonth;

        txtDate = (TextView) findViewById(R.id.set_date);
        displayDate();
    }
    public void showTimePicker(View v){
        DialogFragment timeFragment = new TimePickerFragment();
        timeFragment.show(getFragmentManager(), "Time Picker");
    }

    public void showDatePicker(View v){
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getFragmentManager(), "Date Picker");
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            pickerHour = hourOfDay;
            pickerMin = minute;
        txtTime = (TextView) findViewById(R.id.set_time);
        displayTime();
    }

    public void displayTime(){
        String time = String.valueOf(pickerHour)+ ":"+ String.valueOf(pickerMin);

        txtTime.setText(time);
    }

    public void displayDate(){
        String date = String.valueOf(pickerDay)+ ", "+String.valueOf(pickerMonth)+", "+String.valueOf(pickerYear);

        txtDate.setText(date);
    }

    public void storeData(){
        mSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText reminderTitle = (EditText) findViewById(R.id.input_reminder_title);
                final EditText reminderMsg = (EditText) findViewById(R.id.input_reminder_msg);
                String mTitle = reminderTitle.getText().toString();
                String mMsg = reminderMsg.getText().toString();

                int time = Integer.valueOf(String.valueOf(pickerYear)+String.valueOf(pickerMonth)+String.valueOf(pickerDay)+
                        String.valueOf(pickerHour)+String.valueOf(pickerMin));

                String none = "none";

                mDBOperations.insertData(mTitle, mMsg, none, none, none, none, none, time);
                Toast.makeText( AddTimeRemainder.this, " Reminder was set successfully " +time, Toast.LENGTH_LONG).show();

                mDBOperations.getTimeList();


            }
        });
    }



}
