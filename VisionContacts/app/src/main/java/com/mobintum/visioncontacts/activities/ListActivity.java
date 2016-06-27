package com.mobintum.visioncontacts.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mobintum.visioncontacts.R;
import com.mobintum.visioncontacts.adapters.ContactAdapter;
import com.mobintum.visioncontacts.models.Contact;

import java.io.Serializable;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listContacts = (ListView) findViewById(R.id.listContacts);
        ContactAdapter adapter = new ContactAdapter(getApplicationContext(),R.layout.list_item_contact, Contact.getContacts());
        listContacts.setAdapter(adapter);
        listContacts.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        intent.putExtra("contact", (Serializable) Contact.getContacts().get(position));
        startActivity(intent);
    }
}
