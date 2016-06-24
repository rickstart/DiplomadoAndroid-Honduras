package com.mobintum.exercisethreelistzoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listAnimals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAnimals = (ListView) findViewById(R.id.listAnimals);
        AnimalAdapter adapter = new AnimalAdapter(getApplicationContext(),R.layout.list_item_animal,Animal.getAnimals());
        listAnimals.setAdapter(adapter);
    }
}
