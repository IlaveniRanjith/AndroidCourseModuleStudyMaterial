package apps.cdac.workshop.sql_parameterized_queries;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button btnAdd, btnUpdate, btnDelete;
    private EditText etEmail;
    private ListView listViewEmails;
    private String saveEmail = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init views
        etEmail = findViewById(R.id.et_Email);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        listViewEmails = findViewById(R.id.list_view_Emails);
        //Attach Listeners
        listViewEmails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listViewEmails.getItemAtPosition(position);
                etEmail.setText(item);
                saveEmail = item;
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.getInstance(MainActivity.this)
                        .insertNewEmail(etEmail.getText().toString());
                reloadEmails();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.getInstance(MainActivity.this)
                        .updateEmail(saveEmail, etEmail.getText().toString());
                reloadEmails();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.getInstance(MainActivity.this)
                        .deleteEmail(etEmail.getText().toString());
                reloadEmails();
            }
        });

        reloadEmails();
    }

    private void reloadEmails() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                DBHelper.getInstance(this).getAllEmails());

        listViewEmails.setAdapter(adapter);
    }
}

