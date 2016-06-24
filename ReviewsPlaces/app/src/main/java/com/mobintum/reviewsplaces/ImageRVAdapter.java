package com.mobintum.reviewsplaces;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Rick on 24/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class ImageRVAdapter extends RecyclerView.Adapter<ImageRVAdapter.ViewHolder> {
    private String[] images;
    private Context context;

    public ImageRVAdapter(String[] images) {
        this.images = images;
    }

    @Override
    public ImageRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageRVAdapter.ViewHolder holder, int position) {
        String path = images[position];
        Picasso.with(context).load(path).into(holder.imgPlace);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPlace;
        public ViewHolder(View itemView) {
            super(itemView);
            imgPlace = (ImageView) itemView.findViewById(R.id.imgPlace);
        }
    }
}
