package abhishek.widgets.mycontactswithcontentprovider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhone;

    private Button btnAddUpdate;

    private ListView myContactsListView;

    private ArrayList<MyContact> myContactsList;

    private boolean isUpdate = false;

    int updateContactID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.editTextEmail);
        etName = findViewById(R.id.editTextName);
        etPhone = findViewById(R.id.editTextPhone);

        btnAddUpdate = findViewById(R.id.buttonSave);

        myContactsListView = findViewById(R.id.listViewContacts);


        btnAddUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isUpdate) {
                    updateContact();
                    loadContacts();
                    clearFields();
                } else {
                    saveContact();
                    loadContacts();
                    clearFields();
                }


            }
        });


        myContactsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                int contactID = myContactsList.get(i).getId();

                Uri deleteContactUri = ContentUris.withAppendedId(MyContactsProvider.CONTENT_URI, contactID);

                int result = getContentResolver().delete(deleteContactUri, null, null);

                if(result>0){
                    Toast.makeText(MainActivity.this, "Data deleted....", Toast.LENGTH_SHORT).show();
                }

                loadContacts();

                return true;
            }
        });

        myContactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                updateContactID = myContactsList.get(i).getId();

                etPhone.setText(myContactsList.get(i).getPhone());
                etName.setText(myContactsList.get(i).getName());
                etEmail.setText(myContactsList.get(i).getEmail());

                isUpdate = true;
                btnAddUpdate.setText("Update");

            }
        });

        loadContacts();

    }

    private void updateContact() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();

        ContentValues values = new ContentValues();
        values.put(MyContactsDBHelper.COL_NAME, name);
        values.put(MyContactsDBHelper.COL_EMAIL, email);
        values.put(MyContactsDBHelper.COL_PHONE, phone);


        Uri updateContactURI = ContentUris.withAppendedId(MyContactsProvider.CONTENT_URI, updateContactID);
        getContentResolver().update(updateContactURI, values, null, null);

        isUpdate = false;
        btnAddUpdate.setText("Save");


    }

    private void clearFields() {

        etPhone.setText("");
        etName.setText("");
        etEmail.setText("");

    }

    private void saveContact() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();

        ContentValues values = new ContentValues();
        values.put(MyContactsDBHelper.COL_NAME, name);
        values.put(MyContactsDBHelper.COL_EMAIL, email);
        values.put(MyContactsDBHelper.COL_PHONE, phone);

        getContentResolver().insert(MyContactsProvider.CONTENT_URI, values);

    }

    private void loadContacts() {
        // the projection
        String [] columnsToLoad = {
                MyContactsDBHelper.COL_ID,
                MyContactsDBHelper.COL_PHONE,
                MyContactsDBHelper.COL_EMAIL,
                MyContactsDBHelper.COL_NAME
        };


        Cursor cursor = getContentResolver().query(MyContactsProvider.CONTENT_URI, columnsToLoad, null, null, null);



        if (cursor!=null) {

            myContactsList = new ArrayList<>();

            while (cursor.moveToNext()) {

                MyContact tmpContact = new MyContact();


                tmpContact.setId(cursor.getInt((int)cursor.getColumnIndex(MyContactsDBHelper.COL_ID)));
                tmpContact.setName(cursor.getString((int)cursor.getColumnIndex(MyContactsDBHelper.COL_NAME)));
                tmpContact.setEmail(cursor.getString((int)cursor.getColumnIndex(MyContactsDBHelper.COL_EMAIL)));
                tmpContact.setPhone(cursor.getString((int)cursor.getColumnIndex(MyContactsDBHelper.COL_PHONE)));

                myContactsList.add(tmpContact);

            }

            refreshListView();

        }



    }

    private void refreshListView() {
        MyContactListAdapter adapter = new MyContactListAdapter(MainActivity.this, myContactsList);
        myContactsListView.setAdapter(adapter);
    }
}