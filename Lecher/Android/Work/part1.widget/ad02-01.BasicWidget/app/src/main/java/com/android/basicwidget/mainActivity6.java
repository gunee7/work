package com.android.basicwidget;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class mainActivity6 extends AppCompatActivity {

    private TextView mTextMessage;

    private Button btngivebean;
    private Button btnfriend;
    private Button btnchat;
    private Button btnmygive;
    private Button btnview;

    LinearLayout ll;

    private LinearLayout linearlayout = null;

    private LinearLayout linearlayout1 = null;
    private TextView     textView      = null;
    private CheckBox checkBox      = null;

    private LinearLayout linearlayout2 = null;
    private RadioGroup radiogroup    = null;
    private TextView     textView2     = null;
    private RadioButton radioDog   = null;
    private RadioButton  radioCat  = null;
    private RadioButton  radioHorse  = null;
    private Button       button        = null;

    private LinearLayout linearlayout3 = null;
    private ImageView imageView = null;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_givebean:
                    Intent i = new Intent(getApplicationContext(), Menu1Activity.class);
                    startActivity(i);

                    return true;

                case R.id.navigation_friend:
                    i = new Intent(getApplicationContext(), Menu2Activity.class);
                    startActivity(i);


                    return true;

                case R.id.navigation_chatting:
                    i = new Intent(getApplicationContext(), Menu3Activity.class);
                    startActivity(i);

                    return true;

                case R.id.navigation_mygive:
                    i = new Intent(getApplicationContext(), Menu4Activity.class);
                    startActivity(i);

                    return true;

                case R.id.navigation_more:
                    i = new Intent(getApplicationContext(), Menu5Activity.class);
                    startActivity(i);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        btngivebean = findViewById(R.id.btngivebean);
        btnfriend = findViewById(R.id.btnfriend);
        btnchat = findViewById(R.id.btnchat);
        btnmygive = findViewById(R.id.btnmygive);
        btnview = findViewById(R.id.btnview);


        textView      = findViewById(R.id.textView     );
        checkBox      = findViewById(R.id.checkBox     );

        linearlayout1 = findViewById(R.id.linearlayout1);
        radiogroup    = findViewById(R.id.radiogroup   );
        textView2     = findViewById(R.id.textView2    );

        linearlayout2 = findViewById(R.id.linearlayout2);
        radioDog  = findViewById(R.id.radioDog  );
        radioCat  = findViewById(R.id.radioCat );
        radioHorse  = findViewById(R.id.radioHorse );
        button        = findViewById(R.id.button);


        imageView = findViewById(R.id.imageView);
        checkBox = findViewById(R.id.checkBox);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);





        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    radiogroup.setVisibility(View.VISIBLE);

                } else {
                    radiogroup.setVisibility(View.INVISIBLE);
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radiogroup.getCheckedRadioButtonId()) {
                    case R.id.radioDog:
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageResource(R.drawable.dog);
                        break;
                    case R.id.radioCat:
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageResource(R.drawable.cat);

                        break;
                    case R.id.radioHorse:
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageResource(R.drawable.horse);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 선택해주세요", Toast.LENGTH_SHORT).show();

                }
            }
        });



        btngivebean.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "친구를 찾아보세요", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), MainActivity1.class);
            startActivity(i); //새창 띄우기

        }
    });


        btnfriend.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "친구를 찾아보세요", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(i); //새창 띄우기


        }
    });


        btnchat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "채팅을 시작합니다", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), MainActivity3.class);
            startActivity(i); //새창 띄우기

        }
    });


        btnmygive.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "나의 기부", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), MainActivity4.class);
            startActivity(i); //새창 띄우기

        }
    });


        btnview.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "더많은 메뉴로 넘어갑니다", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), MainActivity5.class);
            startActivity(i); //새창 띄우기

        }
    });

    }
}
