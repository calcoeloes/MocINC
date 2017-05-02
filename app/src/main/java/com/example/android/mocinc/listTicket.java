package com.example.android.mocinc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listTicket extends Activity {
    private ListView lv;
    private String[] acara =new String[] {"ALEK NAGARI 2017", "UNA IN PERPETTUM", "PAKCIK 2017"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ticket);
        lv = (ListView)findViewById(R.id.listArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(listTicket.this,android.R.layout.activity_list_item, android.R.id.text1, acara);
        lv.setAdapter(adapter);
//
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),InformationTicket.class);
                Bundle b = new Bundle();
                b.putString("acara", acara[position].toString());
                i.putExtras(b);
                startActivity(i);

            }});

                Button button = (Button) findViewById(R.id.button7);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent i = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(i);

            }
        });

    }

}
