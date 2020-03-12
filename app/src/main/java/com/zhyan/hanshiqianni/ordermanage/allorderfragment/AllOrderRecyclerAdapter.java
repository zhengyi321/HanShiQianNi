package com.zhyan.hanshiqianni.ordermanage.allorderfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.zhyan.hanshiqianni.R;

import java.util.ArrayList;

public class AllOrderRecyclerAdapter extends RecyclerView.Adapter<AllOrderRecyclerAdapter.RecyclerViewHolder> {
    ArrayList<String> mList = new ArrayList<>();
    Context mContext;

    public AllOrderRecyclerAdapter(Context context) {
        mContext = context;
    }

    public void setList(ArrayList<String> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public AllOrderRecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AllOrderRecyclerAdapter.RecyclerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rv_order_manage, parent, false));
    }

    @Override
    public void onBindViewHolder(AllOrderRecyclerAdapter.RecyclerViewHolder holder, int position) {
//        holder.mTextView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
//            mTextView = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}

