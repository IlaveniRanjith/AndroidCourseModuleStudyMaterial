package apps.cdac.workshop.case_study_secure_coding_practices;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));

    }
}

