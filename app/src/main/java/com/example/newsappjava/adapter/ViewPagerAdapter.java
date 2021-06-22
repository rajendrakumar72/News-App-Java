package com.example.newsappjava.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.newsappjava.fragment.EntertainmentFragment;
import com.example.newsappjava.fragment.HealthFragment;
import com.example.newsappjava.fragment.HomeFragment;
import com.example.newsappjava.fragment.ScienceFragment;
import com.example.newsappjava.fragment.SportsFragment;
import com.example.newsappjava.fragment.TechnologyFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new  HomeFragment();

            case 1:
                return  new SportsFragment();

            case 2:
                return new HealthFragment();

            case 3:
                return new ScienceFragment();

            case 4:
                return new EntertainmentFragment();

            case 5:
                return new TechnologyFragment();

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
