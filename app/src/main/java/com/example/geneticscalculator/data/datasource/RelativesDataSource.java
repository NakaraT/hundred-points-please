package com.example.geneticscalculator.data.datasource;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.geneticscalculator.data.database.RelativesDataBase;
import com.example.geneticscalculator.data.database.dao.RelativesProfilesDao;
import com.example.geneticscalculator.data.database.entity.Mapper;
import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.models.RelativesListItem;

import java.util.ArrayList;
import java.util.List;


public class RelativesDataSource {
    private final Context context;
    List<RelativesEntity> relatives = new ArrayList<>();
    public RelativesDataSource(Context context){
        this.context = context;
    }

    public LiveData<List<RelativesEntity>> getRelativesList() {
        relatives.add(new RelativesEntity(
                "Папа",
                "Зелёный",
                "Брюнет",
                "Светлый",
                "III"
        ));
        relatives.add(new RelativesEntity(
                "Мама",
                "Карий",
                "Рыжий",
                "Загорелый",
                "II"
        ));
        relatives.add(new RelativesEntity(
                "Бабушка(П.Л.)",
                "Голубой",
                "Брюнет",
                "Светлый",
                "III"
        ));
        relatives.add(new RelativesEntity(
                "Дедушка(П.Л.)",
                "Зелёный",
                "Шатен",
                "Светлый",
                "IV"
        ));
        relatives.add(new RelativesEntity(
                "Бабушка(М.Л.)",
                "Карий",
                "Рыжий",
                "Светлый",
                "II"
        ));
        relatives.add(new RelativesEntity(
                "Дедушка(М.Л.)",
                "Голубой",
                "Русый",
                "Светлый",
                "III"

        ));
        MutableLiveData<List<RelativesEntity>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(relatives);

//        RelativesDataBase db = RelativesDataBase.getDatabase(context);
//        RelativesProfilesDao RelativesDao = db.RelativesProfilesDao();
//        Mapper mapper = new Mapper();
//        db.getQueryExecutor().execute(() -> {
//            for (RelativesEntity relatives : relatives) {
//                RelativesDao.insert(relatives);
//            }
//        });
//        List<RelativesEntity> listLiveData = RelativesDao.getRelativesList().getValue();
//        MutableLiveData<List<RelativesEntity>> mutableLiveData = new MutableLiveData<>();
//        if (listLiveData != null) {
//            List<RelativesListItem> listLD = mapper.mapRelativesToRelativesListItem(listLiveData);
//            mutableLiveData.setValue(relatives);
//        }
        return mutableLiveData;
    }

    public LiveData<RelativesEntity> getRelativesItem(int position) {
        getRelativesList();
        MutableLiveData<RelativesEntity> data = new MutableLiveData<>();
        data.setValue(relatives.get(position));
        return data;
    }
}
