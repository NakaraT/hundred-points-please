package com.example.geneticscalculator.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.models.RelativesListItem;

import java.util.List;

public interface RelativesProtocol {
    LiveData<List<RelativesEntity>> getRelativesList();
    LiveData<RelativesEntity> getRelativesItem(int position);
}

