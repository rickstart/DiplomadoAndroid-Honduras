package com.mobintum.honducontact.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.mobintum.honducontact.R;


public class InputContactFragment extends Fragment {

    private EditText etFirstname, etLastname, etCompany, etNumber, etEmail, etGithub, etFacebook, etTwitter, etInstagram;
    private ImageView imgProfile;
    private Spinner spinTypeNumber;

    public InputContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_contact, container, false);
        etFirstname = (EditText) view.findViewById(R.id.etFirstname);
        etLastname = (EditText) view.findViewById(R.id.etLastname);
        etCompany = (EditText) view.findViewById(R.id.etCompany);
        etNumber = (EditText) view.findViewById(R.id.etNumber);
        etEmail = (EditText) view.findViewById(R.id.etEmail);
        etGithub = (EditText) view.findViewById(R.id.etGithub);
        etFacebook = (EditText) view.findViewById(R.id.etFacebook);
        etTwitter = (EditText) view.findViewById(R.id.etTwitter);
        etInstagram = (EditText) view.findViewById(R.id.etInstagram);
        imgProfile = (ImageView) view.findViewById(R.id.imgProfile);
        spinTypeNumber = (Spinner) view.findViewById(R.id.spinTypeNumber);
        return view;
    }

}
