package com.example.jarojas.example.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jarojas.example.adapter.PetRecyclerViewAdapter;
import com.example.jarojas.example.R;
import com.example.jarojas.example.model.PetDataset;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView rvPets = (RecyclerView) v.findViewById(R.id.rvPets);
        rvPets.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPets.setAdapter(new PetRecyclerViewAdapter(PetDataset.PET_LIST));

        return v;
    }





}
