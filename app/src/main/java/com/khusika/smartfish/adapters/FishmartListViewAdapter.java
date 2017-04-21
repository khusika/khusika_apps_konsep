package com.khusika.smartfish.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.khusika.smartfish.R;
import com.silencedut.expandablelayout.ExpandableLayout;

import java.util.HashSet;

/**
 * Created by khusika on 20/04/17.
 */

public class FishmartListViewAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private HashSet<Integer> mExpandedPositionSet = new HashSet<>();
    FishmartListViewAdapter(Context context) {
        mLayoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 16;
    }


    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ExpandableLayout expandableLayout;
        if(convertView==null) {
            convertView=mLayoutInflater.inflate(position%2==0? R.layout.item_first:R.layout.item_second,parent,false);
            expandableLayout = (ExpandableLayout) convertView.findViewById(R.id.expandable_layout);
            expandableLayout.setExpandWithParentScroll(false);
            convertView.setTag(expandableLayout);
        }else {
            expandableLayout =(ExpandableLayout) convertView.getTag();
        }

        if(expandableLayout !=null) {
            expandableLayout.setOnExpandListener(new ExpandableLayout.OnExpandListener() {
                @Override
                public void onExpand(boolean expanded) {
                    registerExpand(position);
                }
            });
        }
        expandableLayout.setExpand(mExpandedPositionSet.contains(position));
        return convertView;
    }

    private void registerExpand(int position) {
        if (mExpandedPositionSet.contains(position)) {
            removeExpand(position);
        }else {
            addExpand(position);
        }
    }

    private void removeExpand(int position) {
        mExpandedPositionSet.remove(position);
    }

    private void addExpand(int position) {
        mExpandedPositionSet.add(position);
    }
}