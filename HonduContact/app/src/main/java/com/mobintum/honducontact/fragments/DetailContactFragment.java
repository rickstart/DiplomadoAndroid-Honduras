package com.mobintum.honducontact.fragments;


import android.os.Bundle;
import android.renderscript.Type;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobintum.honducontact.R;
import com.mobintum.honducontact.models.Contact;
import com.mobintum.honducontact.models.ContactNumber;
import com.mobintum.honducontact.models.TypeNumber;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailContactFragment extends Fragment {

    private static final String ARG_PARAM_CONTACT = "paramContact";
    private Contact contact;
    private TextView txtName, txtNumber, txtEmail, txtGithub, txtFacebook, txtTwitter, txtInstagram;
    private ImageView imgProfile;

    public static DetailContactFragment newIntance(Contact contact){
        DetailContactFragment fragment = new DetailContactFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_CONTACT, contact);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            this.contact = (Contact) getArguments().getSerializable(ARG_PARAM_CONTACT);
        }
    }

    public DetailContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_contact, container, false);
        txtName = (TextView) view.findViewById(R.id.txtName);
        txtNumber = (TextView) view.findViewById(R.id.txtNumber);
        txtEmail = (TextView) view.findViewById(R.id.txtEmail);
        txtGithub = (TextView) view.findViewById(R.id.txtGithub);
        txtFacebook = (TextView) view.findViewById(R.id.txtFacebook);
        txtTwitter = (TextView) view.findViewById(R.id.txtTwitter);
        txtInstagram = (TextView) view.findViewById(R.id.txtInstagram);
        imgProfile = (ImageView) view.findViewById(R.id.imgProfile);

        if(contact.getLastName()!=null)
            txtName.setText(" "+contact.getFirstName()+" "+contact.getLastName());
        else
            txtName.setText(" "+contact.getFirstName());

        ContactNumber contactNumber = ContactNumber.getContactNumbers(getContext(),contact.getContactId()).get(0);
        TypeNumber typeNumber = TypeNumber.getTypeNumberById(getContext(), contactNumber.getFk_typeNumberId());

        txtNumber.setText(" ( "+typeNumber.getType()+" ) "+contactNumber.getNumber());

        if(contact.getEmail()!=null)
            txtEmail.setText(contact.getEmail());
        if(contact.getGithub()!=null)
            txtGithub.setText(contact.getGithub());
        if(contact.getFacebook()!=null)
            txtFacebook.setText(contact.getFacebook());
        if(contact.getTwitter()!=null)
            txtTwitter.setText(contact.getTwitter());
        if(contact.getInstagram()!=null)
            txtInstagram.setText(contact.getInstagram());

        return view;
    }

}
