package com.example.android.mocinc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class buy_ticket extends Activity {
    @InjectView(R.id.spinnerJumlah) Spinner jumlah;
    @InjectView(R.id.editNama) EditText nama;
    @InjectView(R.id.editEmail) EditText email;
    @InjectView(R.id.editAlamat) EditText alamat;
    Bundle b;
    private String urlJsonObj = "http://api.scola.id/index.php/mocinc/account/signin/";
    private String jsonResponse;
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);
        ButterKnife.inject(this);


        TextView judl = (TextView) findViewById(R.id.textLoc);
        Button butt = (Button) findViewById(R.id.butAcc);
        b = getIntent().getExtras();
        judl.setText(b.getCharSequence("nama"));

        butt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView j = (TextView) findViewById(R.id.textLoc) ;
                Spinner sp = (Spinner) findViewById(R.id.spinnerJumlah);

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
