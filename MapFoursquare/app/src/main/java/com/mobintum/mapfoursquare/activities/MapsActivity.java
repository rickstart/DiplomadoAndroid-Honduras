package com.mobintum.mapfoursquare.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobintum.mapfoursquare.R;
import com.mobintum.mapfoursquare.fragments.MapFragment;

public class MapsActivity extends FragmentActivity  {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, new MapFragment())
                .commit();

    }

}
