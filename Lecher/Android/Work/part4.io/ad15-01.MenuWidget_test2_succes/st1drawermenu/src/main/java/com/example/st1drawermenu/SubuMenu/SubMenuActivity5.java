package com.example.st1drawermenu.SubuMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.st1drawermenu.R;

public class SubMenuActivity5 extends AppCompatActivity {

    private int[] images5 = {
            R .drawable.latte1_hotchocolatte,
            R.drawable.latte2_icechocolatte,
            R.drawable.latte3_hotgreentealatte,
            R.drawable.latte4_icegreentealatte,
            R.drawable.latte5_hotmilktealatte,
            R.drawable.latte6_icemilktealatte,
            R.drawable.latte7_hotmintchocolatte,
            R.drawable.latte8_icemintchocolatte,
            R.drawable.latte9_hotogoklatte,
            R.drawable.latte10_iceogoklatte,
            R.drawable.latte11_hottopinutlatte,
            R.drawable.latte12_icetopinutlatte,
            R.drawable.latte13_hotwhitechocolatte,
            R.drawable.latte14_icewhitechocolatte,
    };

    private ImageView coffeeImage5 = null;
    private TextView  coffeeNameText5  = null;
    private TextView  coffeepayText5  = null;
    private TextView  coffeepaySizwupText5  = null;
    private Button    btn_minus5    = null;
    private Button    btn_plus5      = null;
    private EditText  count_number5   = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu5);

        Intent i = getIntent();
        int position = i.getIntExtra("position", -1);

        coffeeImage5 = findViewById(R.id.menu_image5);
        coffeeNameText5 = findViewById(R.id.coffee_text5);
        coffeepayText5 = findViewById(R.id.coffeepayText5);
        coffeepaySizwupText5 = findViewById(R.id.coffeepaySizwupText5);
        btn_minus5    = findViewById( R.id.btn_minus5);
        btn_plus5     = findViewById( R.id.btn_plus5);
        count_number5 = findViewById( R.id.count_number5);

        // 커피 이름 데이터
        String[] coffeeName = getResources().getStringArray(R.array.menu_latte_name);
        String[] coffeepay = getResources().getStringArray(R.array.menupay_latte);
        String[] coffeepaySizwup = getResources().getStringArray(R.array.menupay_latte_sizeup);

        coffeeImage5.setImageDrawable( getResources().getDrawable( images5[position]) );
        coffeeNameText5.setText( coffeeName[position]);
        coffeepayText5.setText( coffeepay[position]);
        coffeepaySizwupText5.setText( coffeepaySizwup[position]);

        Buttonclick bclick = new Buttonclick();
    }

    private class Buttonclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String count = count_number5.getText().toString();
            int numbercount = Integer.valueOf(count);

            switch (v.getId()){
                case R.id.btn_minus5:

                    if (numbercount == 0){
                        Toast.makeText(getApplicationContext(),"0은 안됩니다.",Toast.LENGTH_SHORT).show();
                        break;
                    }else {
                    numbercount = numbercount - 1 ;
                        count_number5.setText( numbercount + "" );
                    break;
                    }
                case R.id.btn_plus5:



                    break;
            }
        }
    }
}
