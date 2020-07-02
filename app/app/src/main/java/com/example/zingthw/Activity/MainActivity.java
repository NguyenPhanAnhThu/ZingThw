package com.example.zingthw.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.zingthw.Adapter.ViewPagerAdapter;
import com.example.zingthw.Fragment.HomeFragment;
import com.example.zingthw.Fragment.SearchFragment;
import com.example.zingthw.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setControl(){
        tabLayout= findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
    }
    private void setEvent(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);
        viewPagerAdapter.addFragment(new HomeFragment(), "Trang chủ");
        viewPagerAdapter.addFragment(new SearchFragment(), "Tìm kiếm");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);

    }
}
