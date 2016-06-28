package com.mobintum.honducontact.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobintum.honducontact.R;
import com.mobintum.honducontact.adapters.ContactRVAdapter;
import com.mobintum.honducontact.fragments.ContactsRVFragment;
import com.mobintum.honducontact.fragments.InputContactFragment;

public class MainActivity extends AppCompatActivity implements ContactsRVFragment.CallbackInterface {

    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.content, new ContactsRVFragment()).commit();
    }

    @Override
    public void addContact() {
        fm.beginTransaction().replace(R.id.content, new InputContactFragment()).addToBackStack(null).commit();
    }
}
