package com.android.calulator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;

    private Button buttonNanugi;
    private Button buttonKopagi;
    private Button buttonMinus;
    private Button buttonPlus;

    private Button buttonAc;
    private Button buttonC;
    private Button buttonEquals;
    private Button buttonComma;

    private Button buttonSave;
    private Button buttonPinalist;
    private Button buttonSaveList;

    private EditText editText;

    private String result = "";
    private String tmp = "";
    private String t = "";

    private Calc c = new Calc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonNanugi = findViewById(R.id.buttonNanugi);
        buttonKopagi = findViewById(R.id.buttonKopagi);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonAc = findViewById(R.id.buttonAc);
        buttonC = findViewById(R.id.buttonC);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonComma = findViewById(R.id.buttonComma);
        buttonSave = findViewById(R.id.buttonSave);
        buttonPinalist = findViewById(R.id.buttonPinalist);
        buttonSaveList = findViewById(R.id.buttonSaveList);

        ButtonInner bi = new ButtonInner();

        button0.setOnClickListener(bi);
        button1.setOnClickListener(bi);
        button2.setOnClickListener(bi);
        button3.setOnClickListener(bi);
        button4.setOnClickListener(bi);
        button5.setOnClickListener(bi);
        button6.setOnClickListener(bi);
        button7.setOnClickListener(bi);
        button8.setOnClickListener(bi);
        button9.setOnClickListener(bi);
        buttonNanugi.setOnClickListener(bi);
        buttonKopagi.setOnClickListener(bi);
        buttonMinus.setOnClickListener(bi);
        buttonPlus.setOnClickListener(bi);
        buttonAc.setOnClickListener(bi);
        buttonC.setOnClickListener(bi);
        buttonEquals.setOnClickListener(bi);
        buttonComma.setOnClickListener(bi);
        buttonSave.setOnClickListener(bi);
        buttonPinalist.setOnClickListener(bi);
        buttonSaveList.setOnClickListener(bi);

        editText = findViewById(R.id.editText);
    }

    private class ButtonInner implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button0:
                    ButtonForm("0","00");
                break;

                case R.id.button1:
                    ButtonForm("1","01");
                    break;

                case R.id.button2:
                    ButtonForm("2","02");
                    break;

                case R.id.button3:
                    ButtonForm("3","03");
                    break;

                case R.id.button4:
                    ButtonForm("4","04");
                    break;

                case R.id.button5:
                    ButtonForm("5","05");
                    break;

                case R.id.button6:
                    ButtonForm("6","06");
                    break;

                case R.id.button7:
                    ButtonForm("7","07");
                    break;

                case R.id.button8:
                    ButtonForm("8","08");
                    break;

                case R.id.button9:
                    ButtonForm("9","09");
                    break;

                case R.id.buttonNanugi:
                    t = result.substring(ChkCal() + 1, result.length());
                    if (t.length() == 0 || t.contains("÷") || t.contains("×") || t.contains("-") || t.contains("+")) {
                        break;
                    }
                    result = editText.getText().toString() + "÷";
                    editText.setText(result);
                    break;

                case R.id.buttonKopagi:
                    t = result.substring(ChkCal() + 1, result.length());
                    if (t.length() == 0 || t.contains("÷") || t.contains("×") || t.contains("-") || t.contains("+")) {
                        break;
                    }
                    result = editText.getText().toString() + "×";
                    editText.setText(result);
                    break;

                case R.id.buttonMinus:
                    t = result.substring(ChkCal() + 1, result.length());
                    if (t.length() == 0 || t.contains("÷") || t.contains("×") || t.contains("-") || t.contains("+")) {
                        break;
                    }
                    result = editText.getText().toString() + "-";
                    editText.setText(result);
                    break;

                case R.id.buttonPlus:
                    t = result.substring(ChkCal() + 1, result.length());
                    if (t.length() == 0 || t.contains("÷") || t.contains("×") || t.contains("-") || t.contains("+")) {
                        break;
                    }
                    result = editText.getText().toString() + "+";
                    editText.setText(result);
                    break;

                case R.id.buttonComma:

                    t = result.substring(ChkCal() + 1, result.length());

                    if (t.length() == 0 || t.contains(".")) {
                        break;
                    }

//                    if ((result.length()==0)||(result.contains("."))){
//                        break;
//                    }

                    result = editText.getText().toString() + ".";
                    editText.setText(result);
                    break;

                case R.id.buttonAc:
                    editText.setText("");
                    break;

                case R.id.buttonC:
                    break;

                case R.id.buttonEquals:
                    if (!(result.contains("×") || result.contains("÷") || result.contains("+") || result.contains("-"))) {
                        break;
                    }
                    if (String.valueOf(result.charAt(result.length() - 1)).equals("×") || String.valueOf(result.charAt(result.length() - 1)).equals("÷") ||
                            String.valueOf(result.charAt(result.length() - 1)).equals("+") || String.valueOf(result.charAt(result.length() - 1)).equals("-")) {
                        break;
                    }
                    if (!c.bracketsBalance(result)) {
                        break;
                    }
                    tmp = result.replace('×', '*');
                    tmp = tmp.replace('÷', '/');

                    // 중위 표기법을 후위 표기법으로 바꾸기
                    String postfixExp = c.postfix(tmp);

                    // 후위 표기법을 이용하여 수식 계산
                    Double cal_data = c.result(postfixExp);
                    editText.setText(result + " = " + cal_data);
                    break;

                case R.id.buttonSave:
                    break;

                case R.id.buttonPinalist:
                    break;

                case R.id.buttonSaveList:
                    break;
            }
        }
    }

    private int ChkCal() {
        int temp = 0;

        if (temp < result.lastIndexOf('+')) {
            temp = result.lastIndexOf('+');
        }
        if (temp < result.lastIndexOf('-')) {
            temp = result.lastIndexOf('-');
        }
        if (temp < result.lastIndexOf('÷')) {
            temp = result.lastIndexOf('÷');
        }
        if (temp < result.lastIndexOf('×')) {
            temp = result.lastIndexOf('×');
        }

        return temp;
    }

    private void ButtonForm(String x, String y) {
        t = result.substring(ChkCal() + 1, result.length());
        if ((t.length()==2)&&(t.equals(y))) {
            editText.setText(result.substring(ChkCal()+1,result.length()-1));
            return;
        }
        t = result.substring(ChkCal() + 1, result.length());
        result = editText.getText().toString() + x;
        editText.setText(result);
    }
}
