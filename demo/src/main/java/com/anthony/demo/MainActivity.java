package com.anthony.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {


    @Bind(R.id.dialog_fragment)
    Button dialogFragment;
    @Bind(R.id.activity)
    Button activity;
    @Bind(R.id.cards)
    Button cards;
    @Bind(R.id.listView)
    Button listView;
    @Bind(R.id.recyclerview)
    Button recyclerview;
    @Bind(R.id.gridview)
    Button gridview;
    @Bind(R.id.continue_to)
    Button continueTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.dialog_fragment, R.id.activity, R.id.cards, R.id.listView, R.id.recyclerview, R.id.gridview, R.id.continue_to})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.dialog_fragment:
                DialogFragmentExample fragment = new DialogFragmentExample();
                fragment.show(getSupportFragmentManager(), "DialogFragmentExample");
                break;
            case R.id.activity:
                intent = new Intent(this, SwipeBackExample.class);
                break;
            case R.id.cards:
                intent = new Intent(this, SwipeCardsExample.class);
                break;
            case R.id.listView:
                intent = new Intent(this, ListViewExample.class);
                break;
            case R.id.recyclerview:
                intent =new Intent(this,RecyclerViewExample.class);
                break;
            case R.id.gridview:
                intent =new Intent(this,GridViewExample.class);
                break;
            case R.id.continue_to:
                Toast.makeText(this,"more function ,to be continue",Toast.LENGTH_LONG).show();
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

}
