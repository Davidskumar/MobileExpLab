package com.example.mobileexplab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class EightActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy {

    ViewPager2 viewPager2;
    TabLayout tabLayout;
    ArrayList<String> tabTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);
        viewPager2 = findViewById(R.id.viewPagerId);
        tabLayout = findViewById(R.id.tabLayout);
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());
        viewPager2Adapter.setFragments(fragments);
        viewPager2.setAdapter(viewPager2Adapter);
        tabTitles = new ArrayList<>();
        tabTitles.add("First");
        tabTitles.add("Second");
        tabTitles.add("Third");
        new TabLayoutMediator(tabLayout,viewPager2, this).attach();

    }

    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(tabTitles.get(position));
    }
}