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
public class NumbersFragment extends Fragment {

    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words
        final Word[] words= new Word[]{
                new Word("one", "uno", R.drawable.number_one, R.raw.one ),
                new Word("two", "dos", R.drawable.number_two, R.raw.two),
                new Word("three", "tres", R.drawable.number_three, R.raw.three),
                new Word("four", "quatro", R.drawable.number_four, R.raw.four),
                new Word("five", "cinco", R.drawable.number_five, R.raw.five),
                new Word("six", "seis", R.drawable.number_six, R.raw.six),
                new Word("seven", "siete", R.drawable.number_seven, R.raw.seven),
                new Word("eight", "ocho", R.drawable.number_eight, R.raw.eight),
                new Word("nine", "nueve", R.drawable.number_nine, R.raw.nine),
                new Word("ten", "diez", R.drawable.number_ten, R.raw.ten),
        };

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        WordAdapter adapter = new WordAdapter(words, R.color.category_numbers);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(adapter);


        return rootView;

    }

}
