package com.anthony.demo;

import android.os.Bundle;

import com.anthony.ultimateswipetool.activity.AbsSwipeBackActivity;
import com.anthony.ultimateswipetool.activity.SwipeBackLayout;

/**
 * Created by Anthony on 2016/6/28.
 * Class Note:
 * extend from {@link AbsSwipeBackActivity} to support swipe back
 */
public class SwipeBackExample extends AbsSwipeBackActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        setScrollDirection(SwipeBackLayout.EDGE_ALL);//four direction support
    }
}
