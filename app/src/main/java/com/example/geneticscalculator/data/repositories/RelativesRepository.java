package com.example.geneticscalculator.data.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.protocols.RelativesProtocol;
import com.example.geneticscalculator.data.datasource.RelativesDataSource;
import com.example.geneticscalculator.data.models.RelativesListItem;
import java.util.List;

public class RelativesRepository implements  RelativesProtocol {
    private final RelativesDataSource dataSource;
    private final Context context;

    public RelativesRepository(Context context) {
        this.context = context;
        dataSource = new RelativesDataSource(context);
    }


    @Override
    public LiveData<List<RelativesEntity>> getRelativesList() {
        return dataSource.getRelativesList();
    }

    @Override
    public LiveData<RelativesEntity> getRelativesItem(int position) {
        return dataSource.getRelativesItem(position);
    }

}
