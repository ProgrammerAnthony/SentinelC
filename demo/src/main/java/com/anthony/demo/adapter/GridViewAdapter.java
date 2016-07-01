package com.anthony.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anthony.demo.R;
import com.anthony.ultimateswipetool.view.adapter.BaseSwipeAdapter;

/**
 * Created by Anthony on 2016/6/30.
 * Class Note:
 * GridView Adapter for {@link com.anthony.demo.GridViewExample}
 */
public class GridViewAdapter extends BaseSwipeAdapter {
    private Context mContext;

    public GridViewAdapter(Context mContext) {
        this.mContext = mContext;
    }
    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public View generateView(int position, ViewGroup parent) {
        return LayoutInflater.from(mContext).inflate(R.layout.view_item, null);
    }

    @Override
    public void fillValues(int position, View convertView) {
        TextView t = (TextView)convertView.findViewById(R.id.position);
        t.setText((position + 1) + ".");
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
