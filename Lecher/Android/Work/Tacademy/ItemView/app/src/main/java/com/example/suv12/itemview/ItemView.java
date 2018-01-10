package com.example.suv12.itemview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by suv12 on 2018-01-06.
 */

public class ItemView extends FrameLayout {
    public ItemView(@NonNull Context context) {
        super(context);
        init();
    }

    public ItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    ImageView iconView;
    TextView nameView, descView, likeView;

    public void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_layout, this);
        iconView = findViewById(R.id.image_icon);
        nameView = findViewById(R.id.text_name);
        descView = findViewById(R.id.text_desc);
        likeView = findViewById(R.id.text_like);

        likeView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onLikeClick(ItemView.this, mData);
                }
            }
        });
    }

    ItemData mData;
    public void setItemData(ItemData data) {
        mData = data;
        iconView.setImageResource(data.imageId);
        nameView.setText(data.name);
        descView.setText(data.desc);
        likeView.setText("like: " + data.likeCount);
    }

    public interface OnLikeClickListener {
        public void onLikeClick(View view, ItemData data);
    }

    OnLikeClickListener mListener;

    public void setOnLikeClickListener(OnLikeClickListener listener) {
        mListener = listener;
    }
}
