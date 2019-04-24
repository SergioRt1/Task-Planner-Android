package com.sergiort.taskplanner.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.sergiort.taskplanner.R;
import com.sergiort.taskplanner.network.data.Token;

import static com.sergiort.taskplanner.ui.LaunchActivity.TOKEN_KEY;

public class Storage {

    private final SharedPreferences sharedPreferences;

    public Storage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(context.getString( R.string.preference_file_key ), Context.MODE_PRIVATE );
    }

    public void saveToken(Token token){
        sharedPreferences.edit().putString( TOKEN_KEY, token.getAccessToken()).apply();
    }
}
