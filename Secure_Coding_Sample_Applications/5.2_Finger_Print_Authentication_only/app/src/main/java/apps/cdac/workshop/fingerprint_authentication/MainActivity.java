package apps.cdac.workshop.fingerprint_authentication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private FingerPrintAuthentication fingerPrintAuthentication;
    private Button button_fingerprint_auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fingerPrintAuthentication = new FingerPrintAuthentication(this);
        button_fingerprint_auth = findViewById(R.id.button_fingerprint_auth);

        button_fingerprint_auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!fingerPrintAuthentication.isAuthenticating())
                {
                    if (authenticateByFingerprint()) {
                        setAuthenticationState(true);
                    }
                } else {
                    fingerPrintAuthentication.cancel();
                }
            }
        });
    }

    private void setAuthenticationState(boolean authenticating) {
        button_fingerprint_auth.setText(authenticating ? "Cancel" : "Authenticate");
    }

    private boolean authenticateByFingerprint() {
        if (!fingerPrintAuthentication.isFingerprintHardwareDetected()) {
            //Device has no fingerprint sensor
            return false;
        }
        if (!fingerPrintAuthentication.isFingerprintAuthAvailable()) {
            //Notify the user that registered fingerprint is required
            new AlertDialog.Builder(this)
                    .setTitle(R.string.app_name)
                    .setMessage("No fingerprint is registered\n" +
                            "Please register your fingerprint from 'Security' of setting menu.\n" +
                            "By registering your fingerprint, authentication will be very easy.")
                    .setPositiveButton("OK", null)
                    .show();
            return false;
        }

        //Callback which accepts the result of fingerprint authentication
        FingerprintManager.AuthenticationCallback callback =
                new FingerprintManager.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                showMessage(errString, "#FF0000");
                reset();
            }
            @Override
            public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                super.onAuthenticationHelp(helpCode, helpString);
                showMessage(helpString, "#00FF00");
            }
            @Override
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                showMessage("Authentication succeeded!", "#00FF00");
                reset();

            }
            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                showMessage("Authentication failed!", "#FF0000");
            }
        };

        if (fingerPrintAuthentication.startAuthentication(callback)) {
            showMessage("Touch the fingerprint sensor...", "#000000");
            return true;
        }
        return false;
    }

    private void reset() {
        setAuthenticationState(false);
    }
    private void showMessage(CharSequence msg, String  hexColor) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(msg);
        textView.setTextColor(Color.parseColor(hexColor));
    }

}
