package com.example.st1drawermenu.Fragment.Tab1;

import android.graphics.drawable.Drawable;

public class Tab1_Model_Card {

    private Drawable tab1_main_image1;
    private String   tab1_main_text1 ;
    /*-----------------------------------------*/
    /*getter & setter*/

    public Drawable getTab1_main_image1() {
        return tab1_main_image1;
    }

    public void setTab1_main_image1(Drawable tab1_main_image1) {
        this.tab1_main_image1 = tab1_main_image1;
    }

    public String getTab1_main_text1() {
        return tab1_main_text1;
    }

    public void setTab1_main_text1(String tab1_main_text1) {
        this.tab1_main_text1 = tab1_main_text1;
    }
/*-----------------------------------------*/
    /*toString*/

    @Override
    public String toString() {
        return "Tab1_Model_Card{" +
                "tab1_main_image1=" + tab1_main_image1 +
                ", tab1_main_text1='" + tab1_main_text1 + '\'' +
                '}';
    }

    /*-----------------------------------------*/
    /*constructor*/

    public Tab1_Model_Card() {
    }

    public Tab1_Model_Card(Drawable tab1_main_image1, String tab1_main_text1) {
        this.tab1_main_image1 = tab1_main_image1;
        this.tab1_main_text1 = tab1_main_text1;
    }

}
