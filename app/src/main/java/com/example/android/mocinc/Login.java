package com.example.android.mocinc;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

//TODO : Ubah AppCompatActivity menjadi Activity agar dapat menghilangkan Action Bar
public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        //TODO : Tambahkan variable baru untuk 2 EditText pada activity_login.xml serta findViewById sesuai dengan ID EditText
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //TODO : Buat tombol bisa mengakses activity_main_menu.xml pada saat di tekan
                Intent i = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(i);

            }
        });
    }
}