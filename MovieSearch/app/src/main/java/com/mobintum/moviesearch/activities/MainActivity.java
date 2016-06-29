package com.mobintum.moviesearch.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobintum.moviesearch.R;
import com.mobintum.moviesearch.fragments.MoviesRVFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, new MoviesRVFragment())
                .commit();
    }
}
