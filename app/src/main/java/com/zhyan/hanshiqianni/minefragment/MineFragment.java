package com.zhyan.hanshiqianni.minefragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhyan.hanshiqianni.BaseFragment;
import com.zhyan.hanshiqianni.R;
import com.zhyan.hanshiqianni.minefragment.setting.MineSettingActivity;
import com.zhyan.hanshiqianni.ordermanage.OrderManageActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineFragment extends BaseFragment {
    private View view;

    @BindView(R.id.tv_mine_setting)
    TextView tvMineSetting;
    @OnClick(R.id.tv_mine_setting)
    public void tvMineSettingOnclick(){
        Intent intent = new Intent(view.getContext(), MineSettingActivity.class);
//                intent.putExtra("url",url);
        view.getContext().startActivity(intent);
    }

    @BindView(R.id.tv_mine_ordermanage)
    TextView tvMineOrderManage;
    @OnClick(R.id.tv_mine_ordermanage)
    public void tvMineOrderManageOnclick(){
        if(view != null){
            Intent intent = new Intent(view.getContext(), OrderManageActivity.class);
//                intent.putExtra("url",url);
            view.getContext().startActivity(intent);
        }
    }

    @Override
    public View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void initView() {

    }
    private void initBindId(){

    }
}
