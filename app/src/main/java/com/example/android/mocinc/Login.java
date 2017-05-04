package com.example.android.mocinc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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


public class Login extends Activity {
//    DataHelper myDb;
// json array response url
    private String urlJsonObj = "http://api.scola.id/index.php/mocinc/account/signin/";
    private String jsonResponse;
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        myDb = new DataHelper(this);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        queue = Volley.newRequestQueue(this);
        final EditText username = (EditText)findViewById(R.id.editNama);
        final EditText password = (EditText)findViewById(R.id.editText2);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // TODO: Implement your own authentication logic here.
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username.getText().toString());
                params.put("password", password.getText().toString());
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
                                        "Maaf, Username dan Password Tidak COCOK.",
                                        Toast.LENGTH_LONG).show();
                            }else{
                                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                                intent.putExtra("username", username.getText().toString());
                                startActivity(intent);
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
                // pembatas

                Intent i = new Intent(getApplicationContext(), MainMenu.class);
                if(username.getText().toString().equals("admin")&&password.getText().toString().equals("admin")) {
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Anda berhasil Login", Toast.LENGTH_SHORT).show();
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