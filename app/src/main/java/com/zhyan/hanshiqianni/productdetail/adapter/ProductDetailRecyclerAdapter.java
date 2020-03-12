package com.zhyan.hanshiqianni.productdetail.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.zhyan.hanshiqianni.R;

import java.util.ArrayList;


public class ProductDetailRecyclerAdapter extends RecyclerView.Adapter<ProductDetailRecyclerAdapter.RecyclerViewHolder> {
    ArrayList<String> mList = new ArrayList<>();
    Context mContext;

    public ProductDetailRecyclerAdapter(Context context) {
        mContext = context;
    }

    public void setList(ArrayList<String> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rv_productdetail, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}

