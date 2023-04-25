package com.example.geneticscalculator.data.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "relatives_profiles_table")
public class RelativesEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public String relativesType;
    public String eyeColor;
    public String hairColor;
    public String skinColor;
    public String bloodType;

    public RelativesEntity(String relativesType, String eyeColor,
                           String hairColor, String skinColor,
                           String bloodType) {
        this.relativesType = relativesType;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.bloodType = bloodType;
    }

    public  String getRelativesType() {
        return relativesType;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getBloodType() {
        return bloodType;
    }
}

