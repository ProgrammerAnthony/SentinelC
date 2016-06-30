package com.anthony.ultimateswipetool.activity.interfaces;


import com.anthony.ultimateswipetool.activity.AbsSwipeBackActivity;
import com.anthony.ultimateswipetool.activity.SwipeBackLayout;

/**
 * Create By Anthony on 2016/1/15
 * Class Note:
 * interfaces for Activity you want to implement swipe-back
 * {@link AbsSwipeBackActivity}
 */
public interface SwipeBackActivityBase {
    /**
     *the SwipeBackLayout associated with this activity.
     */
   SwipeBackLayout getSwipeBackLayout();


    void setSwipeBackEnable(boolean enable);

    /**
     * Scroll out contentView and finish the activity
     */
    void scrollToFinishActivity();

    void setScrollDirection(int edgeFlags);

}
