package com.example.android.mocinc;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.app.Activity;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

public class MainMenu extends Activity {

    Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_menu);

        Button logout = (Button) findViewById(R.id.button2);
        logout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent (getApplicationContext(), Login.class);
                startActivity(intent);
              finish();
            }


        });

        ImageButton d= (ImageButton) findViewById(R.id.imageButton2);
        d.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent (getApplicationContext(), documentTicket.class);
                startActivity(i);
            }


        });


        ImageButton f= (ImageButton) findViewById(R.id.imageButton);
        f.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent (getApplicationContext(), listTicket.class);
                startActivity(i);
            }



        });
    }
}
