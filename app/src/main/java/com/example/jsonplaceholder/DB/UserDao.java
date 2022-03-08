package com.example.jsonplaceholder.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.jsonplaceholder.Model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("select * from user")
    List<User> getUserList();
    @Insert
    void insertUser(User user);
    @Query("delete from user")
    void deleteUsers();
}
