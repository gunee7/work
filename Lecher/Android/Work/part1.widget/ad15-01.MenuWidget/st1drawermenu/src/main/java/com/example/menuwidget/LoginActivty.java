package com.example.menuwidget;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent; //직접 타이핑

public class LoginActivty extends AppCompatActivity {

    private Button btnlogin;
    private EditText edtId;
    private EditText edtPw;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = findViewById(R.id.btnLogin);

        edtId = findViewById(R.id.edtID);
        edtPw = findViewById(R.id.edtPW);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtId.getText().toString().trim().equals("111") && edtPw.getText().toString().trim().equals("111")) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("ID", edtId.getText().toString());
                    //editor.putString("PASSWORD", edtPw.getText().toString());
                    editor.putBoolean("LOGIN_STATUS", true);
                    editor.apply(); //저장

                    //결과 반환 코드 작성
                    Intent data = new Intent();

                    //Intent에 반환 값 저장
                    data.putExtra("LOGIN_STATUS", true);
                    //결과 반환.
                    setResult(RESULT_OK, data);

                    //실행되고 있는 activity
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),R.string.login_fail, Toast.LENGTH_SHORT).show();
                }

            }
        });

        pref = getSharedPreferences("settings", MODE_PRIVATE);

        String id = pref.getString("ID", "");
        String pw = pref.getString("PASSWORD", "");

        edtId.setText(id);
        edtPw.setText(pw);
    }
}


