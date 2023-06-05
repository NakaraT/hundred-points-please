package com.example.geneticscalculator.data.models;

public class RelativesListItem {
    private static String relativesType;
    private static String eyeColor;
    private static String hairColor;
    private static String dateofBirth;
    private static String bloodType;

    public RelativesListItem(String relativesType, String eyeColor,
                             String hairColor, String dateofBirth,
                             String bloodType){
        this.relativesType = relativesType;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.dateofBirth = dateofBirth;
        this.bloodType = bloodType;

    }

    public static String getRelativesType() {
        return relativesType;
    }

    public static String getEyeColor() {
        return eyeColor;
    }

    public static String getHairColor() {
        return hairColor;
    }

    public static String getDateofBirth() {
        return dateofBirth;
    }

    public static String getBloodType() {
        return bloodType;
    }
}