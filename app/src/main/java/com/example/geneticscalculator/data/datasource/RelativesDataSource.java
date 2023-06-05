package com.example.geneticscalculator.data.datasource;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.database.RelativesDataBase;
import com.example.geneticscalculator.data.database.dao.RelativesProfilesDao;
import com.example.geneticscalculator.data.database.entity.RelativesEntity;

import java.util.List;

public class RelativesDataSource {

    private final RelativesDataBase db;
    private final RelativesProfilesDao dao;

    public RelativesDataSource(Context context) {
        db = RelativesDataBase.getDatabase(context);
        dao = db.RelativesProfilesDao();
    }

    public LiveData<List<RelativesEntity>> getRelativesList() {
        return dao.getRelativesList();
    }

    public LiveData<RelativesEntity> getRelativesItem(int id) {
        return dao.getItem(id);
    }

    public void addRelative() {
        db.getQueryExecutor().execute(() -> dao.insert(new RelativesEntity()));
    }

    public void deleteRelative(int id) {
        db.getQueryExecutor().execute(() -> dao.delete(id));
    }

    public void updateRelative(
            int id,
            String relativesType,
            String eyeColor,
            String hairColor,
            String dateofBirth,
            String bloodType
    ) {
        db.getQueryExecutor().execute(() ->
                dao.update(id, relativesType, eyeColor, hairColor, dateofBirth, bloodType)
        );
    }
}
