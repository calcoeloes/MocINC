package com.example.android.mocinc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class buy_ticket extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);



        TextView judl = (TextView) findViewById(R.id.textLoc);
        Button butt = (Button) findViewById(R.id.butAcc);
        Bundle b = getIntent().getExtras();
        judl.setText(b.getCharSequence("acara"));

        butt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView j = (TextView) findViewById(R.id.textLoc) ;
                Spinner sp = (Spinner) findViewById(R.id.spinner1);
                Intent intent = new Intent (getApplicationContext(), Payment.class);
                Bundle b = new Bundle();
                b.putString("acara", j.getText().toString());
                b.putString("jumlah", sp.getSelectedItem().toString());
                intent.putExtras(b);
                startActivity(intent);

            }


        });
    }
}
