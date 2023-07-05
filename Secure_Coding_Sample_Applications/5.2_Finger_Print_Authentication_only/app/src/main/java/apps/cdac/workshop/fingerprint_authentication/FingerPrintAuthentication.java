package apps.cdac.workshop.fingerprint_authentication;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;

public class FingerPrintAuthentication {

    private FingerprintManager fingerprintManager;
    private CancellationSignal cancellationSignal;

    public FingerPrintAuthentication(Context context) {
        fingerprintManager = (FingerprintManager) context.getSystemService(Context.FINGERPRINT_SERVICE);
        reset();
    }

    public boolean startAuthentication(final FingerprintManager.AuthenticationCallback callback) {

        cancellationSignal = new CancellationSignal();

        //Callback which accepts the result of fingerprint authentication
        FingerprintManager.AuthenticationCallback hook = new FingerprintManager.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                if (callback != null) {
                    callback.onAuthenticationError(errorCode, errString);
                }
                reset();
            }
            @Override
            public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                super.onAuthenticationHelp(helpCode, helpString);

                if (callback != null) {
                    callback.onAuthenticationHelp(helpCode, helpString);
                }

            }
            @Override
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);

                if (callback != null) {
                    callback.onAuthenticationSucceeded(result);
                }
                reset();

            }
            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();

                if(callback != null) {
                    callback.onAuthenticationFailed();
                }
            }
        };

        //perform Fingerprint authentication
        fingerprintManager.authenticate(null, cancellationSignal, 0, hook, null);

        return true;

    }


    public boolean isAuthenticating() {
        return cancellationSignal != null && !cancellationSignal.isCanceled();
    }

    public void cancel() {
        if (cancellationSignal != null) {
            if(!cancellationSignal.isCanceled()){
                cancellationSignal.cancel();
            }
        }
    }

    private void reset() {
        cancellationSignal = null;
    }

    public boolean isFingerprintAuthAvailable() {
        return (fingerprintManager.hasEnrolledFingerprints()) ? true : false;
    }

    public boolean isFingerprintHardwareDetected() {
        return fingerprintManager.isHardwareDetected();
    }

}
/*


    public boolean startAuthentication(final FingerprintManager.AuthenticationCallback callback) {
        cancellationSignal = new CancellationSignal();

        //Callback which accepts the result of fingerprint authentication
        FingerprintManager.AuthenticationCallback hook = new FingerprintManager.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                if (callback != null) {
                    callback.onAuthenticationError(errorCode, errString);
                }
                reset();
            }

            @Override
            public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                super.onAuthenticationHelp(helpCode, helpString);
                if (callback != null) {
                    callback.onAuthenticationHelp(helpCode, helpString);
                }
                //reset();
            }

            @Override
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                if (callback != null) {
                    callback.onAuthenticationSucceeded(result);
                }
                reset();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                if(callback != null) {
                    callback.onAuthenticationFailed();
                }
                //reset();
            }
        };

        //Perform fingerprint authentication
        fingerprintManager.authenticate(null, cancellationSignal, 0, hook, null);
        return true;
    }
*/

