package com.android.gridcalculator;

import android.content.SyncStatusObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText = null;


    private Button buttonSaveList = null;
    private Button buttonSave = null;
    private Button buttonPinalist = null;

    private Button button1 = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button buttonMinus = null;

    private Button button4 = null;
    private Button button5 = null;
    private Button button6 = null;
    private Button buttonKopagi = null;

    private Button button7 = null;
    private Button button8 = null;
    private Button button9 = null;
    private Button buttonNanugi = null;

    private Button buttonComma = null;
    private Button button0 = null;
    private Button buttonPlusminus = null;
    private Button buttonPlus = null;

    private Button buttonAc = null;
    private Button buttonC = null;
    private Button buttonEquals = null;
    private Button buttonGualho = null;

    Calc c = new Calc();

    String recent = "";

    String rt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rt = String.valueOf(editText.getText());

        buttonSaveList = findViewById(R.id.buttonSaveList);
        editText = findViewById(R.id.editText);

        buttonSaveList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String rr = r + "저장목록";
                editText.setText(rr);
            }
        });


        buttonSave = findViewById(R.id.buttonSave);
        editText = findViewById(R.id.editText);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String rr = r + "저장";
                editText.setText(rr);
            }
        });


        buttonPinalist = findViewById(R.id.buttonPinalist);
        editText = findViewById(R.id.editText);

        buttonPinalist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(recent);
            }
        });


        button1 = findViewById(R.id.button1);
        editText = findViewById(R.id.editText);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rt = (editText.getText().toString()+"1");
                editText.setText(rt);
            }
        });


        button2 = findViewById(R.id.button2);
        editText = findViewById(R.id.editText);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a2 = null;
                String b2 = null;
                a2 = "2";
                b2 = "2";
                String rrr = r + b2;
                editText.setText(r + b2);


            }
        });


        button3 = findViewById(R.id.button3);
        editText = findViewById(R.id.editText);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a3 = null;
                a3 = "3";
                String b3 = null;
                b3 = "3";
                String rrr = r + b3;
                editText.setText(r + b3);
            }
        });


        buttonMinus = findViewById(R.id.buttonMinus);
        editText = findViewById(R.id.editText);

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a = "-";
                a = "-";
                String rrr = r + a;
                editText.setText(r + a);
            }
        });


        button4 = findViewById(R.id.button4);
        editText = findViewById(R.id.editText);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a4 = null;
                a4 = "4";
                String b4 = null;
                b4 = "4";
                String rrr = r + b4;
                editText.setText(r + b4);
            }
        });


        button5 = findViewById(R.id.button5);
        editText = findViewById(R.id.editText);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a5 = null;
                a5 = "5";
                String b5 = null;
                b5 = "5";
                String rrr = r + b5;
                editText.setText(r + b5);
            }
        });


        button6 = findViewById(R.id.button6);
        editText = findViewById(R.id.editText);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a6 = null;
                a6 = "6";
                String b6 = null;
                b6 = "6";
                String rrr = r + b6;
                editText.setText(r + b6);
            }
        });


        buttonKopagi = findViewById(R.id.buttonKopagi);
        editText = findViewById(R.id.editText);

        buttonKopagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a = "*";
                a = "x";
                String rrr = r + a;
                editText.setText(r + a);
            }
        });


        button7 = findViewById(R.id.button7);
        editText = findViewById(R.id.editText);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a7 = null;
                a7 = "7";
                String b7 = null;
                b7 = "7";
                String rrr = r + b7;
                editText.setText(r + b7);
            }
        });


        button8 = findViewById(R.id.button8);
        editText = findViewById(R.id.editText);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a8 = null;
                a8 = "8";
                String b8 = null;
                b8 = "8";
                String rrr = r + b8;
                editText.setText(r + b8);
            }
        });


        button9 = findViewById(R.id.button9);
        editText = findViewById(R.id.editText);

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a9 = null;
                a9 = "9";
                String b9 = null;
                b9 = "9";
                String rrr = r + b9;
                editText.setText(r + b9);
            }
        });


        buttonNanugi = findViewById(R.id.buttonNanugi);
        editText = findViewById(R.id.editText);

        buttonNanugi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a = "/";
                a = "÷";
                String rrr = r + a;
                editText.setText(r + a);
            }
        });


        buttonComma = findViewById(R.id.buttonComma);
        editText = findViewById(R.id.editText);

        buttonComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a = ".";
                a = ".";
                String rrr = r + a;
                editText.setText(r + a);
            }
        });


        button0 = findViewById(R.id.button0);
        editText = findViewById(R.id.editText);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a0 = null;
                a0 = "0";
                String b0 = null;
                b0 = "0";
                String rrr = r + b0;
                editText.setText(r + b0);
            }
        });


        buttonPlusminus = findViewById(R.id.buttonPlusminus);
        editText = findViewById(R.id.editText);

        buttonPlusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a = "+/-";
                a = "+/-";
                String rrr = r + a;
                editText.setText(r + a);
            }
        });


        buttonPlus = findViewById(R.id.buttonPlus);
        editText = findViewById(R.id.editText);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a = "+";
                a = "+";
                String rrr = r + a;
                editText.setText(r + a);
            }
        });


        buttonAc = findViewById(R.id.buttonAc);
        editText = findViewById(R.id.editText);

        buttonAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String a = null;
                a = "  ";
                String rrr = r + a;
                editText.setText(a);
            }
        });


        buttonC = findViewById(R.id.buttonC);
        editText = findViewById(R.id.editText);

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                r = r.substring(0,r.length()-1);
                editText.setText(r);
            }
        });


        buttonEquals = findViewById(R.id.buttonEquals);
        editText = findViewById(R.id.editText);

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();

                recent = r;

                if (!c.bracketsBalance(r)) {
                    System.exit(1);
                }

                // 중위 표기법을 후위 표기법으로 바꾸기
                String postfixExp = c.postfix(r);

                // 후위 표기법을 이용하여 수식 계산
                Double result = c.result(postfixExp);

                recent = recent + "=" + String.valueOf(result);

                editText.setText(String.valueOf(result));

            }
        });


        buttonGualho = findViewById(R.id.buttonGualho);
        editText = findViewById(R.id.editText);

        buttonGualho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = editText.getText().toString();
                String rr = r + "(  )";
                editText.setText(rr);
            }
        });


        ButtonInner bi = new ButtonInner();
        button0.setOnClickListener(bi);

    }

    private class ButtonInner implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button0:
                    break;

                case R.id.button1:
                    break;
            }
        }

    }
}

