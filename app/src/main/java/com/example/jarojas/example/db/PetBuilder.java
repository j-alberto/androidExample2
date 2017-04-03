package com.example.jarojas.example.db;

import android.content.Context;

import com.example.jarojas.example.model.Pet;

import java.util.List;

/**
 * Created by jarojas on 2/04/17.
 */

public class PetBuilder {

    PetDbHelper petHelper;

    public PetBuilder(Context context) {
        petHelper = new PetDbHelper(context);
    }

    public List<Pet> findAll(){
        return petHelper.findAll();
    }

    public List<Pet> findTop5Favorites() {
        return petHelper.findTop5ByRating();
    }
}
