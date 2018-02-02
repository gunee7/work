package com.example.st1drawermenu.Fragment.Tab1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.content.Intent;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.st1drawermenu.LoginPackage.LoginActivity;
import com.example.st1drawermenu.LoginPackage.LoginRequest;
import com.example.st1drawermenu.MainActivity;
import com.example.st1drawermenu.R;
import com.example.st1drawermenu.SubuMenu.SubMenuActivity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tab1Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private View         inflatedview     = null ;
    private Tab1_Adapter_Card tab1Adapter;
    private GridView tab1GridView;
    private List<Tab1_Model_Card> data;
    private int[] images = {
            R.drawable.espresso,
            R.drawable.espressoconpania,
            R.drawable.hotcoffeehtml,
            R.drawable.icecoffeehtml,
            R.drawable.hotcafelatte,
            R.drawable.icecafelatte,
            R.drawable.hotbanilalatte,
            R.drawable.icebanilalatte,
            R.drawable.hotcapuchino,
            R.drawable.icecapuchino,
            R.drawable.hotcafemocha,
            R.drawable.icecafemocha,
            R.drawable.hotwhitechocomacha,
            R.drawable.icewhitechocomacha,
            R.drawable.hotcaramelmachato,
            R.drawable.icecaramelmachato
    };


    public Tab1Fragment() {

    }

    public static Tab1Fragment newInstance(String param1, String param2) {
        Tab1Fragment fragment = new Tab1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override                      // 인플레이션은 이곳에서
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflatedview = inflater.inflate(R.layout.fragment_tab1, container, false);

        data = MakeData( 0 , 15 );

        tab1Adapter = new Tab1_Adapter_Card( getContext(), R.layout.fragment_tab1_custom, data );
        tab1GridView = inflatedview.findViewById( R.id.gridView );
        tab1GridView.setAdapter( tab1Adapter );

        return inflatedview;


    }



    @Override                    // 위젯 관련된 것은 이쪽에서
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );

        tab1GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // intent 여기안에서 하기
                Intent i = new Intent ( getContext(), SubMenuActivity.class);
                i.putExtra( "position" , position);
                startActivity(i);
            }
        });



    }

    private List<Tab1_Model_Card> MakeData( int start, int end ) {

        String[] coffeeName = getResources().getStringArray(R.array.menu_title);
        List<Tab1_Model_Card> list = new ArrayList<>();
        for(int i =start ; i<=end; i++){

            Tab1_Model_Card item = new Tab1_Model_Card();
            item.setImageCoffee(getResources().getDrawable(images[i]));
            item.setTextCoffee( coffeeName[i] );

            list.add(item);
        }

        return list;
    }



}
