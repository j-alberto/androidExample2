package com.example.jarojas.example;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout srLayoutRefresh;
    ListView lvList;
    ArrayList<Contact> contacts = new ArrayList<>();

    public static final String KEY_NAME = "com.example.jarojas.example.AppCompatActivity.name";
    public static final String KEY_EMAIL = "com.example.jarojas.example.AppCompatActivity.email";
    public static final String KEY_PHONE = "com.example.jarojas.example.AppCompatActivity.phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this,getString(R.string.event_create), Toast.LENGTH_SHORT).show();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configFlAcButton();
        lvList = (ListView) findViewById(R.id.lvList);
        srLayoutRefresh = (SwipeRefreshLayout) findViewById(R.id.srLayoutRefresh);
        configSwipeRefreshLayout();

        contacts.add(new Contact("J. Alberto", "my.email@someplace.com"));
        contacts.add(new Contact("Alice Alison", "alice@someplace.com"));
        contacts.add(new Contact("Bob Bond", "bob@someplace.com", "007"));
        contacts.add(new Contact("Candy Clein", "candy@someplace.com", "1234567"));
        contacts.add(new Contact("Dan Donnovan", "dan@someplace.com"));
        contacts.add(new Contact("Emma Emmerson", "emma@someplace.com", "666777"));
        contacts.add(new Contact("Fanny Finley", "fanny@someplace.com", "55667788"));
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
        String[] contactNames = new String[contacts.size()];
        int i = 0;
        for (Contact contact: contacts) {
            contactNames[i++] = contact.getName();
        }
        lvList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactNames));
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ContactDetailActivity.class);
                Contact contact = contacts.get(position);
                intent.putExtra(KEY_NAME, contact.getName());
                intent.putExtra(KEY_EMAIL, contact.getEmail());
                intent.putExtra(KEY_PHONE, contact.getPhone());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,getString(R.string.event_start), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,getString(R.string.event_restart), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,getString(R.string.event_resume), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,getString(R.string.event_pause), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,getString(R.string.event_stop), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,getString(R.string.event_destroy), Toast.LENGTH_SHORT).show();
    }
}
