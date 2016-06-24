package com.mobintum.exercisethreelistzoo;

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
public class AnimalAdapter extends ArrayAdapter {

    private ArrayList<Animal> animals;
    private int resource;

    public AnimalAdapter(Context context, int resource, ArrayList<Animal> animals ) {
        super(context, resource, animals);
        this.animals = animals;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        ViewHolder holder;
        if(convertView.getTag()==null){
            holder = new ViewHolder();
            holder.txtNameAnimal = (TextView) convertView.findViewById(R.id.txtNameAnimal);
            holder.imgAnimal = (ImageView) convertView.findViewById(R.id.imgAnimal);
            convertView.setTag(holder);
        }else
            holder = (ViewHolder) convertView.getTag();

        Animal animal = animals.get(position);

        holder.txtNameAnimal.setText(animal.getName());
        Picasso.with(parent.getContext()).load(animal.getPhoto()).into(holder.imgAnimal);

        return convertView;
    }

    public class ViewHolder{
        ImageView imgAnimal;
        TextView txtNameAnimal;
    }
}
