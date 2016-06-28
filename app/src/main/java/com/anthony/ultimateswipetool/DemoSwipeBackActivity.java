package com.anthony.ultimateswipetool;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.anthony.library.swipeactivity.AbsSwipeBackActivity;

/**
 * Created by Anthony on 2016/6/28.
 * Class Note:
 */
public class DemoSwipeBackActivity extends AbsSwipeBackActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_back);
    }
}
