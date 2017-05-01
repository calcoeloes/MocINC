package com.example.android.mocinc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListBuyTicket extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buy_ticket);

        Button next = (Button) findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent (getApplicationContext(), buy_ticket.class);
                startActivity(intent);

            }


        });
    }
}
