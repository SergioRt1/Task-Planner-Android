package com.sergiort.taskplanner.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import com.sergiort.taskplanner.db.utils.DateConverter;
import com.sergiort.taskplanner.db.model.Task;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
@TypeConverters(DateConverter.class)
public interface TaskDao {

    @Query("SELECT * FROM task WHERE id = :id")
    Task loadTaskById(int id);

    @Query("SELECT * FROM task " +
            "INNER JOIN user ON task.owner = user.username " +
            "WHERE user.username LIKE :username")
    LiveData<Task> loadTasksByUser(String username);

    @Insert(onConflict = IGNORE)
    void insertTask(Task user);

    @Update(onConflict = REPLACE)
    void updateTask(Task book);

    @Delete
    void deleteTask(Task task);
}
