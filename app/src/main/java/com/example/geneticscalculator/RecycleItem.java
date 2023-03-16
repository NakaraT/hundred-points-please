package com.example.geneticscalculator;


public class RecycleItem {
    private int resource;
    private String RelativeTitle;

    public RecycleItem(int resource, String RelativeTitle) {
        this.resource = resource;
        this.RelativeTitle = RelativeTitle;
    }

    public int getResource() {
        return resource;
    }

    public String getRelativeTitle() {
        return RelativeTitle;
    }
}