package com.khusika.smartfish.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.khusika.smartfish.R;
import com.khusika.smartfish.adapters.FishmartAdapter;
import com.khusika.smartfish.fragments.FishmartFishFragment;
import com.khusika.smartfish.fragments.FishmartToolsFragment;

/**
 * Created by khusika on 21/04/17.
 */

public class FishmartActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishmart);

        toolbar = (Toolbar) findViewById(R.id.fishmart_toolbar);
        setupToolbar();

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

    private void setupToolbar(){
        toolbar.setTitle(getString(R.string.fishmart_title));
        setSupportActionBar(toolbar);
        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(FishmartActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}
