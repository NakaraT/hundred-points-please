package com.example.geneticscalculator.data.repositories;

import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.geneticscalculator.data.API.RetrofitFactory;
import com.example.geneticscalculator.data.API.TypeCodeAPI;
import com.example.geneticscalculator.data.database.entity.DatesEntity;
import com.example.geneticscalculator.data.datasource.DatesDataSource;
import com.example.geneticscalculator.data.models.PlaceholderPost;
import com.example.geneticscalculator.data.protocols.DatesProtocol;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DatesRepository implements DatesProtocol {

    private final DatesDataSource dataSource;

    public DatesRepository(Context context) {
        dataSource = new DatesDataSource(context);
    }

    @Override
    public LiveData<List<DatesEntity>> getDatesList() {
        return dataSource.getDatesList();
    }

    @Override
    public LiveData<DatesEntity> getDatesItem(int id) {
        return dataSource.getDatesItem(id);
    }

    @Override
    public void addDates() {
        dataSource.addDates();
    }

    @Override
    public void deleteDates(int id) {
        dataSource.deleteDates(id);
    }

    @Override
    public void updateDates(
            int id,
            String datesType,
            String datesInfo,
            String datesText
    ) {
        dataSource.updateDates(id, datesType, datesInfo, datesText);
    }


    @Override
    public LiveData<PlaceholderPost> getPost() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<PlaceholderPost> call = typeCodeAPI.getPost();
        MutableLiveData<PlaceholderPost> postLD = new MutableLiveData<>();
        call.enqueue(new Callback<PlaceholderPost>() {
            @Override
            public void onResponse(Call<PlaceholderPost> call, Response<PlaceholderPost> response) {
                if (response.isSuccessful()){
                    PlaceholderPost post = response.body();
                    postLD.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<PlaceholderPost> call, Throwable t) {

            }
        });
        return postLD;
    }

    @Override
    public LiveData<PlaceholderPost> pushPost() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<PlaceholderPost> call = typeCodeAPI.pushPost(new PlaceholderPost(1, 1, "delectus aut autem", "false"));
        MutableLiveData<PlaceholderPost> pushLD = new MutableLiveData<>();
        call.enqueue(new Callback<PlaceholderPost>() {
            @Override
            public void onResponse(Call<PlaceholderPost> call, Response<PlaceholderPost> response) {
                if (response.isSuccessful()){
                    PlaceholderPost post = response.body();
                    pushLD.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<PlaceholderPost> call, Throwable t) {

            }
        });
        return pushLD;
    }

    @Override
    public LiveData<List<PlaceholderPost>> getAllPosts() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<List<PlaceholderPost>> call = typeCodeAPI.getAllPosts();
        MutableLiveData<List<PlaceholderPost>> getLD = new MutableLiveData<>();
        call.enqueue(new Callback<List<PlaceholderPost>>() {
            @Override
            public void onResponse(Call<List<PlaceholderPost>> call, Response<List<PlaceholderPost>> response) {
                if (response.isSuccessful()) {
                    List<PlaceholderPost> post = response.body();
                    getLD.setValue(post);
                }
            }

            @Override
            public void onFailure(Call<List<PlaceholderPost>> call, Throwable t) {

            }
        });
        return getLD;
    }
}
