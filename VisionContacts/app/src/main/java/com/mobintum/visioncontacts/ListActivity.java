package com.mobintum.visioncontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    private ListView listContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listContacts = (ListView) findViewById(R.id.listContacts);
        ContactAdapter adapter = new ContactAdapter(getApplicationContext(),R.layout.list_item_contact,Contact.getContacts());
        listContacts.setAdapter(adapter);
    }
}
