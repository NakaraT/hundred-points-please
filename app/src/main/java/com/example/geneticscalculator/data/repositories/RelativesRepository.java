package com.example.geneticscalculator.data.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.geneticscalculator.data.API.RetrofitFactory;
import com.example.geneticscalculator.data.API.TypeCodeAPI;
import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.models.PlaceholderPost;
import com.example.geneticscalculator.data.protocols.RelativesProtocol;
import com.example.geneticscalculator.data.datasource.RelativesDataSource;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.Retrofit;

public class RelativesRepository implements RelativesProtocol {

    private final RelativesDataSource dataSource;

    public RelativesRepository(Context context) {
        dataSource = new RelativesDataSource(context);
    }

    @Override
    public LiveData<List<RelativesEntity>> getRelativesList() {
        return dataSource.getRelativesList();
    }

    @Override
    public LiveData<RelativesEntity> getRelativesItem(int id) {
        return dataSource.getRelativesItem(id);
    }

    @Override
    public void addRelative() {
        dataSource.addRelative();
    }

    @Override
    public void deleteRelative(int id) {
        dataSource.deleteRelative(id);
    }

    @Override
    public void updateRelative(
            int id,
            String relativesType,
            String eyeColor,
            String hairColor,
            String dateofBirth,
            String bloodType
    ) {
        dataSource.updateRelative(id, relativesType, eyeColor, hairColor, dateofBirth, bloodType);
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
                if (response.isSuccessful()){
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
