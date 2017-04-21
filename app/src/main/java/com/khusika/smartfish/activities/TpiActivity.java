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
import com.khusika.smartfish.fragments.TpiInternasionalFragment;
import com.khusika.smartfish.fragments.TpiLokalFragment;
import com.khusika.smartfish.fragments.TpiNasionalFragment;

/**
 * Created by khusika on 21/04/17.
 */

public class TpiActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpi);

        toolbar = (Toolbar) findViewById(R.id.TPI_toolbar);
        setupToolbar();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tpitableLayout);
        ViewPager viewPager = (ViewPager)findViewById(R.id.tpiviewPager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        FishmartAdapter adapter = new FishmartAdapter(getSupportFragmentManager());

        Fragment fragment1 = new TpiLokalFragment();
        Bundle data1 = new Bundle();
        data1.putInt("id", 0);
        fragment1.setArguments(data1);
        adapter.addFrag(fragment1, getString(R.string.TpiLokal));

        Fragment fragment2 = new TpiNasionalFragment();
        Bundle data2 = new Bundle();
        data2.putInt("id", 0);
        fragment2.setArguments(data2);
        adapter.addFrag(fragment2, getString(R.string.TpiNasional));

        Fragment fragment3 = new TpiInternasionalFragment();
        Bundle data3 = new Bundle();
        data3.putInt("id", 0);
        fragment3.setArguments(data3);
        adapter.addFrag(fragment3, getString(R.string.TpiInternasional));

        viewPager.setAdapter(adapter);

    }

    private void setupToolbar(){
        toolbar.setTitle(getString(R.string.TPI_title));
        setSupportActionBar(toolbar);
        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(TpiActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}
