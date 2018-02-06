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
import com.example.st1drawermenu.Tab2MenuButton;

public class SubMenuActivity extends AppCompatActivity {

    private int[] coffee_images    = Tab2MenuButton.caffee_icon;
    private int[] latte_iamges     = Tab2MenuButton.lattee_icon;
    private int[] beverage_images  = Tab2MenuButton.beverage_icon;
    private int[] tea_iamges       = Tab2MenuButton.tea_icon;
    private int[] sidemenu_images  = Tab2MenuButton.sidemenu_icon;

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
        int menuname = i.getIntExtra("name", -1);

        coffeeImage         = findViewById(R.id.menu_image);
        coffeeNameText      = findViewById(R.id.coffee_text);
        coffeepayText       = findViewById(R.id.coffeepayText);
        coffeepaySizwupText = findViewById(R.id.coffeepaySizwupText);
        btn_miuns           = findViewById( R.id.btn_minus);
        btn_plus            = findViewById( R.id.btn_plus);
        count_number        = findViewById( R.id.count_number);

        if (menuname == R.id.btn_menu2){
            String[] latteName      = getResources().getStringArray(R.array.menu_latte_name);
            String[] lattepay       = getResources().getStringArray(R.array.menupay_latte);
            String[] latteSizwup    = getResources().getStringArray(R.array.menupay_latte_sizeup);

            coffeeImage        .setImageDrawable( getResources().getDrawable( latte_iamges[position]) );
            coffeeNameText     .setText( latteName  [position]);
            coffeepayText      .setText( lattepay   [position]);
            coffeepaySizwupText.setText( latteSizwup[position]);
        }
        else if (menuname == R.id.btn_menu3){
            String[] beverageName      = getResources().getStringArray(R.array.menu_beverage_name);
            String[] beveragepay       = getResources().getStringArray(R.array.menupay_beverage);
            String[] beverageSizwup    = getResources().getStringArray(R.array.menupay_beverage_sizeup);

            coffeeImage        .setImageDrawable( getResources().getDrawable( beverage_images[position]) );
            coffeeNameText     .setText( beverageName  [position]);
            coffeepayText      .setText( beveragepay   [position]);
            coffeepaySizwupText.setText( beverageSizwup[position]);
        }
        else if (menuname == R.id.btn_menu4){
            String[] teaName      = getResources().getStringArray(R.array.menu_tea_name);
            String[] teapay       = getResources().getStringArray(R.array.menupay_tea);
            String[] teaSizwup    = getResources().getStringArray(R.array.menupay_tea_sizeup);

            coffeeImage        .setImageDrawable( getResources().getDrawable( tea_iamges[position]) );
            coffeeNameText     .setText( teaName  [position]);
            coffeepayText      .setText( teapay   [position]);
            coffeepaySizwupText.setText( teaSizwup[position]);
        }
        else if (menuname == R.id.btn_menu5){
            String[] sidemenuName      = getResources().getStringArray(R.array.menu_sidemenu_name);
            String[] sidemenupay       = getResources().getStringArray(R.array.menupay_sidemenu);
            String[] sidemenuSizwup    = getResources().getStringArray(R.array.menupay_sidemenu_sizeup);

            coffeeImage        .setImageDrawable( getResources().getDrawable( sidemenu_images[position]) );
            coffeeNameText     .setText( sidemenuName  [position]);
            coffeepayText      .setText( sidemenupay   [position]);
            coffeepaySizwupText.setText( sidemenuSizwup[position]);
        }
        else{
            // 커피 이름 데이터
            String[] coffeeName      = getResources().getStringArray(R.array.menu_coffee_name);
            String[] coffeepay       = getResources().getStringArray(R.array.menupay_coffee);
            String[] coffeepaySizwup = getResources().getStringArray(R.array.menupay_coffee_sizeup);

            coffeeImage        .setImageDrawable( getResources().getDrawable( coffee_images[position]) );
            coffeeNameText     .setText( coffeeName[position]);
            coffeepayText      .setText( coffeepay[position]);
            coffeepaySizwupText.setText( coffeepaySizwup[position]);
        }

    }


}
