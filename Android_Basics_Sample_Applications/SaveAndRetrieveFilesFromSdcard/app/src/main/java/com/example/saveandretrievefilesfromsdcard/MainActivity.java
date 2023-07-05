package com.example.saveandretrievefilesfromsdcard;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.PatternMatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/*
 *  Files using below methods would be saved in
 * /sdcard/Downloads/<your-folder-name>/<file-name>
 * It is called private storage area for the application
 * because no other 3rd party app or system app can access it.
 *
 *
 * */
public class MainActivity extends AppCompatActivity {

    EditText etFileName;
    EditText etFileContent;

    Button btnSave, btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFileName = findViewById(R.id.et_file_name);
        etFileContent = findViewById(R.id.et_file_content);

        btnSave = findViewById(R.id.btn_save);
        btnRead = findViewById(R.id.btn_read);


        //1. check self permissions
        if( (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) && (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != 0)){
            //2.request the permissions from user
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 777);
        } else{

            enableAllViews();

        }

    }

    private void enableAllViews(){
        etFileName.setEnabled(true);
        etFileContent.setEnabled(true);

        btnRead.setEnabled(true);
        btnSave.setEnabled(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 777){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permissions granted successfully...", Toast.LENGTH_SHORT).show();
                enableAllViews();
            } else {
                Toast.makeText(this, "Permissions denied....", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void saveFile(View v){


        String fileName = etFileName.getText().toString();
        String fileContent = etFileContent.getText().toString();

        File myDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/MyTestFolder/");

        if(!myDir.exists()){
            myDir.mkdirs();
        }

        File myFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/MyTestFolder/" + fileName + ".txt");



        try{
            FileOutputStream outputStream = new FileOutputStream(myFile, true); //append mode is optional
            OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(streamWriter);

            bufferedWriter.write(fileContent);

            bufferedWriter.close();
            streamWriter.close();
            outputStream.close();

        } catch (IOException e){}






    }


    public void readFile(View v){
        File fileToBeRead = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/MyTestFolder/" + "MyTestFolderFile" + ".txt");

        if(!fileToBeRead.exists()){
            Toast.makeText(this, "File does not exists...", Toast.LENGTH_SHORT).show();
            return;
        }

        try{
            FileInputStream inputStream = new FileInputStream(fileToBeRead);
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            //bufferedReader.readLine();



            String line = "";
            String tmp = "";
            while ((line = bufferedReader.readLine()) != null){
                tmp += line;
            }

            bufferedReader.close();
            streamReader.close();
            inputStream.close();

            TextView tv = findViewById(R.id.tv_show_content);
            tv.setText(tmp);






        } catch (Exception e){
            e.printStackTrace();
        }





    }











/*    public void saveFile(View view) {

        EditText etFileName = findViewById(R.id.et_file_name);
        EditText etFileContent = findViewById(R.id.et_file_content);

        String fileName = etFileName.getText().toString();
        String fileContent = etFileContent.getText().toString();

        File myFile = new File(getFilesDir() + "/" + fileName + ".txt");


       try{
           FileOutputStream outputStream = new FileOutputStream(myFile);
           outputStream.write(fileContent.getBytes());
           outputStream.close();
           Toast.makeText(this, "File saved successfully..", Toast.LENGTH_SHORT).show();
       } catch (IOException e){
           Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
       }
    }

    public void readFile(View view) {

        File fileToBeRead = new File(getFilesDir() + "/" + "MyFile1" + ".txt");

        if(!fileToBeRead.exists()){
            Toast.makeText(this, "File does not exists...", Toast.LENGTH_SHORT).show();
            return;
        }



        try{

            FileInputStream inputStream = new FileInputStream(fileToBeRead);

   *//*         int firstCh = inputStream.read(); //a
            Log.d("CHARACTERS", "" + (char)firstCh);
            int secondCh = inputStream.read(); //b
            Log.d("CHARACTERS", "" + (char) secondCh);
            int third = inputStream.read(); //c
            Log.d("CHARACTERS", "" + third);
            int fourth = inputStream.read(); //d
            Log.d("CHARACTERS", "" + fourth);
            int fifth = inputStream.read(); //e
            Log.d("CHARACTERS", "" + fifth);
            int sixth = inputStream.read(); //f
            Log.d("CHARACTERS", "" + sixth);
            int end = inputStream.read(); //-1
            Log.d("CHARACTERS", "" + end);*//*




            int temp = 0;
            String myString = "";
            while((temp = inputStream.read()) != -1){
                myString += (char) temp;
               //  Log.d();
            }

            //Toast.makeText(this, myString, Toast.LENGTH_SHORT).show();
            TextView tvContent = findViewById(R.id.tv_show_content);
            tvContent.setText(myString);
            inputStream.close();


        } catch (IOException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }






    }*/
}