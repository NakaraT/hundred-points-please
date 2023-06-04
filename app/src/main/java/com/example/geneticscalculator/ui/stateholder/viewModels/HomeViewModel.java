package com.example.geneticscalculator.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.models.PlaceholderPost;
import com.example.geneticscalculator.data.repositories.RelativesRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    private final RelativesRepository repository = new RelativesRepository(getApplication());
    public LiveData<List<RelativesEntity>> listLiveData = repository.getRelativesList();

    public HomeViewModel(@NonNull Application application) {
        super(application);

    }
    public LiveData<PlaceholderPost> postLD = repository.getPost();
    public LiveData<PlaceholderPost> pushLD = repository.pushPost();
    public LiveData<List<PlaceholderPost>> getLD = repository.getAllPosts();
}