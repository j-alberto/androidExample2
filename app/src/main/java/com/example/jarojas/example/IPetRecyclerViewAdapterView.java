package com.example.jarojas.example;

import com.example.jarojas.example.adapter.PetRecyclerViewAdapter;
import com.example.jarojas.example.model.Pet;

import java.util.List;

/**
 * Created by jarojas on 2/04/17.
 */

public interface IPetRecyclerViewAdapterView {
    void createLayout();
    PetRecyclerViewAdapter createAdapter(List<Pet> pets);
    void initAdapter(PetRecyclerViewAdapter petAdapter);
}
