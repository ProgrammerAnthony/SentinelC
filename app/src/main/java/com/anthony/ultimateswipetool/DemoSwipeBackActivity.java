package com.anthony.ultimateswipetool;

import android.os.Bundle;

import com.anthony.library.activity.AbsSwipeBackActivity;
import com.anthony.library.activity.SwipeBackLayout;

/**
 * Created by Anthony on 2016/6/28.
 * Class Note:
 * extend from {@link AbsSwipeBackActivity} to support swipe back
 */
public class DemoSwipeBackActivity extends AbsSwipeBackActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_back);

        setScrollDirection(SwipeBackLayout.EDGE_ALL);

    }
}
