package com.sergiort.taskplanner.network.service;

import com.sergiort.taskplanner.network.data.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TaskService {
    @GET("api/tasks/byUser/{username}")
    Call<List<Task>> getTaskByUser(@Path("username") String username);
}
