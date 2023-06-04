package com.example.geneticscalculator.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.geneticscalculator.data.database.dao.RelativesProfilesDao;
import com.example.geneticscalculator.data.database.entity.RelativesEntity;

@Database(entities = {RelativesEntity.class}, version = 1, exportSchema = false)
public abstract class RelativesDataBase extends RoomDatabase {
    private static volatile RelativesDataBase INSTANCE;
    public abstract RelativesProfilesDao RelativesProfilesDao();
    public static RelativesDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RelativesDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    RelativesDataBase.class, "relatives_profile_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
