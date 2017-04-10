package com.khusika.smartfish.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

/**
 * Created by khusika on 11/04/17.
 */

public class SquareCardView extends CardView {

    public SquareCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int ignoredHeightMeasureSpec) {
        int newHeightMeasureSpec = widthMeasureSpec;
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }

}