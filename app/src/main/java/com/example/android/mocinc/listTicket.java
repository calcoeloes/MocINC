package com.example.android.mocinc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class listTicket extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ticket);
        Button button=(Button)findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent i = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(i);

            }
        });

    }

}
