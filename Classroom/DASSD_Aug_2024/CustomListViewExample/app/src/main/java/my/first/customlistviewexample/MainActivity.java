package my.first.customlistviewexample;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Contact> myContactsList;

    ListView lvContactList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateContactList();

        lvContactList = findViewById(R.id.lv_contact_list);

        MyCustomContactListAdapter contactListAdapter = new MyCustomContactListAdapter(MainActivity.this, myContactsList);

        lvContactList.setAdapter(contactListAdapter);



    }

    private void generateContactList() {
        myContactsList = new ArrayList<Contact>();

        Contact contact1 = new Contact(R.drawable.img1, "Kushal", "123456789");
        myContactsList.add(contact1);

        myContactsList.add(new Contact(R.drawable.img2, "Shivangi", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img3, "Amit", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img4, "Surya", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img5, "Sri Ram", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img6, "Mayank", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img7, "Meghana", "9874563210"));


        myContactsList.add(new Contact(R.drawable.img2, "Shivangi", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img3, "Amit", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img4, "Surya", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img5, "Sri Ram", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img6, "Mayank", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img7, "Meghana", "9874563210"));


        myContactsList.add(new Contact(R.drawable.img2, "Shivangi", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img3, "Amit", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img4, "Surya", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img5, "Sri Ram", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img6, "Mayank", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img7, "Meghana", "9874563210"));


        myContactsList.add(new Contact(R.drawable.img2, "Shivangi", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img3, "Amit", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img4, "Surya", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img5, "Sri Ram", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img6, "Mayank", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img7, "Meghana", "9874563210"));



        myContactsList.add(new Contact(R.drawable.img2, "Shivangi", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img3, "Amit", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img4, "Surya", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img5, "Sri Ram", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img6, "Mayank", "9874563210"));
        myContactsList.add(new Contact(R.drawable.img7, "Meghana", "9874563210"));

    }




}