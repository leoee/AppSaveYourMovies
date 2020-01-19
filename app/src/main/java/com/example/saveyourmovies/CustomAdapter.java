package com.example.saveyourmovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Movie> moviesList;

    public CustomAdapter(ArrayList<Movie> list) {
        this.moviesList = list;
    }



    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item, viewGroup, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder viewHolder, int i) {

        // Set item views based on your views and data model
        TextView textView = viewHolder.textName;
        textView.setText(moviesList.get(i).getName());
        TextView textView2 = viewHolder.textEpisode;
        textView2.setText(moviesList.get(i).getName());
        TextView textView3 = viewHolder.textSeason;
        textView3.setText(moviesList.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
         public TextView textName, textSeason, textEpisode;


        public ViewHolder(View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.textName);
            textSeason = itemView.findViewById(R.id.textSeason);
            textEpisode = itemView.findViewById(R.id.textEpisode);
        }
    }
}