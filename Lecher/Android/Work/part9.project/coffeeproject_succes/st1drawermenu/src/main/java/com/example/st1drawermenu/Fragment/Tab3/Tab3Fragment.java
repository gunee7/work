package com.example.st1drawermenu.Fragment.Tab3;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.content.Intent;

import com.example.st1drawermenu.R;
import com.example.st1drawermenu.SubuMenu.SubMenuActivity;

import java.util.ArrayList;
import java.util.List;

public class Tab3Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;


    private View         inflatedview3     = null ;
    private Tab3_Adapter_Card tab3Adapter;
    private GridView tab3GridView;
    private List<Tab3_Model_Card> data3;

    private int[] beverage_images    = Tab3MenuButton.beverage_icon;


    private int getid3 = 0;


    public Tab3Fragment() {

    }

    public static com.example.st1drawermenu.Fragment.Tab3.Tab3Fragment newInstance(String param1, String param2) {
        com.example.st1drawermenu.Fragment.Tab3.Tab3Fragment fragment = new com.example.st1drawermenu.Fragment.Tab3.Tab3Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        inflatedview3 = inflater.inflate(R.layout.fragment_tab1, container, false);

        data3 = MakeData3( 0 , beverage_images.length - 1 );

        tab3Adapter = new Tab3_Adapter_Card( getContext(), R.layout.fragment_tab3_custom, data3 );
        tab3GridView = inflatedview3.findViewById( R.id.gridView1 );
        tab3GridView.setAdapter( tab3Adapter );


        return inflatedview3;
    }




    @Override                    // 위젯 관련된 것은 이쪽에서
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );


        tab3GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // intent 여기안에서 하기
                Intent i = new Intent ( getContext(), SubMenuActivity.class);
                i.putExtra( "position" , position );
                i.putExtra( "name"     , getid3 );
                startActivity(i);
            }
        });

    }


    private List<Tab3_Model_Card> MakeData3( int start, int end ) {

        String[] coffeeName = getResources().getStringArray(R.array.menu_coffee_name);
        List<Tab3_Model_Card> list = new ArrayList<>();
        for(int i =start ; i<=end; i++){

            Tab3_Model_Card item = new Tab3_Model_Card();
            item.setImageCoffee(getResources().getDrawable(beverage_images[i]));
            item.setTextCoffee( coffeeName[i] );

            list.add(item);
        }

        return list;
    }

}




