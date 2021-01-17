package com.example.bikewise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout signUpExitSection, rellay1;

    EditText email, pass;
    Button login;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            signUpExitSection.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        signUpExitSection = (RelativeLayout) findViewById(R.id.signUpExitSection);

        handler.postDelayed(runnable, 2000);

        this.email = (EditText) findViewById(R.id.et_email);
        this.pass = (EditText) findViewById(R.id.et_password);
        this.login = (Button) findViewById(R.id.btn_login);

        this.login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String toastMsg = "";
        if(this.email.getText().length() > 0 && this.pass.getText().length() > 0){
            //Login Fitur sementara. Nantinya bisa menggunakan presenter untuk menyimpan email dan password sesuai index bila matching
            toastMsg = this.email.getText().toString() + " has Logged In Successfully";
            Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
        } else {
            toastMsg = "Email or Passowrd is Incorrect!";
            Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
        }
    }
}
