package com.example.geneticscalculator.ui.stateholder.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.geneticscalculator.data.models.RelativesListItem;
import com.example.geneticscalculator.data.repositories.RelativesRepository;

import java.util.List;

public class RelativesListViewModel extends ViewModel {

    private final RelativesRepository repository = new RelativesRepository();
    public LiveData<List<RelativesListItem>> listLiveData = repository.getRelativesList();

}
