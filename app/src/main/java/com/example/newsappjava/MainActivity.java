package com.example.newsappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;

import com.example.newsappjava.adapter.ViewPagerAdapter;
import com.example.newsappjava.connection.NetworkChangeListener;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem homeTab,scienceTab,techTab,healthTab,sportsTab,enterTab;
    ViewPagerAdapter viewPagerAdapter;
    Toolbar toolbar;
    NetworkChangeListener networkChangeListener=new NetworkChangeListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeTab=findViewById(R.id.home);
        scienceTab=findViewById(R.id.science);
        techTab=findViewById(R.id.technology);
        healthTab=findViewById(R.id.health);
        sportsTab=findViewById(R.id.sports);
        enterTab=findViewById(R.id.entertainment);

        toolbar=findViewById(R.id.toolBar);
        tabLayout=findViewById(R.id.tabLayoutContainer);
        ViewPager viewPager=findViewById(R.id.viewPager);

       viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),6);
       viewPager.setAdapter(viewPagerAdapter);

       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tab.getPosition());
               int po=tab.getPosition();
               if (po==0||po==1||po==2||po==3||po==4||po==5){
                   viewPagerAdapter.notifyDataSetChanged();
               }
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
        });

     viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }


    @Override
    protected void onStart() {
        IntentFilter filter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener,filter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);
        super.onStop();
    }
}