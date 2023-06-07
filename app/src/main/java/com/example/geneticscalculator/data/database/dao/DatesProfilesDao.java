package com.example.geneticscalculator.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.geneticscalculator.data.database.entity.DatesEntity;

import java.util.List;

@Dao
public interface DatesProfilesDao {

    @Query("SELECT * FROM dates_profiles_table")
    LiveData<List<DatesEntity>> getDatesList();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(DatesEntity datesEntity);

    @Query("DELETE FROM dates_profiles_table WHERE :id = id")
    void delete(int id);

    @Query("SELECT * FROM dates_profiles_table WHERE :id = id")
    LiveData<DatesEntity> getItem(int id);

    @Query("UPDATE dates_profiles_table SET datesType = :datesType," +
            "datesInfo = :datesInfo, datesText = :datesText WHERE id = :id")
    void update(
            int id,
            String datesType,
            String datesInfo,
            String datesText
    );
}
