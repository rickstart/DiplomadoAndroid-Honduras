package com.mobintum.firstexamplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private String[] names = {"Ricardo", "Miguel", "Ivan", "Eduardo", "Osman", "Maurin", "Olvin"};
    private RecyclerView rvNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvNames = (RecyclerView) findViewById(R.id.rvNames);
        NameRVAdapter adapter = new NameRVAdapter(names);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvNames.setLayoutManager(layoutManager);
        rvNames.setAdapter(adapter);
    }
}
