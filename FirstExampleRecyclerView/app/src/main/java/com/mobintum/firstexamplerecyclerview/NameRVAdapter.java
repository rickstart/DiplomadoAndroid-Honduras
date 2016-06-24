package com.mobintum.firstexamplerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Rick on 24/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class NameRVAdapter extends RecyclerView.Adapter<NameRVAdapter.ViewHolder> {
    private String[] names;

    public NameRVAdapter(String[] names) {
        this.names = names;
    }

    @Override
    public NameRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_name,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NameRVAdapter.ViewHolder holder, int position) {
        String name = names[position];
        holder.txtName.setText(name);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
        }
    }
}
