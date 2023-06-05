package com.example.geneticscalculator.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.geneticscalculator.data.database.entity.RelativesEntity;

import java.util.List;

@Dao
public interface RelativesProfilesDao {

    @Query("SELECT * FROM relatives_profiles_table")
    LiveData<List<RelativesEntity>> getRelativesList();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(RelativesEntity relativesEntity);

    @Query("DELETE FROM relatives_profiles_table WHERE :id = id")
    void delete(int id);

    @Query("SELECT * FROM relatives_profiles_table WHERE :id = id")
    LiveData<RelativesEntity> getItem(int id);

    @Query("UPDATE relatives_profiles_table SET relativesType = :relativesType, eyeColor = :eyeColor, hairColor = :hairColor, dateofBirth = :dateofBirth, bloodType = :bloodType WHERE id = :id")
    void update(
            int id,
            String relativesType,
            String eyeColor,
            String hairColor,
            String dateofBirth,
            String bloodType
    );
}

