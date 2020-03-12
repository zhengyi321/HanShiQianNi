package com.zhyan.hanshiqianni.productdetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.google.android.material.tabs.TabLayout;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhyan.hanshiqianni.R;
import com.zhyan.hanshiqianni.productdetail.adapter.TabFragmentPagerAdapter;
import com.zhyan.hanshiqianni.utils.ImageLoaderUtils;
import com.zhyan.hanshiqianni.widget.imageview.NetworkImageHolderView;
import com.zhyan.hanshiqianni.widget.viewpage.ImageCycleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailActivity  extends AppCompatActivity {
    private ArrayList<Fragment> list_fragment = new ArrayList<>();
    private ArrayList<String> list_title = new ArrayList<>();
    private ProductDetailFirstFragment mOneFragment;
    private ProductDetailSecondFragment mTwoFragment;



    private TabFragmentPagerAdapter pagerAdapter;

    private ViewPager viewPager;

    private TabLayout tabLayout;
   /* ConvenientBanner mBanner;*/
    @BindView(R.id.rly_titly_public_back)
    RelativeLayout rlyProductDetailBack;
    @OnClick(R.id.rly_titly_public_back)
    public void rlyProductDetailBackOnClick(){
        this.finish();
    }
    @BindView(R.id.icv_productdetail_ad_circle)
    ImageCycleView icvProductDetailAdCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_productdetail);
        initControls();
    }

    //    轮播图片
    private void initCycleImg(){

        ArrayList<String> imgList2 = new ArrayList<>();
        ArrayList<String> picList = new ArrayList<>();
        picList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582275928666&di=1a76614268f1165597f3e11920ad6a8c&imgtype=0&src=http%3A%2F%2Fku.90sjimg.com%2Fback_pic%2F00%2F04%2F14%2F835621db476c94e.jpg");
        picList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582025377352&di=6b7c91e659807a28104bc1ce065dd5ad&imgtype=0&src=http%3A%2F%2Fa1.att.hudong.com%2F05%2F00%2F01300000194285122188000535877.jpg");
        picList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582025377351&di=3b85647e284ff7eab0af201b3348daa7&imgtype=0&src=http%3A%2F%2Fa4.att.hudong.com%2F47%2F66%2F01300000337727123266663353910.jpg");
        picList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582275928665&di=48142673cd8930444ccf82272f8cc964&imgtype=0&src=http%3A%2F%2Fku.90sjimg.com%2Fback_pic%2F03%2F74%2F50%2F6257bc4594264c2.jpg");
        imgList2.add("asaa1111");
        imgList2.add("asa2222");
        imgList2.add("asa3333");
        imgList2.add("asa4444");
        icvProductDetailAdCircle.setImageResources(picList,imgList2,imageCycleViewListener);
    }
    private ImageCycleView.ImageCycleViewListener imageCycleViewListener=new ImageCycleView.ImageCycleViewListener() {
        @Override
        public void displayImage(String imageURL, ImageView imageView) {
            ImageLoader.getInstance().displayImage(imageURL,imageView, ImageLoaderUtils.options);
        }

        @Override
        public void onImageClick(String info, int postion, View imageView) {

        }
    };

    //    轮播图片
    /**
     * 初始化各控件
     */
    private void initControls() {
        ButterKnife.bind(this);
        /*List<String> networkImages = new ArrayList<>();
        networkImages.add("http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg");
        networkImages.add("http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg");
        networkImages.add("http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg");
        networkImages.add("http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg");
        mBanner = (ConvenientBanner) findViewById(R.id.banner_convenient);
        mBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, networkImages);
        //是否显示小圆点
        mBanner.setPointViewVisible(true);
        mBanner.startTurning(2000);*/

        initCycleImg();
        //初始化各fragment
        mOneFragment = new ProductDetailFirstFragment();
        mTwoFragment = new ProductDetailSecondFragment();
        list_fragment.add(mOneFragment);
        list_fragment.add(mTwoFragment);

        list_title.add("第一个页面");
        list_title.add("第二个页面");

        pagerAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list_fragment, list_title);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
}
