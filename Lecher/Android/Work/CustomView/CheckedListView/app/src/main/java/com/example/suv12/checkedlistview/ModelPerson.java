package com.example.suv12.checkedlistview;

import android.graphics.drawable.Drawable;

/**
 * Created by suv12 on 2018-01-08.
 */

public class ModelPerson {

    private int      position    = 0;
    private Drawable photo = null;
    private String   name   = "";
    private String   age    = "";
    private boolean  check = false;

    public ModelPerson() {
    }

    public ModelPerson(int position, Drawable photo, String name, String age, boolean check) {
        this.position = position;
        this.photo = photo;
        this.name = name;
        this.age = age;
        this.check = check;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "ModelPerson{" +
                "position=" + position +
                ", photo=" + photo +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", check=" + check +
                '}';
    }
}
