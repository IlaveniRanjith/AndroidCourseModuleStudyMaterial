package com.example.saveandretrieveprivatefiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
*  /data/data/com.example.saveandretrieveprivatefiles/files/
*
* It is called private storage area for the application
* because no other 3rd party app or system app can access it.
*
*
* */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveFile(View v){

        EditText etFileName = findViewById(R.id.et_file_name);
        EditText etFileContent = findViewById(R.id.et_file_content);

        String fileName = etFileName.getText().toString();
        String fileContent = etFileContent.getText().toString();

        File myFile = new File(getFilesDir() + "/" + fileName + ".txt");

        try{
            FileOutputStream outputStream = new FileOutputStream(myFile);
            OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(streamWriter);

            bufferedWriter.write(fileContent);

            bufferedWriter.close();
            streamWriter.close();
            outputStream.close();

         } catch (IOException e){}






    }


    public void readFile(View v){
        File fileToBeRead = new File(getFilesDir() + "/" + "MyFile2" + ".txt");

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