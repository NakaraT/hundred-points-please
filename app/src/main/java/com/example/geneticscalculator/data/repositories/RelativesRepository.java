package com.example.geneticscalculator.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.protocols.RelativesProtocol;
import com.example.geneticscalculator.data.datasource.RelativesDataSource;
import com.example.geneticscalculator.data.models.RelativesListItem;
import java.util.List;

public class RelativesRepository implements  RelativesProtocol {
    private final RelativesDataSource dataSource = new RelativesDataSource();

    @Override
    public LiveData<List<RelativesListItem>> getRelativesList() {
        return dataSource.getRelativesList();
    }

    @Override
    public LiveData<RelativesListItem> getRelativesItem(int position) {
        return dataSource.getRelativesItem(position);
    }

}
