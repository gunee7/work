package com.example.suv12.chattingitemview;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by suv12 on 2018-01-07.
 */

public class SendView extends FrameLayout {
    public SendView(Context context) {
        super(context);
        init();
    }

    TextView messageView;
    ImageView photoView;

    private void init() {
        inflate(getContext(), R.layout.view_send_layout, this);
        messageView = (TextView) findViewById(R.id.text_message);
        photoView = (ImageView) findViewById(R.id.image_photo);
    }

    SendData data;

    public void setData(SendData data) {
        this.data = data;
        messageView.setText(data.getMessage());
        photoView.setImageDrawable(data.getPhoto());
    }
}
