package com.example.jarojas.example.db;

import static com.example.jarojas.example.db.PetTable.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jarojas.example.R;
import com.example.jarojas.example.model.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jarojas on 2/04/17.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public PetDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public PetDbHelper(Context context) {
        this(context, PET_DB_NAME, null, PET_DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("PETDB", "onCreate!!>>>>>>>>>");
        db.execSQL(DDL_CREATE);
        initDB(db);
    }

    private void initDB(SQLiteDatabase db) {
        insertPet(db, "bugs",0,R.drawable.bunny1);
        insertPet(db, "El Patas",0,R.drawable.bunny2);
        insertPet(db, "Pollete",0,R.drawable.canary1);
        insertPet(db, "Lucas",0,R.drawable.duck1);
        insertPet(db, "Patrick",0,R.drawable.duck2);
        insertPet(db, "Hamtaro",0,R.drawable.hamster1);
        insertPet(db, "Jerry",0,R.drawable.hamster2);
        insertPet(db, "Cucho",0,R.drawable.kitty1);
        insertPet(db, "Tom",0,R.drawable.kitty2);
        insertPet(db, "Don Gritos",0,R.drawable.periquito1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DDL_DROP);
        onCreate(db);
    }

    private void insertPet(SQLiteDatabase db, String name, int rating, int photoId) {
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_RATING, rating);
        values.put(COL_PHOTO_ID, photoId);

        db.insert(PET_TABLE,null,values);
    }

    public List<Pet> findAll() {
        List<Pet> pets = new ArrayList<>();
        Cursor curPets = getWritableDatabase().rawQuery(DML_SELECT_ALL, null);
        while (curPets.moveToNext()) {
            Pet pet = new Pet(
                    curPets.getInt(0),
                    curPets.getString(1),
                    curPets.getInt(2),
                    false,
                    curPets.getInt(3)
            );
            pets.add(pet);
        }
        getWritableDatabase().close();
        return pets;
    }

    public List<Pet> findTop5ByRating() {
        List<Pet> pets = new ArrayList<>();
        Cursor curPets = getWritableDatabase().rawQuery(DML_SELECT_TOP_5_BY_RATING, null);
        while (curPets.moveToNext()) {
            Pet pet = new Pet(
                    curPets.getInt(0),
                    curPets.getString(1),
                    curPets.getInt(2),
                    false,
                    curPets.getInt(3)
            );
            pets.add(pet);
        }
        getWritableDatabase().close();
        return pets;
    }

}
