package apps.cdac.workshop.intrusion_detection_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvGooglePlayStatus = findViewById(R.id.tv_status_google_play);
        TextView tvEmulatorStatus = findViewById(R.id.tv_status_emulator);
        TextView tvDebuggableStatus = findViewById(R.id.tv_status_debuggable);

        tvGooglePlayStatus.setText(String.valueOf(checkGooglePlayStore(this)));
        tvEmulatorStatus.setText(String.valueOf(isEmulator()));
        tvDebuggableStatus.setText(String.valueOf(isDebuggable(this)));
    }
    //1. Detect if Google Play store was the installer:
    public static boolean checkGooglePlayStore(Context context) {
        String installerPackageName = context.getPackageManager()
                .getInstallerPackageName(context.getPackageName());
        return installerPackageName != null
                && installerPackageName.startsWith("com.google.android");
    }

    //2. Detect if App runs on an emulator.
    public static boolean isEmulator() {
        try {
            Class systemPropertyClazz = Class.forName("android.os.SystemProperties");
            boolean kernelQemu = getProperty(systemPropertyClazz,
                    "ro.kernel.qemu").length() > 0;
            boolean hardwareGoldfish = getProperty(systemPropertyClazz,
                    "ro.hardware").equals("goldfish");
            boolean modelSdk = getProperty(systemPropertyClazz,
                    "ro.product.model").equals("sdk");
            if (kernelQemu || hardwareGoldfish || modelSdk) {
                return true;
            }
        } catch (Exception e) {
            // error assumes emulator
        }
        return false;
    }
    private static String getProperty(Class clazz, String propertyName) throws Exception {
        return (String) clazz.getMethod("get", new Class[] { String.class })
                .invoke(clazz, new Object[] { propertyName });
    }

    //3. Detect if the app has the debuggable flag enabled:
    public static boolean isDebuggable(Context context){
        return (context.getApplicationInfo().flags & ApplicationInfo.
                FLAG_DEBUGGABLE) != 0;
    }

}



