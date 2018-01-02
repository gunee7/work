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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textv1 = findViewById(R.id.textv1);
        editText = findViewById(R.id.editText);
        btn1 = findViewById(R.id.btn1);
        listv1 = findViewById(R.id.listv1);

        // adapter 생성
        ArrayAdapter<String> adapterTextView = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, (List<String>) textv1);




        // spinner와 adapter 연결
        listv1.setAdapter(adapterTextView);

        //listv1 리스너 설정
        listv1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // position : 현재 선택된 배열의 방번호.
                String [] arrays = getResources().getStringArray(R.array.items);
                mADAPTER
                textv1.setText();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
