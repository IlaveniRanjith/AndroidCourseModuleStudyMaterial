package com.example.mybackgroundservice;

import android.util.Log;

public class MyThread1 extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 10; i++){
            Log.d("Thread_1", "run: " + i);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


}
