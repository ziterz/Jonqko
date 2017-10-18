package com.ziterz.jonqko;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment homeFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_home, homeFragment)
                            .addToBackStack(null)
                            .commit();
                    return true;
                case R.id.navigation_notification:
                    return true;
                case R.id.navigation_list:
                    return true;
                case R.id.navigation_transaction:
                    return true;
                case R.id.navigation_profile:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_home, homeFragment).addToBackStack(null).commit();

        BottomNavigationViewEx navigation = (BottomNavigationViewEx) findViewById(R.id.navigation);

//        navigation.enableItemShiftingMode(true);
//        navigation.setIconsMarginTop(32);
//        navigation.setIconSize(26,26);
//        navigation.setItemHeight(144);
        navigation.enableAnimation(false);
        navigation.enableShiftingMode(false);
        navigation.enableItemShiftingMode(false);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
