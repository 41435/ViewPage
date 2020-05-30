package com.example.viewpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpage.databinding.ActivityMainBinding;
import com.example.viewpage.fragment.*;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.TextView;

import com.example.viewpage.fragment.Fragment01;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



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
//        new TabLayoutMediator(binding.tabLayout, binding.viewpager2, (tab,position)->tab.setText("fragment" +
//                position + 1)).attach();
        new TabLayoutMediator(binding.tabLayout, binding.viewpager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView tabView = new TextView(MainActivity.this);
                tabView.setText(String.valueOf(position));
                tabView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                tab.setCustomView(tabView);
            }
        }).attach();
    }
}