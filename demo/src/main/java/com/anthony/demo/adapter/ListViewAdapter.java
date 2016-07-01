package com.anthony.demo.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.anthony.demo.R;
import com.anthony.ultimateswipetool.view.SwipeViewLayout;
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
        return R.id.swipe;
    }

    @Override
    public View generateView(int position, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.view_item, null);
        SwipeViewLayout swipeViewLayout = (SwipeViewLayout)v.findViewById(getSwipeLayoutResourceId(position));
        swipeViewLayout.addSwipeListener(new SwipeViewLayout.SwipeListener(){
            @Override
            public void onStartOpen(SwipeViewLayout layout) {

            }

            @Override
            public void onOpen(SwipeViewLayout layout) {

            }

            @Override
            public void onStartClose(SwipeViewLayout layout) {

            }

            @Override
            public void onClose(SwipeViewLayout layout) {

            }

            @Override
            public void onUpdate(SwipeViewLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeViewLayout layout, float xvel, float yvel) {

            }
        });

        swipeViewLayout.setOnDoubleClickListener(new SwipeViewLayout.DoubleClickListener() {
            @Override
            public void onDoubleClick(SwipeViewLayout layout, boolean surface) {
                Toast.makeText(mContext, "DoubleClick", Toast.LENGTH_SHORT).show();
            }
        });



        return v;
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
