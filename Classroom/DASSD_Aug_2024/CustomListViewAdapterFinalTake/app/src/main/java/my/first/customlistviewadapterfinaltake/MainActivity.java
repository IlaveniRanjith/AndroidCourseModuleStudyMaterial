package my.first.customlistviewadapterfinaltake;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //1. make a list view object
    ListView lvListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. attach it with the widget
        lvListView = findViewById(R.id.lv_list_view_main);

        //3. generate some data
        String myStudentsName [] = new String [] {"Abhishek1", "Abhishek2", "Abhishek3"};

        //4. create an adapter object
        MyListAdapter adapter = new MyListAdapter(MainActivity.this, myStudentsName);

        //5. set the adapter
        lvListView.setAdapter(adapter);



    }
}

class MyListAdapter extends BaseAdapter {

    private Context context;
    private String studentsNames [];

    public MyListAdapter (Context context, String [] studentsNames){
        this.context = context;
        this.studentsNames = studentsNames;
    }

    @Override
    public int getCount() {
        return studentsNames.length;
    }

    @Override
    public Object getItem(int position) {
        return studentsNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1. inflate the layout
        convertView = LayoutInflater.from(context).inflate(
          R.layout.layout_list_view_single_row,
          parent,
          false
        );
        //2. access the views
        TextView tvName = convertView.findViewById(R.id.tv_name_field);

        //3. perform operations
        tvName.setText(studentsNames[position]);
        //4. return the view
        return convertView;
    }
}