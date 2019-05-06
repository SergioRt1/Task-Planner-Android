package com.sergiort.taskplanner.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sergiort.taskplanner.utils.Storage;

public class LaunchActivity extends AppCompatActivity {

    public static final String TOKEN_KEY = "TOKEN_KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Storage storage = new Storage(this);

        if(storage.containsToken()){
            startActivity(new Intent(this, MainActivity.class));
        }else{
            startActivity(new Intent(this, LoginActivity.class));
        }
        finish();
    }

}
