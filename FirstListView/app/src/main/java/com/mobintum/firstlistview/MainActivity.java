package com.mobintum.firstlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] names = {"Miguel", "Mario", "Ivan", "Eduardo", "Osman","Miguel", "Mario", "Ivan", "Eduardo", "Osman","Miguel", "Mario", "Ivan", "Eduardo", "Osman","Miguel", "Mario", "Ivan", "Eduardo", "Osman","Miguel", "Mario", "Ivan", "Eduardo", "Osman", "Maurin", "Olvin", "Ricardo"};
    private ListView listNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.simple_item_list,names);
        listNames = (ListView) findViewById(R.id.listNames);
        listNames.setAdapter(adapter);

    }
}
