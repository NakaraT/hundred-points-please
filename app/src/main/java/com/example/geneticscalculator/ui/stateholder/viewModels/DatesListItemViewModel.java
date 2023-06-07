package com.example.geneticscalculator.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.database.entity.DatesEntity;
import com.example.geneticscalculator.data.repositories.DatesRepository;


public class DatesListItemViewModel extends AndroidViewModel {

    private final DatesRepository repository = new DatesRepository(getApplication());
    public LiveData<DatesEntity> datesListItemLiveData;

    public DatesListItemViewModel(@NonNull Application application) {
        super(application);
    }

    public void getDatesItem(int id) {
        datesListItemLiveData = repository.getDatesItem(id);
    }

    public void deleteDates(int id) {
        repository.deleteDates(id);
    }

    public void updateDates(
            int id,
            String datesType,
            String datesInfo,
            String datesText) {
        repository.updateDates(id, datesType, datesInfo, datesText);
    }
}
