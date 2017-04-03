package com.example.jarojas.example.presenter;

import android.content.Context;

import com.example.jarojas.example.IPetRecyclerViewAdapterView;
import com.example.jarojas.example.db.PetBuilder;
import com.example.jarojas.example.model.Pet;
import com.example.jarojas.example.model.PetDataset;

import java.util.List;

/**
 * Created by jarojas on 2/04/17.
 */

public class FavoritePetPresenter implements IPetPresenter {

    private IPetRecyclerViewAdapterView petAdapterView;
    private Context context;
    private PetBuilder petBuilder;

    public FavoritePetPresenter(IPetRecyclerViewAdapterView petAdapterView, Context context) {
        this.petAdapterView = petAdapterView;
        this.context = context;
        petBuilder = new PetBuilder(context);
    }

    @Override
    public void presentPets() {
        petAdapterView.initAdapter(petAdapterView.createAdapter(
                findPets()
        ));
        petAdapterView.createLayout();
    }

    @Override
    public List<Pet> findPets() {
        return petBuilder.findTop5Favorites();
    }
}
