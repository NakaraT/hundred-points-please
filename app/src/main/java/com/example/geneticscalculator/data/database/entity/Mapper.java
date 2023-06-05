package com.example.geneticscalculator.data.database.entity;

import com.example.geneticscalculator.data.models.RelativesListItem;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static RelativesListItem mapRelativesListItemToRelatives(RelativesEntity relatives) {
        RelativesListItem relativesListItem = new RelativesListItem(
                relatives.relativesType,
                relatives.eyeColor,
                relatives.hairColor,
                relatives.dateofBirth,
                relatives.bloodType
        );
        return relativesListItem;
    }

    public static List<RelativesListItem> mapRelativesToRelativesListItem(List<RelativesEntity> relativesList) {
        List<RelativesListItem> relativesListItemList = new ArrayList<>();
        for (RelativesEntity relatives : relativesList) {
            RelativesListItem relativesListItem = mapRelativesListItemToRelatives(relatives);
            relativesListItemList.add(relativesListItem);
        }
        return relativesListItemList;
    }
}

