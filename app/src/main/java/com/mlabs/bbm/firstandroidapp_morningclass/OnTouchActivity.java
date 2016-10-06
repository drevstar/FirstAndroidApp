package com.mlabs.bbm.firstandroidapp_morningclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.view.View;
import android.widget.Toast;
import android.util.Log;


public class OnTouchActivity extends AppCompatActivity {

    private float initX = 0, initY = 0, finalX = 0, finalY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_touch);

        final ImageView image = (ImageView)findViewById(R.id.imageView2);
        image.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View view, MotionEvent motionEvent) {
                int event = motionEvent.getAction();
                switch (event){
                    case MotionEvent.ACTION_DOWN:
                        initX = motionEvent.getX();
                        initY = motionEvent.getY();
                        Toast.makeText(getApplicationContext(),"Value of X: " + initX + " Value of Y: " + initY, Toast.LENGTH_LONG).show();
                        Log.d(getApplicationContext().toString(),"IMAGE WAS PRESSED");
                        return true;
                    case MotionEvent.ACTION_UP:
                        finalX = motionEvent.getX();
                        finalY = motionEvent.getY();
                        displayAction(initX, finalX, initY, finalY);
                        return true;
                }

                return false;
            }
        });
    }
    public void displayAction(float initX, float finalX, float initY, float finalY){
        String msg = "";

        if(initX < finalX) {
            msg = String.format("SWIPED RIGHT");
        }else if (initX > finalX){
            msg = String.format("SWIPED LEFT");
        }
        Toast.makeText(getApplicationContext(), ""+msg, Toast.LENGTH_SHORT).show();

        if(initY < finalY) {
            msg = String.format("SWIPED DOWN");
        }else if (initY > finalY){
            msg = String.format("SWIPED UP");
        }
        Toast.makeText(getApplicationContext(), ""+msg, Toast.LENGTH_SHORT).show();
    }
}