package com.anthony.demo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import com.anthony.ultimateswipetool.dialogFragment.SwipeDialogFragment;

/**
 * Created by Anthony on 2016/6/28.
 * Class Note:
 * extend from SwipeDialogFragment to support swipe dismiss
 */
public class DialogFragmentExample extends SwipeDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new AlertDialog.Builder(getContext())
                .setTitle("swipe dialog fragment")
                .setIcon(R.mipmap.ic_launcher)
                .setItems(new String[]{
                        "1 any dialog ",
                        "2 init in onCreateDialog",

                }, null)
                .create();
        return dialog;
    }


}
