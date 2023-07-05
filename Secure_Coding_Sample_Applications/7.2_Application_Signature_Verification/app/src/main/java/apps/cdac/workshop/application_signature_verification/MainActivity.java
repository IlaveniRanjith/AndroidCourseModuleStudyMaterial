package apps.cdac.workshop.application_signature_verification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    //SHA1 hash of the Release Certificate
    private static String CERTIFICATE_SHA1 = "34B463B68F55C34433747AA6AA784E1A28954F53";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvSignatureStatus = findViewById(R.id.tv_signature_status);

        tvSignatureStatus.setText(String.valueOf(validateAppSignature(this)));

    }

    public static boolean validateAppSignature(Context context) {
        try {
            // get the signature form the package manager
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(),
                            PackageManager.GET_SIGNATURES);
            Signature[] appSignatures = packageInfo.signatures;

            //this sample only checks the first certificate
            for (Signature signature : appSignatures) {

                byte[] signatureBytes = signature.toByteArray();

                //calc sha1 in hex
                String currentSignature = calcSHA1(signatureBytes);
                //compare signatures
                return CERTIFICATE_SHA1.equalsIgnoreCase(currentSignature);
            }
        } catch (Exception e) {
            // if error assume failed to validate
        }
        return false;
    }

    private static String calcSHA1(byte[] signature) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA1");
        digest.update(signature);
        byte[] signatureHash = digest.digest();
        return bytesToHex(signatureHash);
    }

    public static String bytesToHex(byte[] bytes) {
        final char[] hexArray = { '0', '1', '2', '3', '4', '5', '6',
                '7', '8','9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}




