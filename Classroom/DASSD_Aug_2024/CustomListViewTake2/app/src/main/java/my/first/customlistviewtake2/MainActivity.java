package my.first.customlistviewtake2;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //1. declare an object for the listview
    ListView lvContactListView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2. attach it with the actual widget
        lvContactListView = findViewById(R.id.lv_list_view_contact);

        //3. define a list to store the data
        ArrayList<MyContact> myContactsList = new ArrayList<MyContact>();

        //4. populate the list with data
        myContactsList.add(new MyContact(R.drawable.img2, "Shivangi", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img3, "Amit", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img4, "Surya", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img5, "Sri Ram", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img6, "Mayank", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img7, "Meghana", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img2, "Shivangi", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img3, "Amit", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img4, "Surya", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img5, "Sri Ram", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img6, "Mayank", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img7, "Meghana", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img2, "Shivangi", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img3, "Amit", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img4, "Surya", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img5, "Sri Ram", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img6, "Mayank", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img7, "Meghana", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img2, "Shivangi", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img3, "Amit", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img4, "Surya", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img5, "Sri Ram", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img6, "Mayank", "9874563210"));
        myContactsList.add(new MyContact(R.drawable.img7, "Meghana", "9874563210"));

        //5. define the custom list adapter
        MyContactListAdapter myContactListAdapter = new MyContactListAdapter(MainActivity.this, myContactsList);

        //6. set the adapter to the listview object
        lvContactListView.setAdapter(myContactListAdapter);

    }

}