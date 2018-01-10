package com.example.suv12.chattingitemview2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by suv12 on 2018-01-07.
 */

public class SendView extends RelativeLayout {

    ImageView img_photo;
    TextView txt_message;

    public SendView(@NonNull Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.send_layout, this);
        img_photo = findViewById(R.id.img_photo);
        txt_message = findViewById(R.id.txt_message);
    }

    SendData data;

    public void setData(SendData data) {
        this.data = data;
        img_photo.setImageDrawable(data.getPhoto());
        txt_message.setText(data.getMessage());
    }
}
