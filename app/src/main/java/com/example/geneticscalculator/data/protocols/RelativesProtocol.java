package com.example.geneticscalculator.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.models.PlaceholderPost;
import com.example.geneticscalculator.data.models.RelativesListItem;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RelativesProtocol {
    LiveData<List<RelativesEntity>> getRelativesList();
    LiveData<RelativesEntity> getRelativesItem(int position);
    LiveData<PlaceholderPost> getPost();
    LiveData<PlaceholderPost> pushPost();
    LiveData<List<PlaceholderPost>> getAllPosts();
}

