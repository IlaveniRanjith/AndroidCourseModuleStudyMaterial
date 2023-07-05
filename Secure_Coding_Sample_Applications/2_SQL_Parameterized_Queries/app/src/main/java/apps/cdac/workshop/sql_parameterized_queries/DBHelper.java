package apps.cdac.workshop.sql_parameterized_queries;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper instance;
    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "my_secure_database.db";

    public static final String TABLE_NAME = "CONTACTS";
    public static final String COLUMN_EMAIL = "EMAIL";

    private static final String SQL_CREATE_TABLE_QUERY =
            "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_EMAIL + " TEXT PRIMARY KEY)";

    private static final String SQL_DELETE_TABLE_QUERY =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }
    static public synchronized DBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DBHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_QUERY);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE_QUERY);
        onCreate(db);
    }

    //----------------------- CRUD Operations ---------------------------//
    public void insertNewEmail (String email) {
        SQLiteDatabase db = instance.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        db.insert(TABLE_NAME, null, values);

        db.close();
    }
    public void updateEmail (String oldEmail, String newEmail) {
        SQLiteDatabase db = instance.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, newEmail);
        db.update(TABLE_NAME, values, COLUMN_EMAIL + "= ?", new String [] {oldEmail});
        db.close();
    }
    public void deleteEmail(String email) {

        /*        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        db.delete(TABLE_NAME, COLUMN_EMAIL +"='" + email + "'", null);*/


        SQLiteDatabase db = instance.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_EMAIL + "= ?", new String[] {email});
        db.close();
    }

    public List<String> getAllEmails () {
        SQLiteDatabase db = instance.getWritableDatabase();

        Cursor cursor = db.rawQuery(String.format("SELECT * FROM '%s';", TABLE_NAME), null);
        List<String> emails = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while(!cursor.isAfterLast()) {
                String email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));
                emails.add(email);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return emails;
    }

}



