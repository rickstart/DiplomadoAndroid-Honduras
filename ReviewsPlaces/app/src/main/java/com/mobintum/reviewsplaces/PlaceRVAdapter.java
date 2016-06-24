package com.mobintum.reviewsplaces;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rick on 24/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class PlaceRVAdapter extends RecyclerView.Adapter<PlaceRVAdapter.ViewHolder> {

    private ArrayList<Place> places;
    private Context context;

    public PlaceRVAdapter(ArrayList<Place> places) {
        this.places = places;
    }

    @Override
    public PlaceRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_place,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlaceRVAdapter.ViewHolder holder, int position) {
        Place place = places.get(position);
        holder.txtTitle.setText(place.getName());
        holder.txtDescription.setText(place.getDescription());
        holder.txtNamePublisher.setText(place.getPublisherName());
        Picasso.with(context).load(place.getPublisherPhoto()).into(holder.imgPublisher);
        ImageRVAdapter adapter = new ImageRVAdapter(place.getPhotos());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.rvImages.setLayoutManager(layoutManager);
        holder.rvImages.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rvImages;
        TextView txtTitle;
        TextView txtDescription;
        ImageView imgPublisher;
        TextView txtNamePublisher;

        public ViewHolder(View itemView) {
            super(itemView);
            rvImages = (RecyclerView) itemView.findViewById(R.id.rvImages);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            imgPublisher = (ImageView) itemView.findViewById(R.id.imgPublisher);
            txtNamePublisher  = (TextView) itemView.findViewById(R.id.txtNamePublisher);
        }
    }
}
