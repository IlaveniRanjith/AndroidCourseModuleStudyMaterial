package com.abhishek.readingphonecontactlistcontentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listViewContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFetchContacts = findViewById(R.id.btnFetch);
        listViewContacts = findViewById(R.id.listContacts);

        btnFetchContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this, new String [] {Manifest.permission.READ_CONTACTS}, 555);
                }

                ContentResolver resolver = getContentResolver();
                Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                Cursor cursor = resolver.query(uri, null, null, null, null);

                String [] columns = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
                int [] to = {R.id.tvName, R.id.tvNumber};

                SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this, R.layout.activity_list_item, null, columns, to, 0);

                if(cursor != null)
                    adapter.changeCursor(cursor);


                listViewContacts.setAdapter(adapter);
            }
        });

    }
}

/*
* Reference: https://www.topcoder.com/thrive/articles/android-content-provider
* */