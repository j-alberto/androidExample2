package com.example.jarojas.example.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jarojas.example.R;
import com.example.jarojas.example.adapter.MyPetRecyclerViewAdapter;
import com.example.jarojas.example.model.PetDataset;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPetFragment extends Fragment {


    public MyPetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_pet, container, false);

        RecyclerView rvPets = (RecyclerView) v.findViewById(R.id.rvMyPet);
        rvPets.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rvPets.setAdapter(new MyPetRecyclerViewAdapter(PetDataset.MY_PET_LIST));

        return v;
    }

}
