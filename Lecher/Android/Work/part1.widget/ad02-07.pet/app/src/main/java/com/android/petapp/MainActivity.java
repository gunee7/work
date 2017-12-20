package com.android.petapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.android.pet.R;


public class MainActivity extends AppCompatActivity {

    private ScrollView scrollView = null;

    private LinearLayout linerarlayoutA = null;
    private TextView textView1 = null;
    private CheckBox checkbox1 = null;
    private TextView textView2 = null;
    private RadioGroup petRadio = null;
    private RadioButton radioDog = null;
    private RadioButton radioCat = null;
    private RadioButton radioRabbit = null;
    private Button btnPet = null;
    private ImageView imageViewDog = null;
    private ImageView imageViewCat = null;
    private ImageView imageViewRabbit = null;

    private LinearLayout linerarlayoutB = null;
    private Switch toggleAnd = null;

    private TextView textView3 = null;
    private RadioButton andRadio = null;
    private RadioButton andjel = null;
    private RadioButton andkit = null;
    private RadioButton andLolli = null;
    private Button btnAnd = null;
    private Button imgAnd = null;






        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b == true){
                linerarlayoutA.setVisibility(View.VISIBLE);
            }
            else if(b == false) {
                linerarlayoutA.setVisibility(View.GONE);
            }
        }
    });





        toggleAnd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b == true){
                linerarlayoutA.setVisibility(View.VISIBLE);
            }
            else if(b == false) {
                linerarlayoutA.setVisibility(View.GONE);
            }
        }
    });

        btnAnd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int ra = andRadio.getCheckedRadioButtonId();

            if(ra == R.id.andMash){
                imgAnd.setImageResource(R.drawable.marshmallow);
            }

            else if (ra == R.id.andNou){
                imgAnd.setImageResource(R.drawable.nougat);
            }
            else if (ra == R.id.andLolli){
                imgAnd.setImageResource(R.drawable.lollipop);
            }
        }
    });


    }
}