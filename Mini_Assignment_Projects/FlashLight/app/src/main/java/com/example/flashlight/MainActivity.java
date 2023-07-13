package com.example.flashlight;


import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CameraManager cameraManager;
    private String cameraId;
    private Switch flashlightSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flashlightSwitch = findViewById(R.id.flashlight_switch);

        cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);

        try {
            cameraId = cameraManager.getCameraIdList()[0]; //back camera ID
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        flashlightSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFlashlight();
            }
        });
    }

    private void toggleFlashlight() {
        try {
            if (flashlightSwitch.isChecked()){
                cameraManager.setTorchMode(cameraId,true);
            } else{
                cameraManager.setTorchMode(cameraId,false);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}
