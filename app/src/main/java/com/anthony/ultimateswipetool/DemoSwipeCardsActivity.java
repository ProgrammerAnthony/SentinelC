package com.anthony.ultimateswipetool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.anthony.library.cards.SwipeCards;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Anthony on 2016/6/28.
 * Class Note:
 * demo activity of swipe cards
 *
 */
public class DemoSwipeCardsActivity extends AppCompatActivity implements SwipeCards.SwipeCardsListener {

    @Bind(R.id.swipeCards)
    SwipeCards swipeCards;
    @Bind(R.id.buttonSwipeLeft)
    Button buttonSwipeLeft;
    @Bind(R.id.buttonSwipeRight)
    Button buttonSwipeRight;
    @Bind(R.id.buttonAddData)
    Button buttonAddData;


    private SwipeCardsAdapter mAdapter;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);
        ButterKnife.bind(this);

        mData = new ArrayList<>();
        mAdapter = new SwipeCardsAdapter(mData);
        swipeCards.setAdapter(mAdapter);
        swipeCards.setListener(this);
        fillWithTestData();
    }


    @Override
    public void onViewSwipedToLeft(int position) {
        position += 1;
        Toast.makeText(this, getString(R.string.swipe_left) + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewSwipedToRight(int position) {
        position += 1;
        Toast.makeText(this, getString(R.string.swipe_right) + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCardsEmpty() {
        Toast.makeText(this, R.string.stack_empty, Toast.LENGTH_SHORT).show();
    }

    private void fillWithTestData() {
        for (int x = 0; x < 5; x++) {
            mData.add("card" + (x + 1));
        }
    }

    @OnClick({R.id.buttonSwipeLeft, R.id.buttonSwipeRight, R.id.buttonAddData})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSwipeLeft:
                swipeCards.swipeTopViewToLeft();
                break;
            case R.id.buttonSwipeRight:
                swipeCards.swipeTopViewToRight();
                break;
            case R.id.buttonAddData:
                mData.add("Add data");
                mAdapter.notifyDataSetChanged();
                break;
        }
    }

    public class SwipeCardsAdapter extends BaseAdapter {

        private List<String> mData;

        public SwipeCardsAdapter(List<String> data) {
            this.mData = data;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public String getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.card, parent, false);
            }

            TextView textViewCard = (TextView) convertView.findViewById(R.id.textViewCard);
            textViewCard.setText(mData.get(position));

            return convertView;
        }
    }
}
