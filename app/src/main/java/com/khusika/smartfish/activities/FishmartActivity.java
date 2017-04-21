package com.silencedut.expandablelayoutsample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.khusika.smartfish.R;
import com.khusika.smartfish.adapters.FishmartAdapter;
import com.khusika.smartfish.fragments.FishmartFishFragment;
import com.khusika.smartfish.fragments.FishmartToolsFragment;

public class FishmartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishmart);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tableLayout);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        FishmartAdapter adapter = new FishmartAdapter(getSupportFragmentManager());

        Fragment fragment1 = new FishmartFishFragment();
        Bundle data1 = new Bundle();
        data1.putInt("id", 0);
        fragment1.setArguments(data1);
        adapter.addFrag(fragment1, getString(R.string.FishmartFish));

        Fragment fragment2 = new FishmartToolsFragment();
        Bundle data2 = new Bundle();
        data2.putInt("id", 0);
        fragment2.setArguments(data2);
        adapter.addFrag(fragment2, getString(R.string.FishmartTools));

        viewPager.setAdapter(adapter);

    }
}