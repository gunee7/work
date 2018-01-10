package com.example.suv12.baseadapter;


/**
 * Created by suv12 on 2018-01-01.
 */

public class MyData {

    private int imageResource;
    private String title;
    private String description;

    public MyData(int imageResource, String title, String description) {
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
