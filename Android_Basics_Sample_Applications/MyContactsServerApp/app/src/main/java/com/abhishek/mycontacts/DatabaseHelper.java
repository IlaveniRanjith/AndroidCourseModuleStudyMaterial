package com.abhishek.mycontacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_database.db";
    private static final int DATABASE_VERSION = 1;

    //Constructor
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTableQuery = "CREATE TABLE " + Contract.Entry.TABLE_NAME + " (" +
                Contract.Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Contract.Entry.COLUMN_NAME + " TEXT, " +
                Contract.Entry.COLUMN_EMAIL + " TEXT, " +
                Contract.Entry.COLUMN_PHONE + " TEXT)";

        sqLiteDatabase.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.Entry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
