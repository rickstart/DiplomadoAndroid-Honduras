package com.mobintum.honducontact.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
public class ContactsRVFragment extends Fragment implements View.OnClickListener{

    private RecyclerView rvContacts;
    private FloatingActionButton fabAdd;
    private CallbackInterface mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (CallbackInterface) getActivity();
    }

    public ContactsRVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts_rv, container, false);
        rvContacts = (RecyclerView) view.findViewById(R.id.rvContacts);
        fabAdd = (FloatingActionButton) view.findViewById(R.id.fabAdd);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvContacts.setLayoutManager(layoutManager);
        ContactRVAdapter adapter = new ContactRVAdapter(Contact.getContacts(getContext()));
        rvContacts.setAdapter(adapter);
        fabAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        mListener.addContact();
    }

    public interface CallbackInterface{
        public void addContact();
    }
}
