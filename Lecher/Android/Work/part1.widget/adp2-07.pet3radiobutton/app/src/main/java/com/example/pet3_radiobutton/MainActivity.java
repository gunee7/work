package com.example.pet3_radiobutton;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.pet3_radiobutton.R;

public class MainActivity extends Activity implements
        RadioGroup.OnCheckedChangeListener {
    /** Called when the activity is first created. */

    LinearLayout ll;
    private Drawable dog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.linearLayout1);

        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg1.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup arg0, int arg1) {
        // TODO Auto-generated method stub

        switch (arg1) {

            case R.id.radio0:

                ll.setBackgroundColor(Color.WHITE);

                break;

            case R.id.radio1:

                ll.setBackgroundColor(Color.RED);

                break;

            case R.id.radio2:

                ll.setBackgroundColor(Color.BLUE);

                break;

        }
    }
}



