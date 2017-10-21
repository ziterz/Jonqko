package com.ziterz.jonqko;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ziterz on 10/21/2017.
 */

public class HomeAdapter extends FragmentPagerAdapter {

    int num;

    public HomeAdapter(FragmentManager fm,int num) {
        super(fm);
        this.num = num;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new ItemFragment();
            case 1:
                return new TokoFragment();
            default:
                return new ItemFragment();
        }
    }

    @Override
    public int getCount() {
        return num;
    }
}
