package com.example.viewpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpage.fragment.*;
import android.os.Bundle;

import com.example.viewpage.fragment.Fragment01;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewpager2);
        viewPager2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                Fragment fragment = null;
                switch (position){
                    case 0:
                        fragment = new Fragment01();
                        break;
                    case 1:
                        fragment = new Fragment02();
                        break;
                    case 2:
                        fragment = new Fragment03();
                        break;
                }
                return fragment;
            }

            @Override
            public int getItemCount() {
                return 3;
            }
        });
        new TabLayoutMediator(tabLayout, viewPager2, (tab,position)->tab.setText("fragment" +
                position + 1)).attach();

    }
}