package com.example.toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText loginname, password;
    Button buttonSubmit, sharebutton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        loginname = (EditText) findViewById(R.id.loginname);
        password = (EditText) findViewById(R.id.password);
        sharebutton =(Button)findViewById(R.id.sharebutton);
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent=new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String app_url="https://paly.google.com/store/apps/details?id=int";
                startActivity(Intent.createChooser(shareIntent,"Share via"));
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N_MR1)
            @Override
            public void onClick(View v) {
                checkPassword();
            }
        });
    }

    private void checkPassword() {
        String name = loginname.getText().toString();
        String pass = password.getText().toString();
        String name1= "Shan";
        String pass1= "1712";
        if (!name.isEmpty() && !pass.isEmpty()) {

            if (name.equals(name1) && pass.equals(pass1))
                showToast("Login Successfully");
            else {
                showToast("Invalid name or password");
        }}
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
}
}

