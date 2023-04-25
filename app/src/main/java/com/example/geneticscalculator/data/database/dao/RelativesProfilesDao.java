package com.example.geneticscalculator.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.models.RelativesListItem;

import java.util.List;
@Dao
public interface RelativesProfilesDao {
    @Query("SELECT * FROM relatives_profiles_table")
    LiveData<List<RelativesEntity>> getRelativesList();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(RelativesEntity doctorListItem);
    @Query("SELECT * FROM relatives_profiles_table WHERE :id LIKE id")
    LiveData<RelativesEntity> getItem(int id);
}

