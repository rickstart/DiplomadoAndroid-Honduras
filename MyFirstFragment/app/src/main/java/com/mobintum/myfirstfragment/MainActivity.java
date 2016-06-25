package com.mobintum.myfirstfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager dt =  getSupportFragmentManager();
        BlankFragment player1 = new BlankFragment();
        FragmentTransaction change = dt.beginTransaction();
        change.add(R.id.field,player1,"Maurin");
        change.commit();
    }
}
