package com.sergiort.taskplanner.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.sergiort.taskplanner.db.model.User;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE username == :username")
    LiveData<User> loadUserByUsername(String username);

    @Insert(onConflict = IGNORE)
    void insertUser(User user);

    @Update(onConflict = REPLACE)
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("DELETE FROM User")
    void deleteAll();
}
