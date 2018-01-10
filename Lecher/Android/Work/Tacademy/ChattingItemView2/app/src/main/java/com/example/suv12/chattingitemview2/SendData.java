package com.example.suv12.chattingitemview2;

import android.graphics.drawable.Drawable;

/**
 * Created by suv12 on 2018-01-07.
 */

public class SendData implements ChattingData {

    private Drawable photo;
    private String message;

    public SendData() {
    }

    public SendData(Drawable photo, String message) {
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
        return "SendData{" +
                "photo=" + photo +
                ", message='" + message + '\'' +
                '}';
    }
}
