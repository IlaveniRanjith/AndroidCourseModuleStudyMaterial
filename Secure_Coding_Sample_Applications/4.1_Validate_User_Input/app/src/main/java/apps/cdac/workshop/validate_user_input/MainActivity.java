package apps.cdac.workshop.validate_user_input;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
        }


        TextView tv = (TextView) findViewById(R.id.tv_output);
        InputStreamReader isr = null;
        char[] text = new char[1024];
        int read;
        try {
            String urlstr = getIntent().getStringExtra("WEBPAGE_URL");
            URL url = new URL(urlstr);
            String prot = url.getProtocol();


            if (!"http".equals(prot) && !"https".equals(prot)) {
                throw new MalformedURLException("invalid protocol");
            }

            isr = new InputStreamReader(url.openConnection().getInputStream());
            while ((read = isr.read(text)) != -1) {
                tv.append(new String(text, 0, read));
            }
        } catch (MalformedURLException e) {
            Toast.makeText(this, "Malicious Intent Found !! ", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
