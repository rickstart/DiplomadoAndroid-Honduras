package com.mobintum.honducontact.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import com.mobintum.honducontact.R;
import com.mobintum.honducontact.models.Contact;

/**
 * Created by Rick on 27/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class ContactRVAdapter  extends RecyclerView.Adapter<ContactRVAdapter.ViewHolder>{
    private ArrayList<Contact> contacts;

    public ContactRVAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ContactRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contact,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactRVAdapter.ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        if(contact.getLastName()!=null)
            holder.txtName.setText(contact.getFirstName()+" "+contact.getLastName());
        else
            holder.txtName.setText(contact.getFirstName());

        if(contact.getCompany()!=null)
            holder.txtCompany.setText(contact.getCompany());

        if(contact.getPathPhoto()!=null){
            File imgFile = new File(contact.getPathPhoto());
            if(imgFile.exists()){
                Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                holder.imgProfileThumb.setImageBitmap(bitmap);
            }
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProfileThumb;
        TextView txtName;
        TextView txtCompany;
        public ViewHolder(View itemView) {
            super(itemView);
            imgProfileThumb = (ImageView) itemView.findViewById(R.id.imgProfileThumb);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtCompany = (TextView) itemView.findViewById(R.id.txtCompany);
        }
    }
}
