package com.example.geneticscalculator.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.geneticscalculator.data.database.entity.DatesEntity;
import com.example.geneticscalculator.data.models.PlaceholderPost;

import java.util.List;

public interface DatesProtocol {
    LiveData<List<DatesEntity>> getDatesList();
    LiveData<DatesEntity> getDatesItem(int position);
    LiveData<PlaceholderPost> getPost();
    LiveData<PlaceholderPost> pushPost();
    LiveData<List<PlaceholderPost>> getAllPosts();
    void addDates();
    void deleteDates(int id);
    void updateDates(
            int id,
            String datesType,
            String datesInfo,
            String datesText
    );
}
