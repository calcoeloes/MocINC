package com.example.android.mocinc;

//import android.content.Intent;
//import android.net.Uri;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

public class InformationTicket extends Activity implements OnMapReadyCallback{

    GoogleMap m_map;
    boolean mapReady=false;
    public static final CameraPosition GSG =
            new CameraPosition.Builder().target(new LatLng(-6.976653, 107.630278))
                    .zoom(18)
                    .bearing(0)
                    .tilt(0)
                    .build();
    public static final CameraPosition TUCH =
            new CameraPosition.Builder().target(new LatLng(-6.971541, 107.631083))
                    .zoom(18)
                    .bearing(0)
                    .tilt(0)
                    .build()
            ;
    public static final CameraPosition POLTEK =
            new CameraPosition.Builder().target(new LatLng(-6.973260, 107.632670))
                    .zoom(18)
                    .bearing(0)
                    .tilt(0)
                    .build()
            ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_ticket);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        TextView judul = (TextView) findViewById(R.id.textTitle);
        TextView loc = (TextView)findViewById(R.id.textLoc);
        TextView jam = (TextView)findViewById(R.id.textJam);
        Bundle b = getIntent().getExtras();
        judul.setText(b.getCharSequence("acara"));

        if(judul.getText().toString().equalsIgnoreCase("ALEK NAGARI 2017")){
            loc.setText("Telkom University Convention Hall");
            jam.setText("18.00 - 21.00");
        }
        else if(judul.getText().toString().equalsIgnoreCase("UNA IN PERPETTUM")){
            loc.setText("Aula Fakultas Ilmu Terapan Tel-U");
            jam.setText("19.00 - 22.30");
        }
        else if(judul.getText().toString().equalsIgnoreCase("PAKCIK 2017")){
            loc.setText("Gedung Serba Guna Telkom University");
            jam.setText("19.30 - 21.30");
        }

        Button pesan = (Button) findViewById(R.id.butPesan);

        pesan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            TextView text = (TextView) findViewById(R.id.textTitle);
                Bundle b = new Bundle();
                b.putString("acara",text.getText().toString());
                Intent i = new Intent(getApplicationContext(), buy_ticket.class);
                i.putExtras(b);
                startActivity(i);

            }
        });
    }
    @Override
    public void onMapReady(GoogleMap map){
        mapReady = true;
        m_map = map;
        TextView judul = (TextView) findViewById(R.id.textTitle);
        if(judul.getText().toString().equalsIgnoreCase("ALEK NAGARI 2017")){
            flyTo(TUCH);
            m_map.addMarker(new MarkerOptions().position(new LatLng(-6.971541, 107.631083)));
        }
        else if(judul.getText().toString().equalsIgnoreCase("UNA IN PERPETTUM")){
            flyTo(POLTEK);
            m_map.addMarker(new MarkerOptions().position(new LatLng(-6.973260, 107.632670)));
        }
        else if(judul.getText().toString().equalsIgnoreCase("PAKCIK 2017")){
            flyTo(GSG);
            m_map.addMarker(new MarkerOptions().position(new LatLng(-6.976653, 107.630278)));
        }

    }
    private void flyTo(CameraPosition target)
    {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 2000, null);



    }
}
