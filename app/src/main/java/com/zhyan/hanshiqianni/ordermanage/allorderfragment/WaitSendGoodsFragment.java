package com.zhyan.hanshiqianni.ordermanage.allorderfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhyan.hanshiqianni.BaseFragment;
import com.zhyan.hanshiqianni.R;
import com.zhyan.hanshiqianni.widget.scrollview.PullUpToLoadMore;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WaitSendGoodsFragment extends BaseFragment {
    private AllOrderRecyclerAdapter allOrderRecyclerAdapter;
    private View view;
    @BindView(R.id.rv_order_manage)
    RecyclerView rvOrderManage;
    ArrayList<String> mList = new ArrayList<>();
    @Override
    public View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ordermanage, container, false);

        return view;
    }

    @Override
    public void initView() {
        if (view != null) {
            ButterKnife.bind(this,view);
        }
        initRecycleView();
    }
    private void initRecycleView() {
        for (int i = 0; i < 5; i++) {
            mList.add("我是李小米吖：" + i);
        }
//        mRecyclerView = (RecyclerView) mView.findViewById(R.id.rv_order_manage);
        rvOrderManage.setLayoutManager(new LinearLayoutManager(getActivity()));
        allOrderRecyclerAdapter = new AllOrderRecyclerAdapter(getActivity());
        allOrderRecyclerAdapter.setList(mList);
        rvOrderManage.setAdapter(allOrderRecyclerAdapter);

        //兼容api23以以下版本
        rvOrderManage.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                RecyclerView.LayoutManager layoutManager = rvOrderManage.getLayoutManager();
                //得到当前界面，第一个子视图的position
                int firstVisibleItemPosition = ((LinearLayoutManager) layoutManager)
                        .findFirstVisibleItemPosition();
                if (firstVisibleItemPosition == 0) {
                    PullUpToLoadMore.bottomChildViewIsTop = true;
                } else {
                    PullUpToLoadMore.bottomChildViewIsTop = false;
                }
            }
        });
    }
}
