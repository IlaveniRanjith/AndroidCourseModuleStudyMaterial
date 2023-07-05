package com.example.runtimepermissiondemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import java.sql.SQLOutput;
/*
* Permission based model:
* 4 types of permissions are there:
*   1. Normal:  a permission which is granted to the app upon installation, eg: INTERNET, BLUETOOTH, WAKE_LOCK etc.
*   2. Dangerous: aka Runtime permissions; would be granted only by the user; and are not granted automatically at the install time; eg: CAMERA, MICROPHONE, LOCATION, SMS, READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE, etc
*   3. Signature: these are automatically granted to the app if and only if the signing certificate is same as that of the OS.
*   4. Signature or System:  (aka Previliged apps) if the app is a system app, all of the permissions are granted automatically
* https://developer.android.com/reference/android/Manifest.permission 
*
*
*
* */




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. First thing is to check whether the permissions are granted by the user or not
        if( (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) && (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)){
            //2. request the permission from the user by making an array of those
            String [] permissionToRequestFromUser = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
            //3. pass this array to the requestPermission() method
            requestPermissions(permissionToRequestFromUser, 1601);
        } else{
            Toast.makeText(this, "Permissions have been granted.", Toast.LENGTH_SHORT).show();
        }
        
    }
    
    //4. 


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        
        switch (requestCode){
            case 1601:{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permissions have been granted.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "Permissions denied by the user.", Toast.LENGTH_SHORT).show();
                }
            }
        }
        
        
        
        
        
    }
}