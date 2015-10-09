package com.example.erdemlafci.taskv23;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends Activity  {
    private EditText Date;

    private DatePickerDialog DatePickerDialog;

    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        findViewsById();

        setDateTimeField();

    }
        private void findViewsById() {
        Date = (EditText) findViewById(R.id.editText3);
        Date.setInputType(InputType.TYPE_NULL);
        Date.requestFocus();


        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.add("Ankara");
        spinnerAdapter.add("İstanbul");
        spinnerAdapter.add("İzmir");
        spinnerAdapter.add("Antalya");
        spinnerAdapter.notifyDataSetChanged();


        final Button button = (Button) findViewById(R.id.button);
        final EditText edt1 = (EditText) findViewById(R.id.editText);
        final EditText edt2 = (EditText) findViewById(R.id.editText2);
        final EditText edt3 = (EditText) findViewById(R.id.editText3);
        final EditText edt4 = (EditText) findViewById(R.id.editText4);
        final RadioGroup rg1 = (RadioGroup)findViewById(R.id.radioGroup);
        final Spinner mySpinner =(Spinner) findViewById(R.id.spinner);


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


                    startActivity(i);
                }

    }
});

    }};