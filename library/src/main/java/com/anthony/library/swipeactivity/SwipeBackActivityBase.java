package com.anthony.library.swipeactivity;



/**
 * Create By Anthony on 2016/1/15
 * Class Note:
 * interface for Activity you want to implement swipe-back
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

}
