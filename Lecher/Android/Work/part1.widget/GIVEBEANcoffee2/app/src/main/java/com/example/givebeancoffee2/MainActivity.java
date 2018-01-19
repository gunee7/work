package com.example.givebeancoffee2;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final int FRAGMENT1 = 1;
    private final int FRAGMENT2 = 2;
    private final int FRAGMENT3 = 3;
    private final int FRAGMENT4 = 4;
    private final int FRAGMENT5 = 5;

    private Button btngivebean, btnfriend, btnchat, btnmygive, btnview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯에 대한 참조]
        tabHost = (FragmentTabHost) view.findViewById(R.id.tabhost);
        //Fragment에서 탭을 사용시 탭 내부에 있는 프래그먼트는 기존 부모프래그먼트의 지원이 아닌
        // 부모 프래그먼트 // 자식 프래그먼트의 지원을 얻어야 하므로getChildFragmentManger()를 사용한다//

        tabHost.setup(getContext(), getChildFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Menber List"),
                OverseasTeamMemberListFragment.class, null);

        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Location"),
                OverseasTeamLocationFragment.class, null);

        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Etc"),
                OverseasTeamEtcInfoFragment.class, null);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btngivebean :
                // '버튼1' 클릭 시 '프래그먼트1' 호출
                callFragment(FRAGMENT1);
                break;

            case R.id.btnfriend :
                // '버튼2' 클릭 시 '프래그먼트2' 호출
                callFragment(FRAGMENT2);
                break;

            case R.id.btnchat :
                // '버튼2' 클릭 시 '프래그먼트2' 호출
                callFragment(FRAGMENT3);
                break;

            case R.id.btnmygive :
                // '버튼2' 클릭 시 '프래그먼트2' 호출
                callFragment(FRAGMENT4);
                break;

            case R.id.btnview :
                // '버튼2' 클릭 시 '프래그먼트2' 호출
                callFragment(FRAGMENT5);
                break;

        }
    }

    private void callFragment(int frament_no){

        // 프래그먼트 사용을 위해
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (frament_no){
            case 1:
                // '프래그먼트1' 호출
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.fragment_container, fragment1);
                transaction.commit();
                break;

            case 2:
                // '프래그먼트2' 호출
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;

            case 3:
                // '프래그먼트3' 호출
                Fragment3 fragment3 = new Fragment3();
                transaction.replace(R.id.fragment_container, fragment3);
                transaction.commit();
                break;

            case 4:
                // '프래그먼트4' 호출
                Fragment4 fragment4 = new Fragment4();
                transaction.replace(R.id.fragment_container, fragment4);
                transaction.commit();
                break;

            case 5:
                // '프래그먼트5' 호출
                Fragment5 fragment5 = new Fragment5();
                transaction.replace(R.id.fragment_container, fragment5);
                transaction.commit();
                break;
        }

    }


}
