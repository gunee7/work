package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //위젯 선언
    private ListView listView1;
    private AdapterStudent   adapter;
    private List<ModelStudent> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        listView1  = findViewById(R.id.list_view);



        //데이터 만들기
        data = new ArrayList<>();
        for (int i=0; i<5; i++) {
            ModelStudent student = new ModelStudent();
            student.setName("name" + i);
            student.setNumber("number" + i);
            student.setDepartment(i+"-" + i);
            data.add(student);

        }
         

        //adapter 만들기
        adapter = new AdapterStudent( MainActivity.this, R.layout.view_student,data);

        // listview
        listView1.setAdapter(adapter);





    }
}