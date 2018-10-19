package com.example.dropa.geoguesswipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class GeoObjectViewHolder extends RecyclerView.ViewHolder {
   // public TextView geoName;
    public ImageView geoImage;
    public View view;

    public GeoObjectViewHolder(View itemView) {

        super(itemView);
       // geoName = itemView.findViewById(R.id.geoTextView);
        geoImage = itemView.findViewById(R.id.geoImageView);
        view = itemView;
    }
}

