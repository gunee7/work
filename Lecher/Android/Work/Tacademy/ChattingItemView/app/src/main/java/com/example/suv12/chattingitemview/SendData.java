package com.example.suv12.chattingitemview;

import android.graphics.drawable.Drawable;

/**
 * Created by suv12 on 2018-01-07.
 */

public class SendData implements ChattingData {
    private String message;
    private Drawable photo;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }
}
