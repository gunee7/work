package com.example.st1drawermenu.Fragment.Tab5;

import android.graphics.drawable.Drawable;

public class Tab5_Model_Card {

    private Drawable imageCoffee5;
    private String   textCoffee5 ;

    /*-----------------------------------------*/
    /*getter & setter*/

    public Drawable getImageCoffee() {
        return imageCoffee5;
    }

    public void setImageCoffee(Drawable imageCoffee) {
        this.imageCoffee5 = imageCoffee;
    }

    public String getTextCoffee() {
        return textCoffee5;
    }

    public void setTextCoffee(String textCoffee) {
        this.textCoffee5 = textCoffee;
    }

    /*-----------------------------------------*/
    /*toString*/

    @Override
    public String toString() {
        return "Tab5_Model_Card{" +
                "imageCoffee5=" + imageCoffee5 +
                ", textCoffee5='" + textCoffee5 + '\'' +
                '}';
    }

    /*-----------------------------------------*/
    /*constructor*/

    public Tab5_Model_Card() {
    }

    public Tab5_Model_Card(Drawable imageCoffee, String textCoffee) {
        this.imageCoffee5 = imageCoffee;
        this.textCoffee5 = textCoffee;
    }

}
