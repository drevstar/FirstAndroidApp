package com.mlabs.bbm.firstandroidapp_morningclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/**
 * Created by melba on 8/5/16.
 */

import android.view.View;
import android.widget.Button;

public class MainMenu extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        final Button btnTouch = (Button)findViewById(R.id.btnOnTouch1);

        btnTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), OnTouchActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        }
    }