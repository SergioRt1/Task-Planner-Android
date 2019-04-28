package com.sergiort.taskplanner.network;

import com.sergiort.taskplanner.network.service.AuthService;
import com.sergiort.taskplanner.network.service.TaskService;
import com.sergiort.taskplanner.utils.Storage;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {

    private static AuthService authService = null;
    private static TaskService taskService = null;

    private static Storage storage = null;

    private static final String BASE_URL = "https://api-task-planner.herokuapp.com";

    private static void createAuthConnection() {
        if (authService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL) //localhost for emulator
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            authService = retrofit.create(AuthService.class);
        }
    }

    public static AuthService getAuthService() {
        if (authService == null) {
            createAuthConnection();
        }
        return authService;
    }

    private static void createTaskConnection(final String token) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain)
                    throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder().header("Accept", "application/json").header("Authorization",
                        "Bearer "
                                + token).method(
                        original.method(), original.body()).build();
                return chain.proceed(request);
            }
        });
        Retrofit retrofit =
                new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(
                        httpClient.build()).build();
        taskService = retrofit.create(TaskService.class);
    }

    public static TaskService getTaskService() {
        if (taskService == null) {
            String token = storage.getToken();
            createTaskConnection(token);
        }
        return taskService;
    }

    public static void setStorage(Storage st) {
        storage = st;
    }
}
