package abhishek.widgets.mycontactswithcontentproviderclientapp;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse("content://abhishek.widgets.mycontactswithcontentprovider.MyContactsProvider/my_contacts");

        String [] projection = {
                "_id", "name", "email", "phone"
        };

        Cursor cursor = getContentResolver().query(uri, projection, null, null);


        ArrayList<MyContact> contactList = new ArrayList<>();

        if (cursor!=null) {

            while(cursor.moveToNext()) {
                MyContact tmpContact = new MyContact();

                tmpContact.setName(cursor.getString((int)cursor.getColumnIndex("name")));
                tmpContact.setEmail(cursor.getString((int)cursor.getColumnIndex("email")));
                tmpContact.setPhone(cursor.getString((int)cursor.getColumnIndex("phone")));
                tmpContact.setId(cursor.getInt((int)cursor.getColumnIndex("_id")));
                contactList.add(tmpContact);
            }
        }

        ListView listView = findViewById(R.id.listViewContacts);
        listView.setAdapter(new MyContactListAdapter(MainActivity.this, contactList));





    }
}