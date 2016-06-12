package com.example.jarojas.example;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout srLayoutRefresh;
    ListView lvList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configFlAcButton();
        lvList = (ListView) findViewById(R.id.lvList);
        srLayoutRefresh = (SwipeRefreshLayout) findViewById(R.id.srLayoutRefresh);
        configSwipeRefreshLayout();

    }

    private void configFlAcButton(){
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fabCustomFloatActButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(), getString(R.string.action_message), Toast.LENGTH_SHORT).show();
                Snackbar.make(view, getString(R.string.snack_message), Snackbar.LENGTH_SHORT )
                        .setAction(R.string.snack_action, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACK","Snack action done");
                            }
                        })
                        .setActionTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary))
                        .show();
            }
        });

    }

    private void configSwipeRefreshLayout(){

        srLayoutRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                configListView();
                srLayoutRefresh.setRefreshing(false);
            }
        });
    }

    private void configListView(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lvList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));
    }
}
