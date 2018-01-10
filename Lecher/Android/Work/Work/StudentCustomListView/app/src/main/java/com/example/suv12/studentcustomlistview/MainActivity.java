package com.example.suv12.studentcustomlistview;

import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ListView listV;
    private StudentAdapter adapter;
    private ArrayList<ModelStudent> studentData;

    private Spinner spinner;
    private ArrayAdapter spinner_Adapter;

    private Button btn_Add, btn_Search, btn_Sort, btn_Del, btn_AllDel, btn_Init;
    private EditText edt_Name, edt_Num, edt_Dept, edt_Item;
    private RadioButton radio_Asce, radio_Desc;

    private ArrayList<ModelStudent> studentData_search;
    private StudentAdapter adapter_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Add = findViewById(R.id.btn_Add);
        btn_Search = findViewById(R.id.btn_Search);
        btn_Sort = findViewById(R.id.btn_Sort);
        btn_Del = findViewById(R.id.btn_Del);
        btn_AllDel = findViewById(R.id.btn_AllDel);
        btn_Init = findViewById(R.id.btn_Init);

        edt_Name = findViewById(R.id.edt_Name);
        edt_Num = findViewById(R.id.edt_Num);
        edt_Dept = findViewById(R.id.edt_Dept);
        edt_Item = findViewById(R.id.edt_Item);

        radio_Asce = findViewById(R.id.radio_Asce);
        radio_Desc = findViewById(R.id.radio_Desc);

        // 스피너 추가 ( student_category.xml 추가 )
        spinner = findViewById(R.id.spinner);
        spinner_Adapter = ArrayAdapter.createFromResource(this, R.array.student_category, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinner_Adapter);

        // 리스트 뷰와 어댑터 연결
        studentData = new ArrayList<>();
        adapter = new StudentAdapter(this, R.layout.view_student, studentData);
        listV = findViewById(R.id.listV);
        listV.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        listV.setAdapter(adapter);

        // 서치
        studentData_search = new ArrayList<>();
        adapter_search = new StudentAdapter(this, R.layout.view_student, studentData_search);

        // 초기 데이터
        adapter.addItem("zzz1", "zzz333", "zzz4");
        adapter.addItem("xxx1", "xxx222", "xxx3");
        adapter.addItem("ccc1", "ccc555", "ccc1");
        adapter.addItem("xxx1", "xxx777", "xxx7");
        adapter.addItem("ccc2", "ccc555", "ccc1");
        adapter.addItem("zzz1", "zzz333", "zzz4");
        adapter.addItem("xxx1", "xxx222", "xxx3");
        adapter.addItem("ccc1", "ccc555", "ccc1");
        adapter.addItem("xxx1", "xxx777", "xxx7");
        adapter.addItem("ccc2", "ccc555", "ccc1");

//        // 머리 아이템 설정
//        // !!! 주의 머릿 / 꼬리 아이템은 반드시 리스트의 setAdapter 전체 추가되어야 한다.
//        View headerView = getLayoutInflater().inflate(R.layout.list_view_header, null);
//        TextView headerTv = (TextView) headerView.findViewById(R.id.header_footer_text);
//        headerTv.setText("리스트의 시작입니다.");
//        listV.addHeaderView(headerView, null, true);
//
//        // 2 - 5. 꼬리 아이템 설정
//        // !!! 주의 머릿 / 꼬리 아이템은 반드시 리스트의 setAdapter 전체 추가되어야 한다.
//        View footerView = getLayoutInflater().inflate(R.layout.list_view_header, null);
//        TextView footerTv = (TextView) footerView.findViewById(R.id.header_footer_text);
//        footerTv.setText("로딩 중...");
//        listV.addFooterView(footerView, null, false);

        // 리스트 아이템 구분선 설정
        listV.setDivider(new ColorDrawable(getResources().getColor(R.color.colorAccent)));
        listV.setDividerHeight(3);

        BtnClick btnClick = new BtnClick();
        btn_Add.setOnClickListener(btnClick);
        btn_Search.setOnClickListener(btnClick);
        btn_Sort.setOnClickListener(btnClick);
        btn_AllDel.setOnClickListener(btnClick);
        btn_Init.setOnClickListener(btnClick);
        btn_Del.setOnClickListener(btnClick);


    }

    private class BtnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_Add:

                    ModelStudent student = new ModelStudent();

                    if ((edt_Name.getText().toString().equals(""))) {
                        Toast.makeText(getApplicationContext(), "이름을 입력하세요", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    if ((edt_Num.getText().toString().equals(""))) {
                        Toast.makeText(getApplicationContext(), "학번을 입력하세요", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    if ((edt_Dept.getText().toString().equals(""))) {
                        Toast.makeText(getApplicationContext(), "학과를 입력하세요", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    student.setName(edt_Name.getText().toString());
                    student.setNumber(edt_Num.getText().toString());
                    student.setDepartment(edt_Dept.getText().toString());

                    adapter.add(student);

                    listV.smoothScrollToPosition(adapter.getCount());

                    break;

                case R.id.btn_Search:

                    // 0 : 이름
                    // 1 : 번호
                    // 2 : 학과
                    studentData_search.clear();
                    if (spinner.getSelectedItemPosition() == 0) {
                        for (int i = 0; i < studentData.size(); i++) {
                            if (studentData.get(i).getName().contains(edt_Item.getText().toString())) {
                                studentData_search.add(studentData.get(i));
                            }
                        }
                    }

                    if (spinner.getSelectedItemPosition() == 1) {
                        for (int i = 0; i < studentData.size(); i++) {
                            if (studentData.get(i).getNumber().contains(edt_Item.getText().toString())) {
                                studentData_search.add(studentData.get(i));
                            }
                        }
                    }

                    if (spinner.getSelectedItemPosition() == 2) {
                        for (int i = 0; i < studentData.size(); i++) {
                            if (studentData.get(i).getDepartment().contains(edt_Item.getText().toString())) {
                                studentData_search.add(studentData.get(i));
                            }
                        }
                    }

                    listV.setAdapter(adapter_search);

                    break;

                case R.id.btn_Sort:
                    int num = spinner.getSelectedItemPosition();
                    if (radio_Asce.isChecked()) {
                        sort(num);
                    } else if (radio_Desc.isChecked()) {
                        sort(num);
                    }

                    adapter.notifyDataSetChanged();

                    break;

                case R.id.btn_Del:

                    SparseBooleanArray count = listV.getCheckedItemPositions();

                    if (studentData_search.size() > 0) {
                        for (int i = studentData_search.size() - 1; i >= 0; i--) {
                            if (count.get(i)) {
                                for (int j = studentData.size() - 1; j >= 0; j--) {
                                    if (studentData_search.get(i).getUniquekey()==(studentData.get(j).getUniquekey())) {
                                        studentData.remove(j);
                                    }
                                }
                                studentData_search.remove(i);
                            }
                        }
                    } else {
                        for (int i = studentData.size() - 1; i >= 0; i--) {
                            if (count.get(i)) {
                                studentData.remove(i);
                            }
                        }
                    }


                    listV.clearChoices();
                    adapter.notifyDataSetChanged();
                    adapter_search.notifyDataSetChanged();

                    break;

                case R.id.btn_AllDel:

                    adapter.clear();
                    listV.setAdapter(adapter);
                    init();

                    break;

                case R.id.btn_Init:

                    init();
                    listV.setAdapter(adapter);

                    break;
            }
        }
    }

    private void sort(int num) {
        if (num == 0) {
            if (radio_Asce.isChecked()) {
                ModelStudent.NameCompare nameCompare = new ModelStudent.NameCompare();
                Collections.sort(studentData, nameCompare);
                System.out.println(studentData.toString());
            } else if (radio_Desc.isChecked()) {
                ModelStudent.NameCompare nameCompare = new ModelStudent.NameCompare(true);
                Collections.sort(studentData, nameCompare);
                System.out.println(studentData.toString());
            }
        }
        if (num == 1) {
            if (radio_Asce.isChecked()) {
                ModelStudent.DeptCompare deptCompare = new ModelStudent.DeptCompare();
                Collections.sort(studentData, deptCompare);
                System.out.println(studentData.toString());
            } else if (radio_Desc.isChecked()) {
                ModelStudent.DeptCompare deptCompare = new ModelStudent.DeptCompare(true);
                Collections.sort(studentData, deptCompare);
                System.out.println(studentData.toString());
            }
        }
        if (num == 2) {
            if (radio_Asce.isChecked()) {
                ModelStudent.NumberCompare numberCompare = new ModelStudent.NumberCompare();
                Collections.sort(studentData, numberCompare);
                System.out.println(studentData.toString());
            } else if (radio_Desc.isChecked()) {
                ModelStudent.NumberCompare numberCompare = new ModelStudent.NumberCompare(true);
                Collections.sort(studentData, numberCompare);
                System.out.println(studentData.toString());
            }
        }
    }

    public void init() {

        edt_Name.setText("");
        edt_Num.setText("");
        edt_Dept.setText("");
        edt_Item.setText("");

    }
}
