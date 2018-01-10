package com.android.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.bottomnavigation.R;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_donut:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.donut, null));
                    return true;
                case R.id.navigation_muffin:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.muffin, null));
                    return true;
                case R.id.navigation_waffle:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.waffle, null));
                    return true;

                case R.id.navigation_crawacint:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.crawacint, null));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
