package com.example.android.mocinc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Payment extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Bundle b = getIntent().getExtras();
        TextView harg = (TextView) findViewById(R.id.textView31);
        int jumlah = Integer.parseInt(String.valueOf( b.getCharSequence("jumlah")));
        String judul = String.valueOf(b.getCharSequence("acara"));
        int harga;

        if(judul.toString().equalsIgnoreCase("ALEK NAGARI 2017")){
            int harga_awal = 40000;
            harga = harga_awal*jumlah;
            harg.setText(String.valueOf(harga));
        }
        else if(judul.toString().equalsIgnoreCase("UNA IN PERPETTUM")){
            int harga_awal = 60000;
            harga = harga_awal*jumlah;
            harg.setText(String.valueOf(harga));
        }
        else if(judul.toString().equalsIgnoreCase("PAKCIK 2017")){
            int harga_awal = 30000;
            harga = harga_awal*jumlah;
            harg.setText(String.valueOf(harga));
        }

    }
}
