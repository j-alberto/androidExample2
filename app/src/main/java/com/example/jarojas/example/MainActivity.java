package com.example.jarojas.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setIcon(R.drawable.ic_pets);

        RecyclerView rvPets = (RecyclerView) findViewById(R.id.rvPets);
        rvPets.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        rvPets.setAdapter(new PetRecyclerViewAdapter(PetDataset.PET_LIST));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionFavorites:
                goDetail();
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    public void goDetail() {
        Intent i = new Intent(this,FavoritesActivity.class);
        startActivity(i);
    }
}
