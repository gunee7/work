package com.example.customlistview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   private EditText edit_name ;
   private EditText edit_number;
   private EditText edit_department;

   private Button btn_add;
   private Spinner spinner;
   private EditText edit_itme;

   private Button btn_search;
   private TextView textView;
   private RadioButton radioButton;
   private RadioButton radioButton2;
   private Button btn_sort;

   private Button btn_del;
   private Button btn_all_del;
   private Button btn_init;
   private ListView list_view;

   private String[] items = {"이름", "학번", "학과"};

   private String[] itemsName = {"aaa 0","aaa 1","aaa 2","aaa 3","aaa 4"};
   private String[] itemsDepartnumber = {"00-00","11-11","22-22","33-33","44-44"};
   private String[] itemsDepartment = {"bbb 0","bbb 1","bbb 2","bbb 3","bbb 4"};


   private Intent Intent;
    private View adapterLV;
    private List<String> list;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         edit_name       = findViewById(R.id.edit_name      );
         edit_number     = findViewById(R.id.edit_number    );
         edit_department = findViewById(R.id.edit_department);
         btn_add         = findViewById(R.id.btn_add        );

         spinner         = findViewById(R.id.spinner        );
         edit_itme       = findViewById(R.id.edit_itme      );
         btn_search      = findViewById(R.id.btn_search     );

         textView        = findViewById(R.id.textView       );

         radioButton     = findViewById(R.id.radioButton    );
         radioButton2    = findViewById(R.id.radioButton2   );
         btn_sort        = findViewById(R.id.btn_sort       );

         btn_del         = findViewById(R.id.btn_del        );
         btn_all_del     = findViewById(R.id.btn_all_del    );
         btn_init        = findViewById(R.id.btn_init       );

         list_view       = findViewById(R.id.list_view      );



         //  위젯 찾기

        // 위젯 찾기
        listView  = findViewById(R.id.list_view);

        //위젯 리스너 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });


        data = new ArrayList<>();
        data.add("aaaaaa");
        data.add("bbbbbb");
        data.add("cccccc");

        //adapter 만들기
        adapter = new ArrayAdapter<String>( MainActivity.this, android.R.layout.simple_list_item_1, data);


        // listview
        listView.setAdapter(adapter);






        // adapter 생성
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, items);

        // spinner와 adapter 연결
        spinner.setAdapter(adapterSpinner);

        //spinner 리스너 설정
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // position : 현재 선택된 배열의 방번호.
                String selecteditem = items[position];

                edit_itme.setText(selecteditem);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        ArrayAdapter<String> spinner = new ArrayAdapter<String>(MainActivity.this
                ,android.R.layout.simple_list_item_1
                ,itemsName);

        // 3. 위젯 설정정
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // 1. edtName에서 값 가져오기
                String str  = edit_itme.getText().toString();

                // 2. txtMsg 에 값을 설정하기.
                textView.setText(str);
                Toast.makeText(getApplicationContext(),"검색하신 곳으로 넘어갑니다", Toast.LENGTH_SHORT).show();



            }
        });









        btn_all_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = edit_itme.getText().toString();
                String a = null;
                a = "  ";
                String rrr = r + a;
                edit_itme.setText(a);
            }
        });



        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = edit_itme.getText().toString();
                r = r.substring(0,r.length()-1);
                edit_itme.setText(r);
            }
        });



        btn_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = edit_itme.getText().toString();
                String na = edit_name.getText().toString();
                String nu = edit_number.getText().toString();
                String de = edit_department.getText().toString();

                String rr = r + na + nu + de;
                String a = null;
                String b = null;
                String c = null;
                String d = null;

                a = "  ";
                na = "  ";
                nu = "  ";
                de = "  ";

                edit_name.setText(na);
                edit_number.setText(nu);
                edit_department.setText(de);
                edit_itme.setText(a);

            }
        });


    }
}









