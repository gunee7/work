package com.example.simplemultitype;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    //listview.item1.xml 의 데이터
    private int type;

    private String title ;
    private String desc ;

    //listview_item2.xml 의 데이터
    private Drawable image;
    private String name;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ListViewItem{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", image=" + image +
                ", name='" + name + '\'' +
                '}';
    }

    public ListViewItem(int type, String title, String desc, Drawable image, String name) {
        this.type = type;
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.name = name;
    }

    public ListViewItem() {
    }
}