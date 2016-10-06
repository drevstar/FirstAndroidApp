package com.mlabs.bbm.firstandroidapp_morningclass;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.regex.Matcher; //Used for validating email and password
import java.util.regex.Pattern;
/*
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.widget.Toast;
import android.util.Log;
import android.text.TextWatcher;
*/
import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper accountsDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountsDb = new DatabaseHelper(this);

        final EditText loginEmail = (EditText) findViewById(R.id.editTextEmail);
        final EditText loginPassword = (EditText) findViewById(R.id.editTextPass);
        final TextView show = (TextView) findViewById(R.id.textViewShowPassword);
        final Button loginwithregex = (Button) findViewById(R.id.loginButton);
        final TextView register = (TextView) findViewById(R.id.textViewRegister);

        loginwithregex.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String loginE = loginEmail.getText().toString().trim();
                String loginPass = loginPassword.getText().toString().trim();
                String verifyUser = accountsDb.getSingleEntryUname(loginE);
                String verifyEmail = accountsDb.getSingleEntryEmail(loginE);

                if(validateEmail(loginE)){
                        if (loginPass.equals(verifyEmail)) {
                            Intent myIntent = new Intent(MainActivity.this, MainMenu.class);
                            startActivity(myIntent);
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this,"Invalid Username/Email and Password", Toast.LENGTH_LONG).show();
                            loginEmail.requestFocus();
                        }
                }
                else if(loginPass.equals(verifyUser)) {
                        Intent myIntent = new Intent(MainActivity.this, MainMenu.class);
                        startActivity(myIntent);
                        finish();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Invalid Username/Email and Password", Toast.LENGTH_LONG).show();
                        loginEmail.requestFocus();
                    }
                }

        });

        show.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        loginPassword.setTransformationMethod(null);
                        return true;
                    case MotionEvent.ACTION_UP:
                        loginPassword.setTransformationMethod(new PasswordTransformationMethod());
                        return false;
                }
                    return false;
        }

        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), AccountRegister.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
            });
    }

        protected boolean validateEmail(String email) {
            String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(email);

            return matcher.matches();
        }
    @Override
    protected void onResume() {
        super.onResume();

    }

}
