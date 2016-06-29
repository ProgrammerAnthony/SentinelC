package com.anthony.library.dialogFragment;

import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.anthony.library.SwipeHelper;

/**
 * Created by Anthony on 2016/6/28.
 * Class Note:
 * extend from this class to support swipe to dismiss the {@link DialogFragment}
 */
public class SwipeDialogFragment extends DialogFragment {
    private boolean mSwipeable = true;
    private boolean mTiltEnabled = true;
    private boolean mSwipeLayoutGenerated = false;
    private SwipeLayout swipeLayout;
    /**
     * Set whether dialog can be swiped away.
     */
    public void setSwipeable(boolean swipeable) {
        mSwipeable = swipeable;
    }

    /**
     * Get whether dialog can be swiped away.
     */
    public boolean isSwipeable() {
        return mSwipeable;
    }

    /**
     * Set whether tilt effect is enabled on swiping.
     */
    public void setTiltEnabled(boolean tiltEnabled) {
        mTiltEnabled = tiltEnabled;
        if(swipeLayout!=null){
            swipeLayout.setTiltEnabled(tiltEnabled);
        }
    }

    /**
     * Get whether tilt effect is enabled on swiping.
     */
    public boolean isTiltEnabled() {
        return mTiltEnabled;
    }

    /**
     * Called when dialog is swiped away to dismiss.
     * @return true to prevent dismissing
     */
    public boolean onSwipedAway(boolean toRight) {
        return false;
    }


    @Override
    public void onStart() {
        super.onStart();

        if (!mSwipeLayoutGenerated && getShowsDialog()) {
            Window window = getDialog().getWindow();
            ViewGroup decorView = (ViewGroup)window.getDecorView();

            swipeLayout =new SwipeLayout(getActivity());

            SwipeHelper.replaceContentView(window,swipeLayout);

            swipeLayout.addSwipeListener(decorView,"layout",new SwipeLayout.DismissCallbacks() {
                @Override
                public boolean canDismiss(Object token) {
                    return isCancelable() && mSwipeable;
                }

                @Override
                public void onDismiss(View view, boolean toRight, Object token) {
                    if (!onSwipedAway(toRight)) {
                        dismiss();
                    }
                }
            });

            swipeLayout.setTiltEnabled(mTiltEnabled);
            swipeLayout.setClickable(true);

            mSwipeLayoutGenerated = true;
        }
    }
}
