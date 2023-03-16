package com.example.geneticscalculator;

public class ListItem {
    private int resource;
    private String RelativeTitle;

    public ListItem(int resource, String RelativeTitle) {
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
