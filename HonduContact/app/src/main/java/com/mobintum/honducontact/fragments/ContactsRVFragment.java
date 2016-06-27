package com.mobintum.honducontact.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobintum.honducontact.R;
import com.mobintum.honducontact.adapters.ContactRVAdapter;
import com.mobintum.honducontact.models.Contact;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsRVFragment extends Fragment {

    RecyclerView rvContacts;


    public ContactsRVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts_rv, container, false);
        rvContacts = (RecyclerView) view.findViewById(R.id.rvContacts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvContacts.setLayoutManager(layoutManager);
        ContactRVAdapter adapter = new ContactRVAdapter(Contact.getContacts(getContext()));
        rvContacts.setAdapter(adapter);
        return view;
    }

}
