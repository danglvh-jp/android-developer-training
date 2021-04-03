package com.example.roomdatabaseandroidtutorial.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabaseandroidtutorial.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insertUser(User user);

    @Query("select * from user")
    List<User> getListUser();
}
