package com.example.android.mocinc;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        final EditText username = (EditText)findViewById(R.id.editText);
        final EditText password = (EditText)findViewById(R.id.editText2);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                Intent i = new Intent(getApplicationContext(), MainMenu.class);
                if(username.getText().toString().equals("admin")&&password.getText().toString().equals("admin")) {
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Username/Password anda salah", Toast.LENGTH_SHORT).show();
                }

            }
        });
        TextView textview = (TextView)findViewById(R.id.textView5);
        textview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent i = new Intent(getApplicationContext(), Registrasi.class);
                startActivity(i);

            }
        });
    }
}