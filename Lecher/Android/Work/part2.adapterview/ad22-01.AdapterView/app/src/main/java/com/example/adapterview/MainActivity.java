package com.example.adapterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    //위젯 선언
    private TextView textview1;
    private Spinner spinner1;
    private AutoCompleteTextView autocomplete1;
    private ListView listview1; 
    private String[] items = {"1", "2", "3", "4", "5"};
    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] itemsLV = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        textview1 = findViewById(R.id.textview1);
        spinner1 = findViewById(R.id.spinner1);
        autocomplete1 = findViewById(R.id.autocomplete1);
        listview1 = findViewById(R.id.listview1);

        // adapter 생성
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, items);

        // spinner와 adapter 연결
        spinner1.setAdapter(adapterSpinner);

        //spinner 리스너 설정
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // position : 현재 선택된 배열의 방번호.
                String selecteditem = items[position];
                textview1.setText(selecteditem);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
        autocomplete1.setAdapter(adapterMonth);
        autocomplete1.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // position : 현재 선택된 배열의 방번호.
                String selecteditem = ((TextView)view).getText().toString();
                textview1.setText(selecteditem);
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
         listview1.setAdapter( adapterLV);
         listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 // position : 현재 선택된 배열의 방번호.
                 String selecteditem = ((TextView)view).getText().toString();
                 textview1.setText(selecteditem);

             }
         });




    }
}
