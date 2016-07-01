package com.anthony.demo.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anthony.demo.R;
import com.anthony.ultimateswipetool.view.SwipeViewLayout;
import com.anthony.ultimateswipetool.view.adapter.RecyclerSwipeAdapter;

import java.util.ArrayList;

/**
 * Created by Anthony on 2016/6/30.
 * Class Note:
 * RecyclerView Adapter for {@link com.anthony.demo.RecyclerViewExample}
 */
public class RecyclerViewAdapter extends RecyclerSwipeAdapter<RecyclerViewAdapter.SimpleViewHolder> {

    private Context mContext;
    private ArrayList<String> mDataset;
    public RecyclerViewAdapter(Context context, ArrayList<String> objects) {
        this.mContext = context;
        this.mDataset = objects;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SimpleViewHolder viewHolder,final int position) {

        String item = mDataset.get(position);
        viewHolder.swipeViewLayout.setShowMode(SwipeViewLayout.ShowMode.LayDown);

        viewHolder.swipeViewLayout.addSwipeListener(new SwipeViewLayout.SwipeListener() {
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

        viewHolder.swipeViewLayout.setOnDoubleClickListener(new SwipeViewLayout.DoubleClickListener() {
            @Override
            public void onDoubleClick(SwipeViewLayout layout, boolean surface) {
                Toast.makeText(mContext, "DoubleClick", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.ivTrash.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mItemManger.removeShownLayouts(viewHolder.swipeViewLayout);
                mDataset.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, mDataset.size());
                mItemManger.closeAllItems();
                Toast.makeText(view.getContext(), "Deleted " + (position+1) + "!", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.textViewPos.setText((position + 1) + ".");
        mItemManger.bind(viewHolder.itemView, position);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        SwipeViewLayout swipeViewLayout;
        TextView textViewPos;
        ImageView ivTrash;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            swipeViewLayout = (SwipeViewLayout) itemView.findViewById(R.id.swipe);
            textViewPos = (TextView) itemView.findViewById(R.id.position);
            ivTrash =(ImageView)itemView.findViewById(R.id.trash);
        }
    }
}
