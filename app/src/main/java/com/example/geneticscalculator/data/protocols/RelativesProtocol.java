package com.example.geneticscalculator.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.models.RelativesListItem;

import java.util.List;

public interface RelativesProtocol {
    LiveData<List<RelativesListItem>> getRelativesList();
    LiveData<RelativesListItem> getRelativesItem(int position);
}

