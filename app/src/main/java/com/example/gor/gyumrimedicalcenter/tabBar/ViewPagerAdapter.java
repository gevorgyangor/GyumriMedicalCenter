package com.example.gor.gyumrimedicalcenter.tabBar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.example.gor.gyumrimedicalcenter.stomatologylist.StomatologyListFragment;
import com.example.gor.gyumrimedicalcenter.packagelist.PachageListFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence titles[];

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        titles = new CharSequence[]{
                "DEPARTMENT","package"
        };


    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                StomatologyListFragment stomatologyListFragment = new StomatologyListFragment();
                return stomatologyListFragment;

            case 1:
                PachageListFragment pachageListFragment = new PachageListFragment();
                return pachageListFragment;
        }
        return null;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }


    @Override
    public int getCount() {
        return titles.length;
    }
}