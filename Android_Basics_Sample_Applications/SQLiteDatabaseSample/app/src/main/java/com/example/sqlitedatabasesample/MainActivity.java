package com.example.sqlitedatabasesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //1. Create reference objects for the views.
    EditText etName;
    EditText etPhone;
    ListView myListView;
    MyListViewAdapter myListViewAdapter;

    //Create the reference object for DBHelper class
    MyStudentDBHelper dbHelper;

    ArrayList<SContact> dbContacts;

    SContact contactToUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. Initialize the views
        etName = findViewById(R.id.et_student_name);
        etPhone = findViewById(R.id.et_student_phone);
        myListView = findViewById(R.id.list_view_main);

        //initialize the dbHelper object
        dbHelper = new MyStudentDBHelper(this);

        readContactsFromDB(null);

        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                int id = dbContacts.get(i).getId();
                dbHelper.deleteRecord(id);
                readContactsFromDB(null);

                return true;
            }
        });

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                contactToUpdate = new SContact();

                String name = dbContacts.get(i).getName();
                String phone = dbContacts.get(i).getPhone();

                etName.setText(name);
                etPhone.setText(phone);

                contactToUpdate.setId(dbContacts.get(i).getId());


            }
        });


    }

    public void insertContact(View view) {
        //Take the text from both of the edit texts
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();

        SContact sContact = new SContact();
        sContact.setName(name);
        sContact.setPhone(phone);

        dbHelper.insertRecord(sContact);

        readContactsFromDB(null);

    }

    public void readContactsFromDB(View view) {

       dbContacts = dbHelper.readData();

       myListViewAdapter = new MyListViewAdapter(this, dbContacts);
       myListView.setAdapter(myListViewAdapter);


    }

    public void updateRecord(View view) {

        String updatedName = etName.getText().toString();
        String updatedPhone = etPhone.getText().toString();

        contactToUpdate.setName(updatedName);
        contactToUpdate.setPhone(updatedPhone);


        dbHelper.updateRecord(contactToUpdate);
        readContactsFromDB(null);
    }
}