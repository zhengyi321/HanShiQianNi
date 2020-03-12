package com.zhyan.hanshiqianni.productfragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhyan.hanshiqianni.BaseFragment;
import com.zhyan.hanshiqianni.R;
import com.zhyan.hanshiqianni.productdetail.ProductDetailActivity;
import com.zhyan.hanshiqianni.widget.viewpage.ImageCycleView;
import com.zhyan.hanshiqianni.utils.ImageLoaderUtils;
import com.zhyan.hanshiqianni.widget.waterfall.StaggeredDividerItemDecoration;
import com.zhyan.hanshiqianni.widget.waterfall.WaterFallAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductFragment extends BaseFragment {
    @BindView(R.id.icv_main_product_ad_circle)
    ImageCycleView icvMainProductAdCircle;
    @BindView(R.id.refreshlayout)
    SmartRefreshLayout refreshlayout;
    @BindView(R.id.rv_waterfall)
    RecyclerView rv_waterfall;
    ArrayList<String> picList;
    ArrayList<String> waterPicList;
    @Override
    public View setView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        return view;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this,view);
        picList = new ArrayList<>();
        waterPicList = new ArrayList<>();
//        轮播图片模块
        initCycleImg();
        waterFall();
    }
//    轮播图片
    private void initCycleImg(){

        ArrayList<String> imgList2 = new ArrayList<>();

        picList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582275928666&di=1a76614268f1165597f3e11920ad6a8c&imgtype=0&src=http%3A%2F%2Fku.90sjimg.com%2Fback_pic%2F00%2F04%2F14%2F835621db476c94e.jpg");
        picList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582025377352&di=6b7c91e659807a28104bc1ce065dd5ad&imgtype=0&src=http%3A%2F%2Fa1.att.hudong.com%2F05%2F00%2F01300000194285122188000535877.jpg");
        picList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582025377351&di=3b85647e284ff7eab0af201b3348daa7&imgtype=0&src=http%3A%2F%2Fa4.att.hudong.com%2F47%2F66%2F01300000337727123266663353910.jpg");
        picList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582275928665&di=48142673cd8930444ccf82272f8cc964&imgtype=0&src=http%3A%2F%2Fku.90sjimg.com%2Fback_pic%2F03%2F74%2F50%2F6257bc4594264c2.jpg");
        imgList2.add("asaa1111");
        imgList2.add("asa2222");
        imgList2.add("asa3333");
        imgList2.add("asa4444");
        icvMainProductAdCircle.setImageResources(picList,imgList2,imageCycleViewListener);
    }
    private ImageCycleView.ImageCycleViewListener imageCycleViewListener=new ImageCycleView.ImageCycleViewListener() {
        @Override
        public void displayImage(String imageURL, ImageView imageView) {
            ImageLoader.getInstance().displayImage(imageURL,imageView,ImageLoaderUtils.options);
        }

        @Override
        public void onImageClick(String info, int postion, View imageView) {
            /*Toast.makeText(view.getContext(),""+postion+info,Toast.LENGTH_LONG).show();*/
            if(postion != 0){
//                String url = mainIndexAdBean1.getContent().getSide().get(postion).getUrl().toString();
                Intent intent = new Intent(view.getContext(), ProductDetailActivity.class);
//                intent.putExtra("url",url);
                view.getContext().startActivity(intent);
            }
        }
    };

    //    轮播图片
    private ArrayList<Integer> imageIds = new ArrayList<>();
    private int[] ids = {R.mipmap.p1,R.mipmap.p1,R.mipmap.p1,R.mipmap.p1,R.mipmap.p1,R.mipmap.p1,R.mipmap.p1,
            R.mipmap.p1,R.mipmap.p1,R.mipmap.p1,R.mipmap.p1,R.mipmap.p1,R.mipmap.p1,R.mipmap.p1,};

    private WaterFallAdapter adapter;

    private void waterFall(){

        waterPicList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582300817542&di=b02e145b814280a6293505f08d7d9adc&imgtype=0&src=http%3A%2F%2Fwww.szthks.com%2Flocalimg%2F687474703a2f2f6777312e616c6963646e2e636f6d2f62616f2f75706c6f616465642f69362f54314953346d4668566558585858585858585f2121302d6974656d5f7069632e6a7067.jpg");
        waterPicList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582300817541&di=63b418ca32c2b68d140670f9d29754f2&imgtype=0&src=http%3A%2F%2Fwww.szthks.com%2Flocalimg%2F687474703a2f2f6777312e616c6963646e2e636f6d2f62616f2f75706c6f616465642f69372f543137506956586f686858586266646667575f3032333333392e6a7067.jpg");
        waterPicList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582300817540&di=4a70823e94639960872ba79a268496d6&imgtype=0&src=http%3A%2F%2Fwww.szthks.com%2Flocalimg%2F687474703a2f2f6777312e616c6963646e2e636f6d2f62616f2f75706c6f616465642f69382f5431584e4c724649706258585858585858585f2121302d6974656d5f7069632e6a7067.jpg");
        waterPicList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582300817540&di=614a60a83f05e98114f0176414f2812c&imgtype=0&src=http%3A%2F%2Fwww.szthks.com%2Flocalimg%2F687474703a2f2f6777332e616c6963646e2e636f6d2f62616f2f75706c6f616465642f69332f5431645561665843346658585858585858585f2121302d6974656d5f7069632e6a7067.jpg");
        rv_waterfall.setHasFixedSize(true);
        rv_waterfall.setItemAnimator(null);
        //垂直方向的2列
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //防止Item切换
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        rv_waterfall.setLayoutManager(layoutManager);
        final int spanCount = 2;
        rv_waterfall.addItemDecoration(new StaggeredDividerItemDecoration(view.getContext(),10,spanCount));

        //解决底部滚动到顶部时，顶部item上方偶尔会出现一大片间隔的问题
        rv_waterfall.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                int[] first = new int[spanCount];
                layoutManager.findFirstCompletelyVisibleItemPositions(first);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && (first[0] == 1 || first[1] == 1)) {
                    layoutManager.invalidateSpanAssignments();
                }
            }
        });

        //设置Adapter
        for(int i = 0 ; i < ids.length;i++){
            imageIds.add(ids[i]);
        }
        adapter = new WaterFallAdapter();

        rv_waterfall.setAdapter(adapter);
//        adapter.replaceAll(imageIds);
        adapter.replaceAll(waterPicList);

        //设置下拉刷新和上拉加载监听
        refreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.replaceAll(waterPicList);
                        refreshLayout.finishRefresh();
                    }
                },2000);
            }
        });

        refreshlayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        adapter.addData(adapter.getItemCount(),picList);
//                        adapter.addData(adapter.getItemCount(),getData());
                        refreshLayout.finishLoadMore();
                    }
                },2000);
            }
        });

    }

    private ArrayList<Integer>  getData() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 6;i++){
            list.add(ids[i]);
        }
        return list;
    }

}
