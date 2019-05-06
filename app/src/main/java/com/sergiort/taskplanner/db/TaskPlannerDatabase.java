package com.sergiort.taskplanner.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sergiort.taskplanner.db.dao.TaskDao;
import com.sergiort.taskplanner.db.dao.UserDao;
import com.sergiort.taskplanner.db.model.Task;
import com.sergiort.taskplanner.db.model.User;

@Database(entities = {User.class, Task.class}, version = 1)
public abstract class TaskPlannerDatabase extends RoomDatabase {

    private static TaskPlannerDatabase INSTANCE;

    public abstract UserDao userModel();

    public abstract TaskDao taskModel();

    public static TaskPlannerDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), TaskPlannerDatabase.class).build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
