package com.sergiort.taskplanner.utils;


import com.sergiort.taskplanner.db.model.Task;

import java.util.Date;

public class TaskNetworkToDB {

    public static Task taskNetworkToDB(com.sergiort.taskplanner.network.data.Task task){
        Task dbTask = new Task();
        dbTask.setId(task.getId());
        dbTask.setDescription(task.getDescription());
        dbTask.setDueDate(new Date(task.getDueDate()));
        dbTask.setOwner(task.getOwner());
        dbTask.setState(task.getState().toString());
        dbTask.setResponsibleName(task.getResponsible().getName());
        dbTask.setResponsibleEmail(task.getResponsible().getEmail());
        return dbTask;
    }
}
