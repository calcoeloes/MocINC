package com.example.android.mocinc;

//import android.content.Intent;
//import android.net.Uri;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class InformationTicket extends Activity implements OnMapReadyCallback{

    GoogleMap m_map;
    boolean mapReady=false;
    public static final CameraPosition GSG =
            new CameraPosition.Builder().target(new LatLng(-6.976653, 107.630278))
                    .zoom(21)
                    .bearing(0)
                    .tilt(0)
                    .build();
    public static final CameraPosition TUCH =
            new CameraPosition.Builder().target(new LatLng(-6.971541, 107.631083))
                    .zoom(17)
                    .bearing(0)
                    .tilt(0)
                    .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_ticket);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap map){
        mapReady = true;
        m_map = map;
        flyTo(TUCH);
    }
    private void flyTo(CameraPosition target)
    {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);



    }
}
