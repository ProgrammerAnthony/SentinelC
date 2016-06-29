package com.anthony.library.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.anthony.library.SwipeHelper;

/**
 * Created by Anthony on 2016/6/28.
 * Class Note:
 * Activity extends from this class to support swipe back to close
 */
public class AbsSwipeBackActivity extends AppCompatActivity implements SwipeBackActivityBase{
    /**
     * swipeBack helper to using swipeBack
     */
    private SwipeHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeHelper(this);
        mHelper.onActivityCreate();
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {

        SwipeHelper.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }

    @Override
    public void setScrollDirection(int edgeFlags) {
        int edgeFlag = edgeFlags;//SwipeBackLayout.EDGE_ALL| EDGE_LEFT | EDGE_RIGHT | EDGE_BOTTOM | EDGE_TOP
        getSwipeBackLayout().setEdgeTrackingEnabled(edgeFlag);
    }

}
