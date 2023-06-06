package com.example.geneticscalculator.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.geneticscalculator.data.database.dao.DatesProfilesDao;
import com.example.geneticscalculator.data.database.entity.DatesEntity;


@Database(entities = {DatesEntity.class}, version = 1, exportSchema = false)
public abstract class DatesDataBase extends RoomDatabase {
    private static volatile DatesDataBase INSTANCE;
    public abstract DatesProfilesDao DatesProfilesDao();
    public static DatesDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatesDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DatesDataBase.class, "dates_profile_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
