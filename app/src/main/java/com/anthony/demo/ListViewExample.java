package com.anthony.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.anthony.demo.adapter.ListViewAdapter;
import com.anthony.ultimateswipetool.view.Attributes;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Anthony on 2016/6/30.
 * Class Note:
 */
public class ListViewExample extends Activity {
    @Bind(R.id.listview)
    ListView mListView;
    private ListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ButterKnife.bind(this);

        mAdapter = new ListViewAdapter(this);
        mListView.setAdapter(mAdapter);
        mAdapter.setMode(Attributes.Mode.Single);
    }
}
