package com.example.sqlitedatabasesample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

//1. Create a class (name it anything that you want) and extend it with SQliteOpenHelper (an abstract class)
public class MyStudentDBHelper extends SQLiteOpenHelper {

    //4. Declare and initialize the relevant variables which will be used for later part of code
    public static final String DATABASE_NAME = "MyStudentsDatabase"; //This database file would be saved in the /data/data/<package-name>/databases/ directory+
    final String TABLE_NAME = "StudentsContacts";
    public static final int DATABASE_VERSION = 1;

    //4.1 Create variables for each of the column that you want to keep in the table
    final static String COL_ONE = "ID";
    final static String COL_TWO = "Name";
    final String COL_THREE = "Phone";

    //4.2 we need to have one SQLiteDatabase object which will be used to carry out all of the operations
    SQLiteDatabase myDb;
    Context context; // it will be passed to the super class constructor

    //5. Take the context from constructor and pass the additional values to the constructor of super class
    public MyStudentDBHelper(Context context){
        //i.e context, database_name, factoryObject(null), database version
        super(context,DATABASE_NAME, null, DATABASE_VERSION ); //TODO: fixed by Pushpha
        this.context = context;
    }

    //2. Override the below function and execute the create table query.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //6. Generate a query for creating a table
        //example: CREATE TABLE StudentsContacts (ID INTEGER PRIMARY KEY, Name TEXT, Phone TEXT);
        String tableQuery = "CREATE TABLE " + TABLE_NAME + " (" + COL_ONE + " INTEGER PRIMARY KEY, " + COL_TWO + " TEXT, " + COL_THREE + " TEXT);";
        //7. execute the query using execSQL() of SQLiteDatabase class' object (i.e present in the method signature)
        sqLiteDatabase.execSQL(tableQuery);
    }

    //3. Override the below method and execute database recreation related query.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //8. prepare a statement to drop the table if it exists
        //example: DROP TABLE IF EXISTS StudentsContacts;
        String dropTableQuery = "DROP TABLE IF EXISTS '" + TABLE_NAME + "';";
        sqLiteDatabase.execSQL(dropTableQuery);
    }


    /*
    *  ----------------------------- CRUD OPERATIONS ---------------------------- *
    * */

    //9. CREATE/INSERT OPERATION
    public void insertRecord(SContact studentContact){
        //initialze the db object (declared at line num 22)
        myDb = getWritableDatabase();

        //Create a content values object
        ContentValues values = new ContentValues();
        //Use the values object to put the data into corresponding columns
        values.put(COL_TWO, studentContact.getName());
        values.put(COL_THREE, studentContact.getPhone());

        //Call the insert() method as follows using myDb object
        myDb.insert(TABLE_NAME, null, values);

        //close the db object as follows
        myDb.close();

    }

    //10. READ OPERATION
    public ArrayList<SContact> readData(){

        ArrayList<SContact> tmpArrayList = new ArrayList<>();

        //exapmle: SELECT * FROM StudentsContacts
        String readQuery = "SELECT * FROM " + TABLE_NAME;
        //Initialize the database object with readableDatabase() method
        myDb = getReadableDatabase();
        //Then execute the query as follows
        Cursor myCursor = myDb.rawQuery(readQuery, null);

        if(myCursor != null) {

            while (myCursor.moveToNext()){

                SContact tmpContact = new SContact();
                tmpContact.setId(myCursor.getInt((int) myCursor.getColumnIndex(COL_ONE)));
                tmpContact.setName(myCursor.getString((int) myCursor.getColumnIndex(COL_TWO)));
                tmpContact.setPhone(myCursor.getString((int) myCursor.getColumnIndex(COL_THREE)));
                tmpArrayList.add(tmpContact);
            }
        }
        return tmpArrayList;
    }

    //11. DELETE OPERATION
    public void deleteRecord(int id){
        //example: DELETE FROM MyStudentsDatabase WHERE ID=1
        myDb = getWritableDatabase();

        myDb.delete(TABLE_NAME,
                COL_ONE + " = ? ",
                new String[]{String.valueOf(id)});
        myDb.close();
    }

    //12. UPDATE OPERATION
    public void updateRecord(SContact contactToUpdate) {
        //example: UPDATE StudentsContacts SET NAME=value1, PHONE=value2 WHERE ID=value;
        myDb = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_TWO, contactToUpdate.getName());
        values.put(COL_THREE, contactToUpdate.getPhone());


        int val = myDb.update(TABLE_NAME,
                values,
               COL_ONE + "= ?",
                new String [] {String.valueOf(contactToUpdate.getId())});

        Toast.makeText(context, "Value : " + val, Toast.LENGTH_SHORT).show();

        myDb.close();






    }
}

