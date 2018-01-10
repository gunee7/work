package com.example.suv12.studentcustomlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2018-01-03.
 */

public class CheckableLayout extends RelativeLayout implements Checkable {
    CheckBox checkBox;

    public CheckableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setChecked(boolean checked) {
        checkBox = findViewById(R.id.checkBox);

        if (checkBox.isChecked() != checked) {
            checkBox.setChecked(checked);
        }
    }

    @Override
    public boolean isChecked() {
        checkBox = findViewById(R.id.checkBox);
        return checkBox.isChecked();
    }

    @Override
    public void toggle() {
        checkBox = findViewById(R.id.checkBox);

        setChecked(checkBox.isChecked() ? false : true);
    }
}
