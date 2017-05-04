package com.example.android.mocinc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Registrasi extends Activity{
    private String urlJsonObj = "http://api.scola.id/index.php/mocinc/account/signup/";
    private String jsonResponse;
    private RequestQueue queue;
    @InjectView(R.id.editNama) EditText nama;
    @InjectView(R.id.editAlamat) EditText alamat;
    @InjectView(R.id.editEmail) EditText email;
    @InjectView(R.id.editPassword) EditText password;
    @InjectView(R.id.editUsername) EditText username;
    @InjectView(R.id.editLahir) EditText lahir;
    @InjectView(R.id.registrasi_button) Button registrasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        queue = Volley.newRequestQueue(this);
        ButterKnife.inject(this);
        registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement your own authentication logic here.
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username.getText().toString());
                params.put("password", password.getText().toString());
                params.put("nama", nama.getText().toString());
                params.put("email", email.getText().toString());
                params.put("alamat", alamat.getText().toString());
                params.put("lahir", lahir.getText().toString());
                JSONObject parameters = new JSONObject(params);
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        urlJsonObj, parameters, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Login", response.toString());
                        try {
                            if(response.getString("status").equals("failed"))
                            {
                                Toast.makeText(getApplicationContext(),
                                        "Terjadi kesalahansaat input data,silahkancoba lagi.",
                                        Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(getApplicationContext(),
                                        "Pendaftaran telah berhasil, silahkan login menggunakan akun yang telah dibuat sebelumnya.",
                                        Toast.LENGTH_LONG).show();
                                finish(); // call this to finish the current activity

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("Login", "Error: " + error.getMessage());
                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();
                        // hide the progress dialog

                    }
                });
                queue.add(jsonObjReq);
            }
        });
        /*
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
                finish();
            }
        });
        */
    }
}
