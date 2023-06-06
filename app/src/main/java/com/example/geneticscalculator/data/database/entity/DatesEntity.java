package com.example.geneticscalculator.data.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "dates_profiles_table")
public class DatesEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int getId() {
        return id;
    }

    public String getDatesType() { return datesType; }

    public String getDatesInfo() {
        return datesInfo;
    }

    public String getDay() { return day; }

    public String getMouthNumber() { return mouthNumber; }

    public String getYear() { return year; }

    public String getDatesText() {
        return datesText;
    }

    public String datesType = "";
    public String datesInfo = "";
    public String datesText = "Окончание:";
    public String day = "";
    public String mouthNumber = "";
    public String year = "";

}

