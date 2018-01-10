package com.example.suv12.chattingitemview2;

import android.graphics.drawable.Drawable;

/**
 * Created by suv12 on 2018-01-07.
 */

public class ReceiveData implements ChattingData {

    private Drawable photo;
    private String message;

    public ReceiveData() {
    }

    public ReceiveData(Drawable photo, String message) {
        this.photo = photo;
        this.message = message;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ReceiveData{" +
                "photo=" + photo +
                ", message='" + message + '\'' +
                '}';
    }
}
