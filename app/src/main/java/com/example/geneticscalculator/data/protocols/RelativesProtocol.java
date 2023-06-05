package com.example.geneticscalculator.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.database.entity.RelativesEntity;
import com.example.geneticscalculator.data.models.PlaceholderPost;

import java.util.List;

public interface RelativesProtocol {
    LiveData<List<RelativesEntity>> getRelativesList();
    LiveData<RelativesEntity> getRelativesItem(int position);
    LiveData<PlaceholderPost> getPost();
    LiveData<PlaceholderPost> pushPost();
    LiveData<List<PlaceholderPost>> getAllPosts();
    void addRelative();
    void deleteRelative(int id);
    void updateRelative(
            int id,
            String relativesType,
            String eyeColor,
            String hairColor,
            String dateofBirth,
            String bloodType
    );
}

