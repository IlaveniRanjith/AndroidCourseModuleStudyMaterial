package com.example.contactsmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhone;
    private Button btSaveUpdate;
    private ListView contactsListView;

    private SimpleCursorAdapter cursorAdapter;
    private long contactID = 0;
    private boolean isUpdate = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize list views
        etName = findViewById(R.id.editTextName);
        etEmail = findViewById(R.id.editTextEmail);
        etPhone = findViewById(R.id.editTextPhone);
        contactsListView = findViewById(R.id.listViewContacts);
        btSaveUpdate = findViewById(R.id.buttonSave);

        btSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isUpdate){
                    updateContact();
                } else {
                    saveContact();
                }
            }
        });

        setupListView();
        loadContacts();


    }

    private void updateContact() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()){
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(Contract.Entry.COLUMN_NAME, name);
        contentValues.put(Contract.Entry.COLUMN_EMAIL, email);
        contentValues.put(Contract.Entry.COLUMN_PHONE, phone);

        Uri updateUri = Uri.withAppendedPath(MyContentProvider.CONTENT_URI, String.valueOf(contactID));

        int rowsUpdated = getContentResolver().update(updateUri, contentValues, null, null);

        if (rowsUpdated > 0) {
            Toast.makeText(this, "Contact Updated Successfully !!", Toast.LENGTH_SHORT).show();
            clearFields();
            loadContacts();
            isUpdate = false;
            btSaveUpdate.setText("Save");
        }

    }

    private void saveContact() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()){
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(Contract.Entry.COLUMN_NAME, name);
        contentValues.put(Contract.Entry.COLUMN_EMAIL, email);
        contentValues.put(Contract.Entry.COLUMN_PHONE, phone);

        Uri insertUri = getContentResolver().insert(MyContentProvider.CONTENT_URI, contentValues);
        Toast.makeText(this, "Contact Saved Successfully", Toast.LENGTH_SHORT).show();

        clearFields();
        loadContacts();





    }

    private void clearFields() {
        etPhone.setText("");
        etEmail.setText("");
        etName.setText("");
    }

    private void setupListView() {
        String [] columns = {Contract.Entry.COLUMN_NAME, Contract.Entry.COLUMN_EMAIL, Contract.Entry.COLUMN_PHONE};
        int [] id = {R.id.textViewName, R.id.textViewEmail, R.id.textViewPhone};

        cursorAdapter = new SimpleCursorAdapter(this, R.layout.list_item_contact, null, columns, id, 0);
        contactsListView.setAdapter(cursorAdapter);

        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor cursor = (Cursor) adapterView.getItemAtPosition(i);

                contactID = cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Entry._ID));

                String name = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Entry.COLUMN_NAME));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Entry.COLUMN_PHONE));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Entry.COLUMN_EMAIL));

                etName.setText(name);
                etPhone.setText(phone);
                etEmail.setText(email);

                isUpdate = true;
                btSaveUpdate.setText("Update");

            }
        });

        contactsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Cursor cursor = (Cursor) adapterView.getItemAtPosition(i);
                long contactID = cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Entry._ID));

                Uri deleteURI = Uri.withAppendedPath(MyContentProvider.CONTENT_URI, String.valueOf(contactID));
                int rowsDeleted = getContentResolver().delete(deleteURI, null, null);
                if (rowsDeleted > 0){
                    Toast.makeText(MainActivity.this, "Contact Deleted !!", Toast.LENGTH_SHORT).show();
                    loadContacts();
                }



                return true;
            }
        });
    }

    private void loadContacts() {
        String [] projection = {Contract.Entry._ID, Contract.Entry.COLUMN_NAME, Contract.Entry.COLUMN_EMAIL, Contract.Entry.COLUMN_PHONE};
        Cursor cursor = getContentResolver().query(MyContentProvider.CONTENT_URI, projection, null, null, null);

        if (cursor != null){
            cursorAdapter.changeCursor(cursor);
        }
    }
}