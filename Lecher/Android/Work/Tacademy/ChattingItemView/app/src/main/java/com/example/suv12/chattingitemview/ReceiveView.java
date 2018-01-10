package com.example.suv12.chattingitemview;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by suv12 on 2018-01-07.
 */

public class ReceiveView extends FrameLayout {
    public ReceiveView(Context context) {
        super(context);
        init();
    }

    TextView messageView;
    ImageView photoView;

    private void init() {
        inflate(getContext(), R.layout.view_receive_layout, this);
        messageView = (TextView) findViewById(R.id.text_message);
        photoView = (ImageView) findViewById(R.id.image_photo);
    }

    ReceiveData data;

    public void setData(ReceiveData data) {
        this.data = data;
        messageView.setText(data.getMessage());
        photoView.setImageDrawable(data.getPhoto());
    }
}
