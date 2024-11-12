package com.example.mybackgroundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class MyBackgroundService extends Service {
    private String TAG = "MYBGService";

    MediaPlayer mediaPlayer;

    public MyBackgroundService() {
    }

    //ignore it
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: my Background service created.");
        //mediaPlayer = MediaPlayer.create(this, R.raw.my_audio_file);
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //MyThread1 myThread1 = new MyThread1();
        mediaPlayer.start();

/*        other way of implementing a thread using runnable interface
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        */



        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: my Background service destroyed.");
        mediaPlayer.stop();
        super.onDestroy();
    }
}