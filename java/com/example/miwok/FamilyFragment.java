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
public class FamilyFragment extends Fragment {

    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words
        Word[] words= new Word[]{
                new Word("father", "el padre", R.drawable.family_father, R.raw.father),
                new Word("mother", "la madre", R.drawable.family_mother, R.raw.mother),
                new Word("son", "el hijo", R.drawable.family_son, R.raw.son),
                new Word("daughter", "la hija", R.drawable.family_daughter, R.raw.daughter),
                new Word("older brother", "hermano mayor", R.drawable.family_older_brother, R.raw.older_brother),
                new Word("older sister", "hermana mayor", R.drawable.family_older_sister, R.raw.older_sister),
                new Word("younger brother", "hermano menor", R.drawable.family_older_brother, R.raw.younger_brother),
                new Word("younger sister", "hermana menor", R.drawable.family_younger_brother, R.raw.younger_sister),
                new Word("siblings", "los hermanos", R.drawable.family_younger_sister, R.raw.siblings),
                new Word("grandfather", "el abuelo", R.drawable.family_grandfather, R.raw.grandpa),
                new Word("grandmother", "la abuela", R.drawable.family_grandmother, R.raw.grandma),

        };

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        WordAdapter adapter = new WordAdapter(words, R.color.category_family);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(adapter);
        return rootView;

    }

}
