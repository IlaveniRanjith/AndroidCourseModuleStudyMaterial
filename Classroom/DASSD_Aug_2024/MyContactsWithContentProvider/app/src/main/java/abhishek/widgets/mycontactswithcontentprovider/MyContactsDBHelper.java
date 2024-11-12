package abhishek.widgets.mycontactswithcontentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.telecom.Conference;

import androidx.annotation.Nullable;

public class MyContactsDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "my_database";

    public static final String TABLE_NAME = "my_contacts";

    public static final int DATABASE_VERSION = 1;

    public static final String COL_ID = "_id";

    public static final String COL_NAME = "name";

    public static final String COL_EMAIL = "email";

    public static final String COL_PHONE = "phone";





    public MyContactsDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*
        * example:
        * CREATE TABLE contacts (ID INTEGER PRIMARY KEY,
        *                           NAME TEXT,
        *                           EMAIL TEXT,
        *                           PHONE TEXT);
        *
        * */
        String createTableQuery = "CREATE TABLE " + TABLE_NAME +
                " (" + COL_ID + " INTEGER PRIMARY KEY, " +
                COL_NAME + " TEXT, " + COL_EMAIL + " TEXT, " +
                COL_PHONE + " TEXT);" ;

        sqLiteDatabase.execSQL(createTableQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //example: DROP TABLE IF EXISTS contacts;
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_NAME + ";" ;
        sqLiteDatabase.execSQL(dropTableQuery);
    }


}
