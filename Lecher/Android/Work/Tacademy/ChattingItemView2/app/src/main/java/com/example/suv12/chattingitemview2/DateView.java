package com.example.suv12.chattingitemview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by suv12 on 2018-01-07.
 */

public class DateView extends LinearLayout {

    TextView txt_date;

    public DateView(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.date_layout, this);
        txt_date = findViewById(R.id.txt_date);
    }

    DateData data;

    public void setData(DateData data) {
        this.data = data;
        txt_date.setText(data.getMessage());
    }
}
