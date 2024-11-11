package my.first.sms_runtimepermissiondemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


/*
* Refer: https://developer.android.com/reference/android/Manifest.permission
*
* */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
        if(checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            String [] permissionsToRequest = new String[] {
                    android.Manifest.permission.SEND_SMS,
            };
            requestPermissions(permissionsToRequest, 575);
        } else {
            Toast.makeText(this, "Permission has been granted. Sending SMS......", Toast.LENGTH_SHORT).show();
            sendSMS();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 575) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission granted by the user....", Toast.LENGTH_SHORT).show();
                sendSMS();
            } else {
                //alert the user.
                Toast.makeText(this, "Please grant the permission to use the app...", Toast.LENGTH_SHORT).show();
                finish();
            }
        }







    }

    private void sendSMS() {

        String sendTo = "9100517214";
        String msg = "Hii, Apoorvaaa";


        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(sendTo, null, msg, null, null);

    }



}