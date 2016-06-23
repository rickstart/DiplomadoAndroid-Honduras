package com.mobintum.visioncontacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rick on 23/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class ContactAdapter extends ArrayAdapter {

    private ArrayList<Contact> contacts;
    private int resource;

    public ContactAdapter(Context context, int resource, ArrayList<Contact> contacts) {
        super(context, resource, contacts);
        this.contacts = contacts;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        ViewHolder holder;
        if(convertView.getTag() == null){
            holder = new ViewHolder();
            holder.imgThumb = (ImageView) convertView.findViewById(R.id.imgThumb);
            holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            holder.txtCompany = (TextView) convertView.findViewById(R.id.txtCompany);
            convertView.setTag(holder);
        }else
            holder = (ViewHolder) convertView.getTag();

        Contact contact = contacts.get(position);

        holder.txtName.setText(contact.getName());
        holder.txtCompany.setText(contact.getCompany());
        Picasso.with(parent.getContext()).load(contact.getPhoto()).into(holder.imgThumb);

        return convertView;
    }

    public class ViewHolder{
        TextView txtName;
        TextView txtCompany;
        ImageView imgThumb;
    }
}
