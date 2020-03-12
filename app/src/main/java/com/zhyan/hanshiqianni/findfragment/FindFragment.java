package com.zhyan.hanshiqianni.findfragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhyan.hanshiqianni.BaseFragment;
import com.zhyan.hanshiqianni.R;
import com.zhyan.hanshiqianni.findfragment.adapter.FindAdapter;
import com.zhyan.hanshiqianni.widget.waterfall.StaggeredDividerItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindFragment extends BaseFragment {

    @BindView(R.id.rfl_find)
    SmartRefreshLayout rflFind;
    @BindView(R.id.rv_find)
    RecyclerView rvFind;
    private FindAdapter findAdapter;
    @Override
    public View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);

        return view;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this,view);
        initRecycleView();
    }
    private void initRecycleView(){
        rvFind.setHasFixedSize(true);
        rvFind.setItemAnimator(null);
        //垂直方向的2列
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

    //防止Item切换
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        rvFind.setLayoutManager(layoutManager);
        final int spanCount = 1;
        rvFind.addItemDecoration(new StaggeredDividerItemDecoration(view.getContext(),10,spanCount));
        //解决底部滚动到顶部时，顶部item上方偶尔会出现一大片间隔的问题
        rvFind.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                int[] first = new int[spanCount];
                layoutManager.findFirstCompletelyVisibleItemPositions(first);
//                if (newState == RecyclerView.SCROLL_STATE_IDLE && (first[0] == 1 || first[1] == 1)) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE && (first[0] == 1 )) {
                    layoutManager.invalidateSpanAssignments();
                }
            }
        });
        ArrayList<String> dataList = new ArrayList<>();
        for(int i = 0;i < 4;i++){
            dataList.add("");
        }
        findAdapter = new FindAdapter();
        rvFind.setAdapter(findAdapter);
        findAdapter.replaceAll(dataList);
        //设置下拉刷新和上拉加载监听
        rflFind.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        findAdapter.replaceAll(dataList);
                        refreshLayout.finishRefresh();
                    }
                },2000);
            }
        });

        rflFind.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        adapter.addData(adapter.getItemCount(),picList);
                        findAdapter.addData(findAdapter.getItemCount(),dataList);
                        refreshLayout.finishLoadMore();
                    }
                },2000);
            }
        });

    }
}
