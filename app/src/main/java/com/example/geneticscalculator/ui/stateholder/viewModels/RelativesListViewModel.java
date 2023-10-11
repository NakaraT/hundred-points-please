package com.example.geneticscalculator.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.repositories.RelativesRepository;

import java.util.List;

public class RelativesListViewModel extends AndroidViewModel {

    private final RelativesRepository repository = new RelativesRepository(getApplication());
    public LiveData<List<RelativesEntity>> listLiveData = repository.getRelativesList();

    public RelativesListViewModel(@NonNull Application application) {

        super(application);
    }

    public void addRelative() {
        repository.addRelative();
    }
}
