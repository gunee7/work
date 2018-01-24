package com.example.st1drawermenu;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends Fragment {

    private ImageButton imagebtnB1 = null;
    private ImageButton imagebtnB2 = null;
    private ImageButton imagebtnB3 = null;
    private ImageButton imagebtnB4 = null;
    private ImageButton imagebtnB5 = null;
    private ImageButton imagebtnB6 = null;
    private Button imagebtnB7 = null;


    public Tab2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tab2, container, false);

        imagebtnB1 = view.findViewById(R.id.imagebtnB1);
        imagebtnB2 = view.findViewById(R.id.imagebtnB2);
        imagebtnB3 = view.findViewById(R.id.imagebtnB3);
        imagebtnB4 = view.findViewById(R.id.imagebtnB4);
        imagebtnB5 = view.findViewById(R.id.imagebtnB5);
        imagebtnB6 = view.findViewById(R.id.imagebtnB6);
        imagebtnB7 = view.findViewById(R.id.imagebtnB7);



        imagebtnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "기브커피몰로 이동합니다.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.givecoffeemall.com"));
                startActivity(i);
            }
        });


        imagebtnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "구글로 이동합니다.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i);
            }
        });


        imagebtnB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "네이버로 이동합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(i);
            }
        });


        imagebtnB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "유튜브로 이동합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                startActivity(i);
            }
        });


        imagebtnB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "갤러리 사진파일로 이동합니다.", Toast.LENGTH_SHORT).show();
                String url = "content://media/internal/images/media";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });


        imagebtnB6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "응급전화 119로 이동합니다.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://119"));
                startActivity(i);
            }
        });


        imagebtnB7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "카카오로 이동합니다.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kakaocorp.com"));
                startActivity(i);
            }
        });


        // Inflate the layout for this fragment
        return view;

    }

}
