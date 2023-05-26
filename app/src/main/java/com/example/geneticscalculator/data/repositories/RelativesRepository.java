package com.example.geneticscalculator.data.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.API.RetrofitFactory;
import com.example.geneticscalculator.data.API.TypeCodeAPI;
import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.models.PlaceholderPost;
import com.example.geneticscalculator.data.protocols.RelativesProtocol;
import com.example.geneticscalculator.data.datasource.RelativesDataSource;
import com.example.geneticscalculator.data.models.RelativesListItem;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class RelativesRepository implements  RelativesProtocol {
    private final RelativesDataSource dataSource;
    private final Context context;

    public RelativesRepository(Context context) {
        this.context = context;
        dataSource = new RelativesDataSource(context);
    }


    @Override
    public LiveData<List<RelativesEntity>> getRelativesList() {
        return dataSource.getRelativesList();
    }

    @Override
    public LiveData<RelativesEntity> getRelativesItem(int position) {
        return dataSource.getRelativesItem(position);
    }
    @Override
    public Call<PlaceholderPost> getPost() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<PlaceholderPost> call = typeCodeAPI.getPost();
        return call;
    }

    @Override
    public Call<PlaceholderPost> pushPost(PlaceholderPost post) {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<PlaceholderPost> call = typeCodeAPI.pushPost(post);
        return call;
    }

    @Override
    public Call<List<PlaceholderPost>> getAllPosts() {
        Retrofit retrofit = RetrofitFactory.getRetrofit();
        TypeCodeAPI typeCodeAPI = retrofit.create(TypeCodeAPI.class);
        Call<List<PlaceholderPost>> call = typeCodeAPI.getAllPosts();
        return call;
    }
}
