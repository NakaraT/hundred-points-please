package com.example.geneticscalculator.data.datasource;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.database.DatesDataBase;
import com.example.geneticscalculator.data.database.dao.DatesProfilesDao;
import com.example.geneticscalculator.data.database.entity.DatesEntity;

import java.util.List;

public class DatesDataSource {

    private final DatesDataBase db;
    private final DatesProfilesDao dao;

    public DatesDataSource(Context context) {
        db = DatesDataBase.getDatabase(context);
        dao = db.DatesProfilesDao();
    }

    public LiveData<List<DatesEntity>> getDatesList() {
        return dao.getDatesList();
    }

    public LiveData<DatesEntity> getDatesItem(int id) {
        return dao.getItem(id);
    }

    public void addDates() {
        db.getQueryExecutor().execute(() -> dao.insert(new DatesEntity()));
    }

    public void deleteDates(int id) {
        db.getQueryExecutor().execute(() -> dao.delete(id));
    }

    public void updateDates(
            int id,
            String datesType,
            String datesInfo,
            String datesText
    ) {
        db.getQueryExecutor().execute(() ->
                dao.update(id, datesType, datesInfo, datesText)
        );
    }
}
