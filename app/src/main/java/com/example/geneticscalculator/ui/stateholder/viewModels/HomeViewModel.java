package com.example.geneticscalculator.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import android.app.Application;

import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.models.PlaceholderPost;
import com.example.geneticscalculator.data.repositories.RelativesRepository;
import com.example.geneticscalculator.data.models.PlaceholderPost;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
