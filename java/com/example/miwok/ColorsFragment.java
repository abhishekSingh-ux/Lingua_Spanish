package com.example.miwok;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {


    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words
        Word[] words= new Word[]{
                new Word("red", "Rojo", R.drawable.color_red, R.raw.red),
                new Word("green", "verde", R.drawable.color_green, R.raw.green),
                new Word("black", "negro", R.drawable.color_black, R.raw.black),
                new Word("brown", "marron", R.drawable.color_brown, R.raw.brown),
                new Word("gray", "gris", R.drawable.color_gray, R.raw.gray),
                new Word("white", "blanco", R.drawable.color_white, R.raw.white),
                new Word("yellow", "amarillo", R.drawable.color_mustard_yellow, R.raw.yellow),
                new Word("orange", "naranja", R.drawable.color_dusty_yellow, R.raw.orange),

        };

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        WordAdapter adapter = new WordAdapter(words, R.color.category_colors);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(adapter);


        return rootView;

    }

}
