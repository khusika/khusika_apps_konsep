package com.khusika.smartfish.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.khusika.smartfish.R;
import com.khusika.smartfish.adapters.FishmartListViewAdapter;

/**
 * Created by khusika on 20/04/17.
 */

public class FishmartToolsFragment extends Fragment {
    public static FishmartToolsFragment newInstance() {
        FishmartToolsFragment ftf = new FishmartToolsFragment();
        return ftf;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_fishmart,container,false);
        ListView summonerList;
        summonerList = (ListView)rootView.findViewById(R.id.listView);
        summonerList.setAdapter(new FishmartListViewAdapter(getActivity()));
        return rootView;
    }
}