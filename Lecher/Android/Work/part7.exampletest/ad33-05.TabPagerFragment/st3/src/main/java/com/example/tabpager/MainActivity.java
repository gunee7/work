package com.example.tabpager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager = null;
    private TabLayout tabLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TabLayout설정
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_menu_agenda));
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_email));
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_lock_idle_alarm));
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_map));
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_info));
        tabLayout.setTabGravity(Gravity.FILL);    // in design : app:tabGravity="fill"
        tabLayout.setTabMode(tabLayout.MODE_FIXED); // in design : app:tabMode="fixed"

        //ViewPager설정
        viewPager = findViewById(R.id.view_pager);
        TabPagerAdapter adapter = new TabPagerAdapter( getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);  //TabPagerAdapter와 View연결

        //TabLayout과 View연결
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //화면에서 tab을 클릭 했을 때
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    private class TabPagerAdapter extends FragmentPagerAdapter {


        private final int tabCount;

        public TabPagerAdapter(FragmentManager fm, int numberOfTabs) {
            super(fm);
            this.tabCount = numberOfTabs;
        }

        @Override
     public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return FragmentTab1.newInstance("one","one");
                case 1:
                    return FragmentTab2.newInstance("two","two");
                case 2:
                    return FragmentTab3.newInstance("three","three");
                case 3:
                    return FragmentTab4.newInstance("four","four");
                case 4:
                    return FragmentTab5.newInstance("five","five");
                    default:
                        return null;
            }

        }

     @Override
     public int getCount() {
         return this.tabCount;
     }

    }
}
