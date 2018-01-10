package com.example.pet2;

import android.graphics.Color;
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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{


    LinearLayout ll;

    private LinearLayout linearlayout = null;

    private LinearLayout linearlayout1 = null;
    private TextView     textView      = null;
    private CheckBox     checkBox      = null;

    private LinearLayout linearlayout2 = null;
    private RadioGroup   radiogroup    = null;
    private TextView     textView2     = null;
    private RadioButton  radioDog   = null;
    private RadioButton  radioCat  = null;
    private RadioButton  radioHorse  = null;
    private Button       button        = null;

    private LinearLayout linearlayout3 = null;
    private ImageView  imageView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

    }
}





