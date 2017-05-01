package com.example.android.mocinc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Registrasi extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        Button button=(Button)findViewById(R.id.searchdate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), DatePicker.class);
                startActivity(i);
            }
        });
        Button button2=(Button)findViewById(R.id.registrasi_button);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });
    }
}
