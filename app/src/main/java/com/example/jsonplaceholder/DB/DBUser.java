package com.example.jsonplaceholder.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.jsonplaceholder.Model.User;

@Database(entities = User.class,exportSchema = false,version = 1)
public abstract class DBUser extends RoomDatabase {
    private static final String DB_NAME = "user_db";
    private static DBUser dbUser;

    public static synchronized DBUser getDbUser(Context context){
        if (dbUser ==null){
            dbUser = Room.databaseBuilder(context.getApplicationContext(),DBUser.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return dbUser;
    }
    public abstract UserDao userDao();
}
