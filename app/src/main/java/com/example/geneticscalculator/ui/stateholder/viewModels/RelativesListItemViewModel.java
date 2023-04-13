package com.example.geneticscalculator.ui.stateholder.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.geneticscalculator.data.models.RelativesListItem;
import com.example.geneticscalculator.data.repositories.RelativesRepository;

public class RelativesListItemViewModel extends ViewModel {
    private RelativesRepository repository = new RelativesRepository();
    public LiveData<RelativesListItem> relativesListItemLiveData;

    public void getRelativesListItemLiveData(int position) {
        relativesListItemLiveData = repository.getRelativesItem(position);
    }
}
