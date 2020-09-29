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
public class PhrasesFragment extends Fragment {


    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words
        Word[] words= new Word[]{
                new Word("Hello", "Hola", R.raw.hello),
                new Word("What's up?", "Que pasa?",R.raw.what_up ),
                new Word("Good morning", "Buenos dias", R.raw.good_morning),
                new Word("Good afternoon", "Buenas tardes", R.raw.good_afternoon),
                new Word("Good night", "Buenas noches", R.raw.good_night),
                new Word("How are you?", "Como estas", R.raw.how_are_you),
                new Word("As always", "Como siempre", R.raw.as_always),
                new Word("so-so", "asi-asi", R.raw.so_so),
                new Word("Nothing", "Nada",R.raw.nothing),
                new Word("What's your name?", "Como te llama?", R.raw.your_name),
                new Word("All right", "Todo bien", R.raw.all_good)

        };

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        WordAdapter adapter = new WordAdapter(words, R.color.category_phrases);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(adapter);
        return rootView;

    }

}
