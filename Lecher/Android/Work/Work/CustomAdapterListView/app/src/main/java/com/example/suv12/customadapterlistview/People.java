package com.example.suv12.customadapterlistview;

/**
 * Created by suv12 on 2018-01-02.
 *
 * People 객체
 */

public class People {

    private int imageResourceId;
    private String name;
    private String phoneNumber;

    public People(int imageResourceId, String name, String phoneNumber) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
