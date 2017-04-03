package com.example.jarojas.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.jarojas.example.adapter.PetRecyclerViewAdapter;
import com.example.jarojas.example.model.Pet;
import com.example.jarojas.example.presenter.FavoritePetPresenter;

import java.util.List;

public class FavoritesActivity extends AppCompatActivity implements IPetRecyclerViewAdapterView {

    private  RecyclerView rvPets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        Toolbar actionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_pets);

        rvPets = (RecyclerView) findViewById(R.id.rvFavoritePets);

        new FavoritePetPresenter(this, getApplicationContext())
            .presentPets();

    }

    @Override
    public void createLayout() {
        rvPets.setLayoutManager(new LinearLayoutManager(getBaseContext()));
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
