package com.example.st1drawermenu.Fragment.Tab4;


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

public class Tab4Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;


    private View         inflatedview4     = null ;
    private Tab4_Adapter_Card tab4Adapter;
    private GridView tab4GridView;
    private List<Tab4_Model_Card> data4;

    private int[] tea_iamges       =  Tab4MenuButton.tea_icon;


    private int getid4 = 0;


    public Tab4Fragment() {

    }

    public static com.example.st1drawermenu.Fragment.Tab4.Tab4Fragment newInstance(String param1, String param2) {
        com.example.st1drawermenu.Fragment.Tab4.Tab4Fragment fragment = new com.example.st1drawermenu.Fragment.Tab4.Tab4Fragment();
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
        inflatedview4 = inflater.inflate(R.layout.fragment_tab4, container, false);

        data4 = MakeData4( 0 , tea_iamges.length - 1 );

        tab4Adapter = new Tab4_Adapter_Card( getContext(), R.layout.fragment_tab4_custom, data4 );
        tab4GridView = inflatedview4.findViewById( R.id.gridView4 );
        tab4GridView.setAdapter( tab4Adapter );


        return inflatedview4;
    }




    @Override                    // 위젯 관련된 것은 이쪽에서
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );


        tab4GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // intent 여기안에서 하기
                Intent i = new Intent ( getContext(), SubMenuActivity.class);
                i.putExtra( "position" , position );
                i.putExtra( "name"     , getid4 );
                startActivity(i);
            }
        });

    }


    private List<Tab4_Model_Card> MakeData4( int start, int end ) {

        String[] teaName = getResources().getStringArray(R.array.menu_tea_name);
        List<Tab4_Model_Card> list = new ArrayList<>();
        for(int i =start ; i<=end; i++){

            Tab4_Model_Card item = new Tab4_Model_Card();
            item.setImageCoffee(getResources().getDrawable(tea_iamges[i]));
            item.setTextCoffee( teaName[i] );

            list.add(item);
        }

        return list;
    }

}




