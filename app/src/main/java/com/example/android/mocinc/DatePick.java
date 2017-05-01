package com.example.android.mocinc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class DatePick extends Activity {
    DatePicker dp;
    Button tombolOK;
    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_pick);
        dp = (DatePicker) findViewById(R.id.datePicker1);
        tombolOK = (Button) findViewById(R.id.btnOK);

        //listener jika dilakukan klik pada tombol OK
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(DatePick.this,"Tanggal: "+dp.getDayOfMonth()+
                                "-"+(dp.getMonth()+1)+
                                "-"+dp.getYear(),
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), Registrasi.class);
                startActivity(i);
            }
        };

        //menerapkan listener pada tombol OK
        tombolOK.setOnClickListener(listener);
    }
}
