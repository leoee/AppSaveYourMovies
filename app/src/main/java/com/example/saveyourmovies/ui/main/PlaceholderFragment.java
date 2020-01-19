package com.example.saveyourmovies.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.example.saveyourmovies.CustomAdapter;
import com.example.saveyourmovies.Movie;
import com.example.saveyourmovies.R;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private String title;
    private int index;
    CustomAdapter adapter;
    ArrayList<Movie> moviesList;

    public static PlaceholderFragment newInstance(int index, String title) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        bundle.putString("someTitle", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString("someTitle");
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView mRecyclerView = root.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);

        moviesList = new ArrayList();
        if(title.equals("To see")) {
        } else if(title.equals("Seeing")) {
            Movie teste2 = new Movie();
            teste2.setEpisode(1);
            teste2.setSeason(2);
            teste2.setName("leoe");
            moviesList.add(teste2);
        } else if (title.equals("Done")) {
            Movie teste2 = new Movie();
            teste2.setEpisode(1);
            teste2.setSeason(2);
            teste2.setName("leoe");
            moviesList.add(teste2);

            Movie teste = new Movie();

            teste.setEpisode(1);
            teste.setSeason(2);
            teste.setName("To see");
            moviesList.add(teste);
        }


        adapter = new CustomAdapter(moviesList);
        adapter.notifyDataSetChanged();


        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        return root;
    }

}