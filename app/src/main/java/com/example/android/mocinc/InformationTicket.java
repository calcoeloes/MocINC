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
    public static CameraPosition lokasi;
    double lat,lang;
    Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_ticket);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        TextView judul = (TextView) findViewById(R.id.textTitle);
        TextView loc = (TextView)findViewById(R.id.textLoc);
        TextView jam = (TextView)findViewById(R.id.textJam);
        b = getIntent().getExtras();
        judul.setText(b.getCharSequence("nama"));
        loc.setText(b.getCharSequence("lokasi"));
        jam.setText("waktu");

        Button pesan = (Button) findViewById(R.id.butPesan);

        pesan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            TextView text = (TextView) findViewById(R.id.textTitle);
                Intent i = new Intent(getApplicationContext(), buy_ticket.class);

                i.putExtra("id", b.getCharSequence("id"));
                i.putExtra("harga", b.getCharSequence("harga"));
                i.putExtra("lang", b.getCharSequence("lang"));
                i.putExtra("lat", b.getCharSequence("lat"));
                i.putExtra("lokasi", b.getCharSequence("lokasi"));
                i.putExtra("nama", b.getCharSequence("nama"));
                i.putExtra("waktu", b.getCharSequence("waktu"));

                startActivity(i);

            }
        });
        lat = Double.parseDouble(b.getCharSequence("lat").toString());
       lang = Double.parseDouble(b.getCharSequence("lang").toString());

        lokasi =
                new CameraPosition.Builder().target(new LatLng(lat, lang))
                        .zoom(18)
                        .bearing(0)
                        .tilt(0)
                        .build();
    }
    @Override
    public void onMapReady(GoogleMap map){
        mapReady = true;
        m_map = map;
        TextView judul = (TextView) findViewById(R.id.textTitle);
        flyTo(lokasi);
        m_map.addMarker(new MarkerOptions().position(new LatLng(lat, lang)));

    }
    private void flyTo(CameraPosition target)
    {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 2000, null);



    }
}
