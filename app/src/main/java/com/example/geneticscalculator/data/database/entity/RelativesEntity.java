package com.example.geneticscalculator.data.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "relatives_profiles_table")
public class RelativesEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int getId() {
        return id;
    }

    public String getRelativesType() {
        return relativesType;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String relativesType = "";
    public String eyeColor = "";
    public String hairColor = "";
    public String dateofBirth = "";
    public String bloodType = "";
}

