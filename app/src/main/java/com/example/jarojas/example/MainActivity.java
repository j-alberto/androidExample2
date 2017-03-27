package com.example.jarojas.example;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jarojas.example.adapter.PetViewPagerAdapter;
import com.example.jarojas.example.fragment.HomeFragment;
import com.example.jarojas.example.fragment.MyPetFragment;
import com.example.jarojas.example.model.PetDataset;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Toolbar actionBar;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        initViewPage();

    }

    private void initToolbar() {
        actionBar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        if(actionBar != null) {
            setSupportActionBar(actionBar);
            getSupportActionBar().setIcon(R.drawable.ic_pets);
        }

    }

    private void initViewPage() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPager.setAdapter(new PetViewPagerAdapter(
                getSupportFragmentManager(),
                getPagerFragments()));

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionFavorites:
                goTop5Favorites();
                return true;
            case R.id.actionContact:
                goContact();
                return true;
            case R.id.actionAbout:
                goAbout();
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    public void goTop5Favorites() {
        Intent i = new Intent(this,FavoritesActivity.class);
        startActivity(i);
    }
    public void goContact() {
        Intent i = new Intent(this,ContactActivity.class);
        startActivity(i);
    }
    public void goAbout() {
        Intent i = new Intent(this,AboutActivity.class);
        startActivity(i);
    }

    private List<Fragment> getPagerFragments() {
        return Arrays.asList(
                new HomeFragment(),
                new MyPetFragment());
    }


}
