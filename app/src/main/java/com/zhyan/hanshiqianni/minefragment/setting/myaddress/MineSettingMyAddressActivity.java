package com.zhyan.hanshiqianni.minefragment.setting.myaddress;

import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhyan.hanshiqianni.R;
import com.zhyan.hanshiqianni.ordermanage.allorderfragment.AllOrderRecyclerAdapter;
import com.zhyan.hanshiqianni.widget.scrollview.PullUpToLoadMore;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineSettingMyAddressActivity extends AppCompatActivity {

    @BindView(R.id.rv_mine_setting_myaddr)
    RecyclerView rvMineSettingMyAddr;
    @BindView(R.id.rly_titly_public_back)
    RelativeLayout rlyProductDetailBack;
    @OnClick(R.id.rly_titly_public_back)
    public void rlyProductDetailBackOnClick(){
        this.finish();
    }
    ArrayList<String> mList = new ArrayList<>();
    private MineSettingMyAddressRecycleViewAdapter mineSettingMyAddressRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mine_setting_my_address);
        init();
    }
    private void init(){
        ButterKnife.bind(this);
        initMyAddrRecycleView();

    }
    private void initMyAddrRecycleView(){
        for (int i = 0; i < 5; i++) {
            mList.add("我是李小米吖：" + i);
        }
//        mRecyclerView = (RecyclerView) mView.findViewById(R.id.rv_order_manage);
        rvMineSettingMyAddr.setLayoutManager(new LinearLayoutManager(this));
        mineSettingMyAddressRecycleViewAdapter = new MineSettingMyAddressRecycleViewAdapter(this);
        mineSettingMyAddressRecycleViewAdapter.setList(mList);
        rvMineSettingMyAddr.setAdapter(mineSettingMyAddressRecycleViewAdapter);

        //兼容api23以以下版本
        rvMineSettingMyAddr.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                RecyclerView.LayoutManager layoutManager = rvMineSettingMyAddr.getLayoutManager();
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
