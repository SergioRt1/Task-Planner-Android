package com.sergiort.taskplanner.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.sergiort.taskplanner.R;
import com.sergiort.taskplanner.network.RetrofitConnection;
import com.sergiort.taskplanner.network.data.LoginWrapper;
import com.sergiort.taskplanner.network.data.Token;
import com.sergiort.taskplanner.utils.Storage;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private final ExecutorService executorService = Executors.newFixedThreadPool( 1 );

    private Storage storage;

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.storage = new Storage(this);
        RetrofitConnection.setStorage(this.storage);
        this.usernameEditText = findViewById(R.id.editTextUsername);
        this.passwordEditText = findViewById(R.id.editTextPassword);
    }

    public void onLogin(final View button) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if(!username.isEmpty() && !password.isEmpty()){
            final LoginWrapper loginWrapper = new LoginWrapper(username,password);
            button.setEnabled(false);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Call<Token> call = RetrofitConnection.getAuthService().login(loginWrapper);
                        Response<Token> response = call.execute();
                        if(response.isSuccessful()){
                            Token token = response.body();

                            storage.saveToken(token);
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }else{
                            showErrorMessage(button);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    private void showErrorMessage( final View view ) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.setEnabled(true);
                Snackbar.make(view, getString(R.string.server_error_message), Snackbar.LENGTH_LONG);
            }
        });

    }

}
