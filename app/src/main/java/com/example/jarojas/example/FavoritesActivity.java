package com.example.jarojas.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.jarojas.example.adapter.PetRecyclerViewAdapter;
import com.example.jarojas.example.model.PetDataset;

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        Toolbar actionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_pets);

        RecyclerView rvPets = (RecyclerView) findViewById(R.id.rvFavoritePets);
        rvPets.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        rvPets.setAdapter(new PetRecyclerViewAdapter(PetDataset.FAVORITES));
    }
}
