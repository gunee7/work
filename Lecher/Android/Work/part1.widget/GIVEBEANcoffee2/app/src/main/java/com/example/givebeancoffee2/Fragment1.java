package com.example.givebeancoffee2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {



    public Fragment1() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);


    }


    private Button btnA1;
    private Button btnA2;
    private Button btnA3;
    private Button btnA4;
    private Button btnA5;
    private Button btnA6;
    private Button btnA7;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnA1:
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.givecoffeemall.com"));
                startActivity(i);
                break;

            case R.id.btnA2:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(i);
                break;

            case R.id.btnA3:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                startActivity(i);
                break;

            case R.id.btnA4:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i);
                break;

            case R.id.btnA5:
                String url = "content://media/internal/images/media";
                i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
                break;

            case R.id.btnA6:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://119"));
                startActivity(i);
                break;
            case R.id.btnA7:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://119"));
                startActivity(i);
                break;


        }
    }
}

