package com.example.jarojas.example.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jarojas.example.IPetRecyclerViewAdapterView;
import com.example.jarojas.example.adapter.PetRecyclerViewAdapter;
import com.example.jarojas.example.R;
import com.example.jarojas.example.model.Pet;
import com.example.jarojas.example.model.PetDataset;
import com.example.jarojas.example.presenter.MainPetPresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements IPetRecyclerViewAdapterView {

    private  RecyclerView rvPets;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        rvPets = (RecyclerView) v.findViewById(R.id.rvPets);

        new MainPetPresenter(this, getContext()).presentPets();

        return v;
    }

    @Override
    public void createLayout() {
        rvPets.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public PetRecyclerViewAdapter createAdapter(List<Pet> pets) {
        return new PetRecyclerViewAdapter(pets);
    }

    @Override
    public void initAdapter(PetRecyclerViewAdapter petAdapter) {
        rvPets.setAdapter(petAdapter);
    }
}
