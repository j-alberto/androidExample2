package com.example.jarojas.example.presenter;

import com.example.jarojas.example.IPetRecyclerViewAdapterView;
import com.example.jarojas.example.model.Pet;

import java.util.List;

/**
 * Created by jarojas on 2/04/17.
 */

public interface IPetPresenter {

    void presentPets();

    List<Pet> findPets();
}
