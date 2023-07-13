package com.example.todolist;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText taskEditText;
    private Button addButton;
    private ListView taskListView;
    private ArrayList<String> taskList; // to store the tasks
    private ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskEditText = findViewById(R.id.task_edit_text);
        addButton = findViewById(R.id.add_button);
        taskListView = findViewById(R.id.task_list_view);

        taskList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        taskListView.setAdapter(myAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskEditText.getText().toString().trim();
                if (task.isEmpty()){
                    taskEditText.setError("Please enter a task..");
                    return;
                }

                taskList.add(task);
                myAdapter.notifyDataSetChanged(); //this function is used to refresh the adapter with the updated content
                taskEditText.setText("");
            }
        });

        /*
        * on single tap: strike through the text to mark it as complete, optionally can change the text color also. */
        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView taskTextView = (TextView) taskListView.getChildAt(i);
                taskTextView.setPaintFlags(taskTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG); // to make the text strike through
                taskTextView.setTextColor(Color.GREEN); // to indicate the completed task with GREEN color

            }
        });

        taskListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                taskList.remove(i);
                myAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

}
