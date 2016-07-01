package com.anthony.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.anthony.demo.adapter.GridViewAdapter;
import com.anthony.ultimateswipetool.view.Attributes;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Anthony on 2016/6/30.
 * Class Note:
 */
public class GridViewExample extends Activity {

    @Bind(R.id.gridview)
    GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        ButterKnife.bind(this);


        final GridViewAdapter adapter = new GridViewAdapter(this);
        adapter.setMode(Attributes.Mode.Multiple);
        mGridView.setAdapter(adapter);
    }


}
