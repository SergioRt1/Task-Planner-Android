package com.sergiort.taskplanner.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.sergiort.taskplanner.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity {

    private final ExecutorService executorService = Executors.newFixedThreadPool( 1 );

    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
    }

    public void onLogin(View button) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if(isValid(email) && !password.isEmpty()){
            button.setEnabled(false);
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }

    private boolean isValid(String email){
        return !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }



}
