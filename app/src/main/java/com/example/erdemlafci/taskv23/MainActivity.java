package com.example.erdemlafci.taskv23;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends Activity  {
    private Button button;
    private EditText edt1;
    private EditText edt2;
    private EditText edt3;
    private EditText edt4;
    private RadioGroup rg1;
    private Spinner mySpinner;
    private Calendar myCalendar;
    private int day,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        edt1 = (EditText) findViewById(R.id.editText);
        edt2 = (EditText) findViewById(R.id.editText2);
        edt3 = (EditText) findViewById(R.id.editText3);
        edt4 = (EditText) findViewById(R.id.editText4);
        rg1 = (RadioGroup)findViewById(R.id.radioGroup);
        mySpinner =(Spinner) findViewById(R.id.spinner);
        myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener datePickerDialog = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                MainActivity.this.day = dayOfMonth;
                MainActivity.this.month = monthOfYear+1;
                MainActivity.this.year = year;
                updateLabel();
            }

        };

        edt3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    new DatePickerDialog(MainActivity.this, datePickerDialog, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
                return true;
            }
        });





        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.add("Ankara");
        spinnerAdapter.add("İstanbul");
        spinnerAdapter.add("İzmir");
        spinnerAdapter.add("Antalya");
        spinnerAdapter.notifyDataSetChanged();





        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!edt1.getText().toString().equals("") && !edt2.getText().toString().equals("") && !edt3.getText().toString().equals("") && !edt4.getText().toString().equals("")) {
                    Intent i = new Intent(getApplicationContext(), IkinciActivity.class);
                    final String radiovalue = ((RadioButton)findViewById(rg1.getCheckedRadioButtonId())).getText().toString();
                    String spinnerdeger = mySpinner.getSelectedItem().toString();
                    i.putExtra("key1",edt1.getText().toString());
                    i.putExtra("key2",edt2.getText().toString());
                    i.putExtra("key3",edt3.getText().toString());
                    i.putExtra("key4",edt4.getText().toString());
                    i.putExtra("key5", radiovalue.toString());
                    i.putExtra("key6",spinnerdeger.toString());
                    i.putExtra("day",day);
                    i.putExtra("month",month);
                    i.putExtra("year", year);


                            startActivity(i);
                }

            }
        });

    }

    private void updateLabel() {

        edt3.setText(day+"."+month+"."+year);

    }
}