package com.example.suv12.customlistview;

import android.graphics.drawable.Drawable;

/**
 * Created by suv12 on 2017-12-31.
 */

public class ListViewItem {

    private Drawable icon;
    private String title;
    private String desc;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
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
}
