package com.example.jarojas.example.db;

/**
 * Created by jarojas on 2/04/17.
 */

final class PetTable {
    static final  String PET_DB_NAME = "myPet";
    static final int PET_DB_VERSION = 1;

    static final String PET_TABLE ="pet";
    static final String COL_ID = "id";
    static final String COL_NAME = "name";
    static final String COL_RATING = "rating";
    static final String COL_PHOTO_ID = "photo_id";

    static final String DDL_CREATE = "create table pet(" +
            COL_ID+" integer primary key autoincrement," +
            COL_NAME+" text," +
            COL_RATING+" integer," +
            COL_PHOTO_ID+" integer)";

    static final String DDL_DROP = "drop table if exists "+PET_TABLE;

    static final String DML_SELECT_ALL = "select " +
            COL_ID +"," +
            COL_NAME +"," +
            COL_RATING +"," +
            COL_PHOTO_ID +
            " from "+PET_TABLE;

    static final String DML_SELECT_TOP_5_BY_RATING = "select " +
            COL_ID +"," +
            COL_NAME +"," +
            COL_RATING +"," +
            COL_PHOTO_ID +
            " from "+PET_TABLE+" order by "+COL_RATING+" desc limit 5";
}
