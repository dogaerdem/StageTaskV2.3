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

        if (extras != null) {
            yenikey1 = extras.get("key1").toString();
            yenikey2 = extras.get("key2").toString();
            yenikey3 = extras.get("key3").toString();
            yenikey4 = extras.get("key4").toString();
            yenikey5 = extras.get("key5").toString();
            yenikey6 = extras.get("key6").toString();


            Toast.makeText(IkinciActivity.this, "Bilgiler: " + yenikey1 + yenikey2 + yenikey3 + yenikey4 + yenikey5 + yenikey6, Toast.LENGTH_LONG).show();
        }
    }
}
