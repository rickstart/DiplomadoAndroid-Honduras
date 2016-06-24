package com.mobintum.reviewsplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPlaces;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPlaces = (RecyclerView) findViewById(R.id.rvPlaces);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvPlaces.setLayoutManager(layoutManager);
        PlaceRVAdapter adapter = new PlaceRVAdapter(Place.getPlaces());
        rvPlaces.setAdapter(adapter);
    }
}
