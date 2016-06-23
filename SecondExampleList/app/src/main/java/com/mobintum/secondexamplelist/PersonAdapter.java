package com.mobintum.secondexamplelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rick on 23/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class PersonAdapter extends ArrayAdapter {

    private ArrayList<Person> people;

    public PersonAdapter(Context context, int resource, ArrayList<Person> people) {
        super(context, resource, people);
        this.people = people;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_person,parent,false);
        if(convertView.getTag() == null){
            holder = new ViewHolder();
            holder.txtFullName = (TextView) convertView.findViewById(R.id.txtFullName);
            holder.txtBirthdate = (TextView) convertView.findViewById(R.id.txtBirthdate);
            holder.txtGender = (TextView) convertView.findViewById(R.id.txtGender);
            holder.txtNationality = (TextView) convertView.findViewById(R.id.txtNationality);
            holder.txtDocumentId = (TextView) convertView.findViewById(R.id.txtDocumentId);
            convertView.setTag(holder);
        }else
            holder = (ViewHolder) convertView.getTag();

        Person person = people.get(position);

        holder.txtFullName.setText(person.getFirstName()+" "+person.getLastName());
        holder.txtBirthdate.setText(person.getBirthdate().toString());
        holder.txtGender.setText(person.getGender());
        holder.txtNationality.setText(person.getNationality());
        holder.txtDocumentId.setText(person.getDocumentTypeId()+" "+person.getNumberId());

        return convertView;
    }


    public class ViewHolder{
        TextView txtFullName, txtBirthdate, txtGender, txtNationality, txtDocumentId;
    }
}
