package com.example.geneticscalculator.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.repositories.RelativesRepository;

public class RelativesListItemViewModel extends AndroidViewModel {
    private RelativesRepository repository = new RelativesRepository(getApplication());
    public LiveData<RelativesEntity> relativesListItemLiveData;

    public RelativesListItemViewModel(@NonNull Application application) {
        super(application);
    }

    public void getRelativesListItemLiveData(int position) {
        relativesListItemLiveData = repository.getRelativesItem(position);
    }
}
