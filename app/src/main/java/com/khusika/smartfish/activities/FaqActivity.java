package com.khusika.smartfish.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.khusika.smartfish.R;

/**
 * Created by khusika on 21/04/17.
 */

public class FaqActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        toolbar = (Toolbar) findViewById(R.id.FAQ_toolbar);
        setupToolbar();
    }

    private void setupToolbar(){
        toolbar.setTitle(getString(R.string.FAQ_title));
        setSupportActionBar(toolbar);
        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(FaqActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}
