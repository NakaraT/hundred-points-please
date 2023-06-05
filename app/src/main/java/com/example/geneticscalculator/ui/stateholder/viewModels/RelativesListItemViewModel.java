package com.example.geneticscalculator.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.repositories.RelativesRepository;

public class RelativesListItemViewModel extends AndroidViewModel {

    private final RelativesRepository repository = new RelativesRepository(getApplication());
    public LiveData<RelativesEntity> relativesListItemLiveData;

    public RelativesListItemViewModel(@NonNull Application application) {
        super(application);
    }

    public void getRelativesItem(int id) {
        relativesListItemLiveData = repository.getRelativesItem(id);
    }

    public void deleteRelative(int id) {
        repository.deleteRelative(id);
    }

    public void updateRelative(
            int id,
            String relativesType,
            String eyeColor,
            String hairColor,
            String dateofBirth,
            String bloodType
    ) {
        repository.updateRelative(id, relativesType, eyeColor, hairColor, dateofBirth, bloodType);
    }
}
