package com.example.ktra2.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ktra2.fragment.FragmentList;
import com.example.ktra2.fragment.FragmentPerson;
import com.example.ktra2.fragment.FragmentSearch;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentList();
            case 1: return new FragmentPerson();
            case 2: return new FragmentSearch();
//            default:return new FragmentList();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
