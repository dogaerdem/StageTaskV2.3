package com.example.erdemlafci.taskv23;

/**
 * Created by erdemlafci on 09/10/15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
public class IkinciActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        String yenikey1 = "";
        String yenikey2 = "";
        String yenikey3 = "";
        String yenikey4 = "";
        String yenikey5 = "";
        String yenikey6 = "";
        int day;
        int month;
        int year;


        if (extras != null) {
            yenikey1 = extras.getString("key1");
            yenikey2 = extras.getString("key2");
            yenikey4 = extras.getString("key4");
            yenikey5 = extras.getString("key5");
            yenikey6 = extras.getString("key6");
            day = extras.getInt("day");
            month = extras.getInt("month");
            year = extras.getInt("year");



            Toast.makeText(IkinciActivity.this, "İsim: " + yenikey1 + "Soyisim:  " + yenikey2 +  " Eposta: " + yenikey4 + " Cinsiyet: " + yenikey5 + " İl : " + yenikey6 + "Doğum Tarihi " + day + "." + month + "." + year  , Toast.LENGTH_LONG).show();
        }
    }
}
