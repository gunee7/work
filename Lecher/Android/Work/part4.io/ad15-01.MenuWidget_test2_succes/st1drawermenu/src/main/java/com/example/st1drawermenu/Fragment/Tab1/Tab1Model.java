package com.example.st1drawermenu.Fragment.Tab1;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Tab1Model {

    private String name;
    private String number;
    private String department;
    private Drawable image_menu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Drawable getImage_menu() {
        return image_menu;
    }

    public void setImage_menu(Drawable image_menu) {
        this.image_menu = image_menu;
    }

    @Override
    public String toString() {
        return "Tab1Model{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", department='" + department + '\'' +
                ", image_menu=" + image_menu +
                '}';
    }

    public Tab1Model() {
    }

    public Tab1Model(String name, String number, String department, Drawable image_menu) {
        this.name = name;
        this.number = number;
        this.department = department;
        this.image_menu = image_menu;

    }
}
