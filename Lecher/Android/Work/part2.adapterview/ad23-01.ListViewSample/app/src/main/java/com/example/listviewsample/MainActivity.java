package com.example.listviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TextView textv1;
    private EditText editText;
    private Button btn1;
    private ListView listv1;
    private String[] items = {"1", "2", "3", "4", "5"};
    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] itemsLV = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textv1 = findViewById(R.id.textv1);
        editText = findViewById(R.id.editText);
        btn1 = findViewById(R.id.btn1);
        listv1 = findViewById(R.id.listv1);

        // adapter 생성
        ArrayAdapter<String> adapterTextView = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items);


        // spinner와 adapter 연결
        listv1.setAdapter(adapterTextView);

        //listv1 리스너 설정
        listv1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // position : 현재 선택된 배열의 방번호.

                String selecteditem = items[position];
                textv1.setText(selecteditem);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // adapter 생성
        ArrayAdapter<String> adapterTextView1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items);


        // 3. 위젯 설정정
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 1. edtName에서 값 가져오기
                String str = editText.getText().toString();

                // 2. txtMsg 에 값을 설정하기.
                textv1.setText(str);

            }
        });


        /*
        AutoCompleteTextView 와 adapter연동.
        1.데이터 만들기
        2.adapter생성
        3.AutoCompleteTextView와 adapter연결
        4.리스너 설정: AutoCompleteTextView에는 필요없음.
         */


        ArrayAdapter<String> adapterMonth = new ArrayAdapter<String>(MainActivity.this
                , android.R.layout.simple_list_item_1
                , months);
        listv1.setAdapter(adapterMonth);
        listv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // position : 현재 선택된 배열의 방번호.
                String selecteditem = ((TextView)view).getText().toString();
                textv1.setText(selecteditem);
            }
        });



 /*
        ListView 와 ArrayAdapter연동.
        1.데이터 만들기
        2.adapter생성
        3.AutoCompleteTextView와 adapter연결
        4.리스너 설정: AutoCompleteTextView에는 필요없음.
         */



        ArrayAdapter<String> adapterLV = new ArrayAdapter<String>(MainActivity.this
                ,android.R.layout.simple_list_item_1
                ,itemsLV);
        listv1.setAdapter( adapterLV);
        listv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // position : 현재 선택된 배열의 방번호.
                String selecteditem = ((TextView)view).getText().toString();
                textv1.setText(selecteditem);

            }
        });


    }
}
