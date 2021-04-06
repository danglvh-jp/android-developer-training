package com.example.roomdatabaseandroidtutorial.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomdatabaseandroidtutorial.User;

@Database(entities = {User.class}, version = 2)
public abstract class UserDatabase extends RoomDatabase {

    // Them nhieu cot vao trong mot bang
    // ALTER TABLE ten_bang ADD cot1 dinh_nghia_cot1, cot2 dinh_nghia_cot2, cotn dinh_nghia_cotn;

    // Chinh sua kieu du lieu cot trong mot bang
    // ALTER TABLE ten_bang ALTER COLUMN ten_cot kieu_cot;

    // Xoa cot trong mot bang
    // ALTER TABLE ten_bang DROP_COLUMN ten_cot;

    static Migration migration_from_1_to_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // ALTER TABLE ten_bang ADD ten_cot dinh_nghia_cot;
            database.execSQL("alter table user add column year TEXT");
        }
    };

    private static final String DATABASE_NAME = "user.db";
    private static UserDatabase instance;

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .addMigrations(migration_from_1_to_2)
                    .build();
        }
        return instance;
    }

    public abstract UserDAO userDAO();
}
