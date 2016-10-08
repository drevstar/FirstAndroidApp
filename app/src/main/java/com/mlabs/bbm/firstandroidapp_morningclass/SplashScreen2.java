package com.mlabs.bbm.firstandroidapp_morningclass;



import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Message;
import android.os.Handler;

import android.widget.ProgressBar;
import android.widget.TextView;

import android.util.Log;


import android.view.Window;

public class SplashScreen2 extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash2);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(4000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally{
                    Intent intent = new Intent(SplashScreen2.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
    @Override
    protected  void onPause(){
        super.onPause();
        finish();
    }


}