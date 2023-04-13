package com.example.geneticscalculator.data.datasource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.geneticscalculator.data.models.RelativesListItem;

import java.util.ArrayList;
import java.util.List;


public class RelativesDataSource {
    List<RelativesListItem> relatives = new ArrayList<>();

    public LiveData<List<RelativesListItem>> getRelativesList() {
        relatives.add(new RelativesListItem(
                "Папа",
                "Зелёный",
                "Брюнет",
                "Светлый",
                "III"
        ));
        relatives.add(new RelativesListItem(
                "Мама",
                "Карий",
                "Рыжий",
                "Загорелый",
                "II"
        ));
        relatives.add(new RelativesListItem(
                "Бабушка(П.Л.)",
                "Голубой",
                "Брюнет",
                "Светлый",
                "III"
        ));
        relatives.add(new RelativesListItem(
                "Дедушка(П.Л.)",
                "Зелёный",
                "Шатен",
                "Светлый",
                "IV"
        ));
        relatives.add(new RelativesListItem(
                "Бабушка(М.Л.)",
                "Карий",
                "Рыжий",
                "Светлый",
                "II"
        ));
        relatives.add(new RelativesListItem(
                "Дедушка(М.Л.)",
                "Голубой",
                "Русый",
                "Светлый",
                "III"

        ));
        MutableLiveData<List<RelativesListItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(relatives);
        return mutableLiveData;
    }

    public LiveData<RelativesListItem> getRelativesItem(int position) {
        getRelativesList();
        MutableLiveData<RelativesListItem> data = new MutableLiveData<>();
        data.setValue(relatives.get(position));
        return data;
    }
}
