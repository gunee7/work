package com.example.st1drawermenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    private Button btnA1 = null;
    private Button btnB2 = null;
    private Button btnB3 = null;
    private Button btnB4 = null;
    private Button btnB5 = null;
    private Button btnB6 = null;
    private Button btnB7 = null;


    public Fragment1() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        btnA1 = view.findViewById(R.id.btnA1);
        btnB2 = view.findViewById(R.id.btnB2);
        btnB3 = view.findViewById(R.id.btnB3);
        btnB4 = view.findViewById(R.id.btnB4);
        btnB5 = view.findViewById(R.id.btnB5);
        btnB6 = view.findViewById(R.id.btnB6);
        btnB7 = view.findViewById(R.id.btnB7);

        btnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.givecoffeemall.com"));
                startActivity(i);
            }
        });


        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i);
            }
        });


        btnB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(i);
            }
        });


        btnB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                startActivity(i);
            }
        });


        btnB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String url = "content://media/internal/images/media";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });


        btnB6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://119"));
                startActivity(i);
            }
        });


        btnB7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button7:

                        break;

                    default:
                        break;
                }
            }
        });

        // Inflate the layout for this fragment
        return view;

    }

}