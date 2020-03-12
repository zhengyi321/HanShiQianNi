package com.zhyan.hanshiqianni.minefragment.setting.myaddress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.zhyan.hanshiqianni.R;
import com.zhyan.hanshiqianni.ordermanage.allorderfragment.AllOrderRecyclerAdapter;

import java.util.ArrayList;

public class MineSettingMyAddressRecycleViewAdapter extends RecyclerView.Adapter<MineSettingMyAddressRecycleViewAdapter.RecyclerViewHolder> {
    ArrayList<String> mList = new ArrayList<>();
    Context mContext;

    public MineSettingMyAddressRecycleViewAdapter(Context context) {
        mContext = context;
    }

    public void setList(ArrayList<String> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public MineSettingMyAddressRecycleViewAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MineSettingMyAddressRecycleViewAdapter.RecyclerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rv_mine_setting_myaddr, parent, false));
    }

    @Override
    public void onBindViewHolder(MineSettingMyAddressRecycleViewAdapter.RecyclerViewHolder holder, int position) {
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
