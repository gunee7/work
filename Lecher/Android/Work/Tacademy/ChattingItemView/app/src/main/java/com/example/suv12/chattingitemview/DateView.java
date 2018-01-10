package com.example.suv12.chattingitemview;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by suv12 on 2018-01-07.
 */

public class DateView extends FrameLayout {
    public DateView(Context context) {
        super(context);
        init();
    }

    TextView messageView;

    private void init() {
        inflate(getContext(), R.layout.view_date_layout, this);
        messageView = (TextView) findViewById(R.id.text_message);
    }

    DateData data;

    public void setData(DateData data) {
        this.data = data;
        messageView.setText(data.getMessage());
    }
}
