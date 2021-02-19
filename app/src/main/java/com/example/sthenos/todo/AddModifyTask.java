package com.example.sthenos.todo;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.sthenos.R;
import com.example.sthenos.database.DBHelper;
import com.example.sthenos.notification.TimePickerFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class AddModifyTask extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    //Variables
    Calendar calendar;
    DBHelper mydb;

    Boolean isModify = false, alarmSet = false;
    String task_id;
    TextView toolbar_title, dateText, btnSet, btnCancel;
    EditText edit_text;
    Button save_btn;
    LinearLayout setLayout, cancelLayout;

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_add_modify_task);

        /*-------------------------------Hooks------------------------------------------*/

        //DB and Calander
        mydb = new DBHelper(getApplicationContext());
        calendar = new GregorianCalendar();

        //Text
        toolbar_title = findViewById(R.id.toolbar_title);
        edit_text = findViewById(R.id.edit_text);
        dateText = findViewById(R.id.dateText);

        //Buttons
        save_btn = findViewById(R.id.save_btn);
        btnSet = findViewById(R.id.btnToDoSetReminder);
        btnCancel = findViewById(R.id.btnToDoCancelReminder);

        //Layout
        setLayout = findViewById(R.id.ToDoLayoutSet);
        cancelLayout = findViewById(R.id.ToDoLayoutCancel);


        //Set data format
        dateText.setText(new SimpleDateFormat("E, dd MMMM yyyy").format(calendar.getTime()));

        Intent intent = getIntent();
        if (intent.hasExtra("isModify")) {
            isModify = intent.getBooleanExtra("isModify", false);
            task_id = intent.getStringExtra("id");
            init_modify();
        }

        /*---------------------------onClickListener------------------------------------------*/

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "reminder picker");
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { cancelAlarm(); }
        });


    }

    /*----------------------------------Functions-------------------------------------*/

    @SuppressLint({"SimpleDateFormat", "SetTextI18n"})
    public void init_modify() {
        toolbar_title.setText("Modify Task");
        save_btn.setText("Update");
        LinearLayout deleteTask = findViewById(R.id.deleteTask);
        deleteTask.setVisibility(View.VISIBLE);
        Cursor task = mydb.getSingleTask(task_id);
        if (task != null) {
            task.moveToFirst();


            edit_text.setText(task.getString(1));

            SimpleDateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                calendar.setTime(Objects.requireNonNull(iso8601Format.parse(task.getString(2))));
            } catch (ParseException e) {
            }

            dateText.setText(new SimpleDateFormat("E, dd MMMM yyyy").format(calendar.getTime()));


        }

    }


    @SuppressLint("SimpleDateFormat")
    public void saveTask(View v) {

        /*Checking for Empty Task*/
        if (edit_text.getText().toString().trim().length() > 0) {

            if (isModify) {
                mydb.updateTask(task_id, edit_text.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
                Toast.makeText(getApplicationContext(), "Task Updated.", Toast.LENGTH_SHORT).show();
            } else {
                mydb.insertTask(edit_text.getText().toString(), new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
                Toast.makeText(getApplicationContext(), "Task Added.", Toast.LENGTH_SHORT).show();
            }
            finish();

        } else {
            Toast.makeText(getApplicationContext(), "Empty task can't be saved.", Toast.LENGTH_SHORT).show();
        }

    }

    public void deleteTask(View v) {
        mydb.deleteTask(task_id);
        Toast.makeText(getApplicationContext(), "Task Removed", Toast.LENGTH_SHORT).show();
        finish();
    }


    public void chooseDate(View view) {
        final View dialogView = View.inflate(this, R.layout.date_picker, null);
        final DatePicker datePicker = dialogView.findViewById(R.id.date_picker);
        datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));


        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        builder.setTitle("Choose Date");
        builder.setNegativeButton("Cancel", null);
        builder.setPositiveButton("Set", new DialogInterface.OnClickListener() {
            @SuppressLint("SimpleDateFormat")
            public void onClick(DialogInterface dialog, int id) {


                calendar = new GregorianCalendar(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                dateText.setText(new SimpleDateFormat("E, dd MMMM yyyy").format(calendar.getTime()));

            }
        });
        builder.show();
    }

    /*-------------------------------Reminder for To Do List------------------------------------*/

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        startAlarm(c);
        alarmSet = Boolean.TRUE;
        if (alarmSet){
            setLayout.setVisibility(View.GONE);
            cancelLayout.setVisibility(View.VISIBLE);
        }else {
            setLayout.setVisibility(View.VISIBLE);
            cancelLayout.setVisibility(View.GONE);
        }
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiverToDoList.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }

    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiverToDoList.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        alarmManager.cancel(pendingIntent);
        setLayout.setVisibility(View.VISIBLE);
        cancelLayout.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "Alarm canceled", Toast.LENGTH_SHORT).show();
    }
}
