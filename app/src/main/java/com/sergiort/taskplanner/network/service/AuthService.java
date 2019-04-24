package com.sergiort.taskplanner.network.service;

import com.sergiort.taskplanner.network.data.LoginWrapper;
import com.sergiort.taskplanner.network.data.Token;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("login")
    Call<Token> login(@Body LoginWrapper user);
}
