package com.zhyan.hanshiqianni.productdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.zhyan.hanshiqianni.R;
import com.zhyan.hanshiqianni.widget.scrollview.MyScrollView;
import com.zhyan.hanshiqianni.widget.scrollview.PullUpToLoadMore;

public class ProductDetailFirstFragment extends Fragment {
    View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_productdetail_one, container, false);
        initView();
        return mView;
    }

    private void initView() {
        MyScrollView oneScrollView = (MyScrollView) mView.findViewById(R.id.oneScrollview);
        oneScrollView.setScrollListener(new MyScrollView.ScrollListener() {
            @Override
            public void onScrollToBottom() {

            }

            @Override
            public void onScrollToTop() {

            }

            @Override
            public void onScroll(int scrollY) {
                if (scrollY == 0) {
                    PullUpToLoadMore.bottomChildViewIsTop = true;
                } else {
                    PullUpToLoadMore.bottomChildViewIsTop = false;
                }
            }

            @Override
            public void notBottom() {

            }
        });
    }
}
