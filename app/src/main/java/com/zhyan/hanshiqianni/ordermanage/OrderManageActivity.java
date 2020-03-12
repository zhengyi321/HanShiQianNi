package com.zhyan.hanshiqianni.ordermanage;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.zhyan.hanshiqianni.R;
import com.zhyan.hanshiqianni.ordermanage.adapter.OrderTabFragmentPagerAdapter;
import com.zhyan.hanshiqianni.ordermanage.allorderfragment.AllOrderFragment;
import com.zhyan.hanshiqianni.ordermanage.allorderfragment.HaveCancelFragment;
import com.zhyan.hanshiqianni.ordermanage.allorderfragment.HaveFinishFragment;
import com.zhyan.hanshiqianni.ordermanage.allorderfragment.WaitGoodsFragment;
import com.zhyan.hanshiqianni.ordermanage.allorderfragment.WaitPayFragment;
import com.zhyan.hanshiqianni.ordermanage.allorderfragment.WaitSendGoodsFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderManageActivity  extends FragmentActivity {

    @BindView(R.id.tly_order_manage)
    TabLayout tablyOrderManage;
    @BindView(R.id.vp_order_manage)
    ViewPager vpOrderManage;
    @BindView(R.id.rly_titly_public_back)
    RelativeLayout rlyProductDetailBack;
    @OnClick(R.id.rly_titly_public_back)
    public void rlyProductDetailBackOnClick(){
        this.finish();
    }
    private AllOrderFragment allOrderFragment;
    private WaitPayFragment waitPayFragment;
    private WaitGoodsFragment waitGoodsFragment;
    private HaveFinishFragment haveFinishFragment;
    private HaveCancelFragment haveCancelFragment;
    private WaitSendGoodsFragment waitSendGoodsFragment;
    private ArrayList<Fragment> list_fragment = new ArrayList<>();
    private ArrayList<String> list_title = new ArrayList<>();
    private OrderTabFragmentPagerAdapter orderTabFragmentPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ordermanage_lly);
        init();
        // Example of a call to a native method
        //调用c++ 3处
//        TextView tv = findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
    }



    //    @Override
    protected void init() {
        ButterKnife.bind(this);
        initFragment();

    }
    private void initFragment(){

        allOrderFragment = new AllOrderFragment();
        waitGoodsFragment = new WaitGoodsFragment();
        waitPayFragment = new WaitPayFragment();
        haveFinishFragment = new HaveFinishFragment();
        haveCancelFragment = new HaveCancelFragment();
        waitSendGoodsFragment = new WaitSendGoodsFragment();
        list_fragment.add(allOrderFragment);
        list_fragment.add(waitPayFragment);
        list_fragment.add(waitSendGoodsFragment);
        list_fragment.add(waitGoodsFragment);
        list_fragment.add(haveFinishFragment);
        list_fragment.add(haveCancelFragment);
//        list_fragment.add(allOrderFragment);

        list_title.add("全部");
        list_title.add("待付款");
        list_title.add("待发货");
        list_title.add("待收货");
        list_title.add("已完成");
        list_title.add("已取消");
//        list_title.add("第二个页面");
        orderTabFragmentPagerAdapter = new OrderTabFragmentPagerAdapter(getSupportFragmentManager(), list_fragment, list_title);

        vpOrderManage.setAdapter(orderTabFragmentPagerAdapter);
        tablyOrderManage.setupWithViewPager(vpOrderManage);
        tablyOrderManage.setTabMode(TabLayout.MODE_FIXED);
    }
}
