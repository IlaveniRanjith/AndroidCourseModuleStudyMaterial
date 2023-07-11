package com.abhishek.mycontactlistclientapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView contactsListView;
    private SimpleCursorAdapter cursorAdapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsListView = findViewById(R.id.listViewContacts);

        setupListView();
        loadContacts();

    }

    private void setupListView() {
        String [] columns = {Contract.Entry.COLUMN_NAME, Contract.Entry.COLUMN_EMAIL, Contract.Entry.COLUMN_PHONE};
        int [] id = {R.id.textViewName, R.id.textViewEmail, R.id.textViewPhone};

        cursorAdapter = new SimpleCursorAdapter(this, R.layout.list_item_contact, null, columns, id, 0);
        contactsListView.setAdapter(cursorAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void loadContacts() {
        Uri uri = Uri.parse("content://com.abhishek.mycontacts.provider/contacts");
        String [] projection = {Contract.Entry._ID, Contract.Entry.COLUMN_NAME, Contract.Entry.COLUMN_EMAIL, Contract.Entry.COLUMN_PHONE};
        Cursor cursor = getContentResolver().query(uri, projection, null, null);
        if (cursor != null){
            cursorAdapter.changeCursor(cursor);
        }
    }
}