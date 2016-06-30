package com.anthony.demo.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.anthony.ultimateswipetool.view.adapter.BaseSwipeAdapter;

/**
 * Created by Anthony on 2016/6/30.
 * Class Note:
 * ListView adapter for{@link com.anthony.demo.ListViewExample}
 */
public class ListViewAdapter  extends BaseSwipeAdapter {
    private Context mContext;

    public ListViewAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public int getSwipeLayoutResourceId(int position) {
        return 0;
    }

    @Override
    public View generateView(int position, ViewGroup parent) {
        return null;
    }

    @Override
    public void fillValues(int position, View convertView) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
