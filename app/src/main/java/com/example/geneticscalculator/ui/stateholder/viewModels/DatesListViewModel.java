package com.example.geneticscalculator.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.database.entity.DatesEntity;
import com.example.geneticscalculator.data.repositories.DatesRepository;

import java.util.List;

public class DatesListViewModel extends AndroidViewModel {

    private final DatesRepository repository = new DatesRepository(getApplication());
    public LiveData<List<DatesEntity>> listLiveData = repository.getDatesList();

    public DatesListViewModel(@NonNull Application application) {
        super(application);
    }

    public void addDates() {
        repository.addDates();
    }
}
