package com.example.suv12.chattingitemview2;

/**
 * Created by suv12 on 2018-01-07.
 */

public class DateData implements ChattingData {

    private String message;

    public DateData() {
    }

    public DateData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DateData{" +
                "message='" + message + '\'' +
                '}';
    }
}
