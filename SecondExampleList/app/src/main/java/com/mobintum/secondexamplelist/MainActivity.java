package com.mobintum.secondexamplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPeople = (ListView) findViewById(R.id.listPeople);
        PersonAdapter adapter = new PersonAdapter(getApplicationContext(),R.layout.list_item_person,Person.getPeople());
        listPeople.setAdapter(adapter);
    }
}
