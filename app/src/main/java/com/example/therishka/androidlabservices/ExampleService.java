package com.example.therishka.androidlabservices;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class ExampleService extends Service {
    boolean mWithDestroy;

    public ExampleService() {
    }

    @Override
    public void onCreate() {
        System.out.println("TAG onCreate!");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "TIME FREEZE", Toast.LENGTH_SHORT).show();
        mWithDestroy = intent.getExtras().getBoolean("with_destroy");
        System.out.println("TAG With destroy = " + mWithDestroy);
        System.out.println("TAG GO FOR IT! JIIHA! startId = " + startId);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 500);
        if (mWithDestroy) {
            stopSelf();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("TAG onDestroy!");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented!");
    }
}
