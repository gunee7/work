package com.example.st1drawermenu.SubuMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.st1drawermenu.R;

public class SubMenuActivity extends AppCompatActivity {

    private int[] images = {
            R.drawable.espresso,
            R.drawable.espressoconpania,
            R.drawable.hotcoffeehtml,
            R.drawable.icecoffeehtml,
            R.drawable.hotcafelatte,
            R.drawable.icecafelatte,
            R.drawable.hotbanilalatte,
            R.drawable.icebanilalatte,
            R.drawable.hotcapuchino,
            R.drawable.icecapuchino,
            R.drawable.hotcafemocha,
            R.drawable.icecafemocha,
            R.drawable.hotwhitechocomacha,
            R.drawable.icewhitechocomacha,
            R.drawable.hotcaramelmachato,
            R.drawable.icecaramelmachato
    };

    private ImageView coffeeImage = null;
    private TextView  coffeeNameText  = null;
    private TextView  coffeepayText  = null;
    private TextView  coffeepaySizwupText  = null;
    private Button    btn_miuns     = null;
    private Button    btn_plus       = null;
    private EditText  count_number   = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);

        Intent i = getIntent();
        int position = i.getIntExtra("position", -1);

        coffeeImage = findViewById(R.id.menu_image);
        coffeeNameText = findViewById(R.id.coffee_text);
        coffeepayText = findViewById(R.id.coffeepayText);
        coffeepaySizwupText = findViewById(R.id.coffeepaySizwupText);
        btn_miuns    = findViewById( R.id.btn_minus);
        btn_plus     = findViewById( R.id.btn_plus);
        count_number = findViewById( R.id.count_number);

        // 커피 이름 데이터
        String[] coffeeName = getResources().getStringArray(R.array.menu_title);
        String[] coffeepay = getResources().getStringArray(R.array.menupay_title);
        String[] coffeepaySizwup = getResources().getStringArray(R.array.menupay_sizeup);

        coffeeImage.setImageDrawable( getResources().getDrawable( images[position]) );
        coffeeNameText.setText( coffeeName[position]);
        coffeepayText.setText( coffeepay[position]);
        coffeepaySizwupText.setText( coffeepaySizwup[position]);

        Buttonclick bclick = new Buttonclick();
    }

    private class Buttonclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String count = count_number.getText().toString();
            int numbercount = Integer.valueOf(count);

            switch (v.getId()){
                case R.id.btn_minus:

                    if (numbercount == 0){
                        Toast.makeText(getApplicationContext(),"0은 안됩니다.",Toast.LENGTH_SHORT).show();
                        break;
                    }else {
                    numbercount = numbercount - 1 ;
                    count_number.setText( numbercount + "" );
                    break;
                    }
                case R.id.btn_plus:



                    break;
            }
        }
    }
}
