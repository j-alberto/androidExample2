package com.example.jarojas.example.presenter;

import android.content.Context;
import android.util.Log;

import com.example.jarojas.example.IPetRecyclerViewAdapterView;
import com.example.jarojas.example.db.PetBuilder;
import com.example.jarojas.example.model.Pet;
import com.example.jarojas.example.model.PetDataset;

import java.util.List;

/**
 * Created by jarojas on 2/04/17.
 */

public class MainPetPresenter implements IPetPresenter {

    private IPetRecyclerViewAdapterView petAdapterView;
    private Context context;
    PetBuilder petBuilder;

    public MainPetPresenter(IPetRecyclerViewAdapterView petAdapterView, Context context) {
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
//        return PetDataset.PET_LIST;
        List<Pet> pets = petBuilder.findAll();
        Log.i("PRESENTER", "findPets: "+pets.size());
        return pets;
    }
}
