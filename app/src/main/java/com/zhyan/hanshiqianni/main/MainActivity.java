package com.zhyan.hanshiqianni.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zhyan.hanshiqianni.BaseFragmentActivity;
import com.zhyan.hanshiqianni.R;
import com.zhyan.hanshiqianni.findfragment.FindFragment;
import com.zhyan.hanshiqianni.minefragment.MineFragment;
import com.zhyan.hanshiqianni.productfragment.ProductFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends FragmentActivity {

    // Used to load the 'native-lib' library on application startup.
    //调用c++ 3处
//    static {
//        System.loadLibrary("native-lib");
//    }
    private boolean isFirst = true;
    FragmentManager manager;
    private ProductFragment productFragment;
    private MineFragment mineFragment;
    private FindFragment findFragment;
    @BindView(R.id.rb_main_bottom_p)
    RadioButton rbMainBottomP;
    @OnClick(R.id.rb_main_bottom_p)
    public void rbMainBottomP(){
        getFragment("product");
    }
    @BindView(R.id.rb_main_bottom_f)
    RadioButton rbMainBottomF;
    @OnClick(R.id.rb_main_bottom_f)
    public void rbMainBottomFOnclick(){
        getFragment("find");
    }
    @BindView(R.id.rb_main_bottom_l)
    RadioButton rbMainBottomL;
    @BindView(R.id.rb_main_bottom_m)
    RadioButton rbMainBottomM;
    @OnClick(R.id.rb_main_bottom_m)
    public void rbMainBottomMineOnclick(){
        getFragment("mine");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        init();
        // Example of a call to a native method
        //调用c++ 3处
//        TextView tv = findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
    }



//    @Override
    protected void init() {
        ButterKnife.bind(this);
        getFragment("product");
    }
    /* 初始化fragment*/
    private void initFragment(FragmentTransaction transaction){
        /* manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();*/
        if(productFragment == null){

            productFragment = new ProductFragment();
            transaction.add(R.id.p_main_content, productFragment, "product");
        }
        if(mineFragment == null){
            mineFragment = new MineFragment();
            transaction.add(R.id.p_main_content, mineFragment, "mine");
        }
        /*if(mainAdviceFragment == null){
            mainAdviceFragment = new MainAdviceFragment();
            transaction.add(R.id.fly_new_main_content, mainAdviceFragment, "advice");
        }
        if(chatMessageFragmentl == null){
            chatMessageFragmentl = new ChatMessageFragment();
            transaction.add(R.id.fly_new_main_content, chatMessageFragmentl, "message");
        }
        if(mainMineFragment != null){
            mainMineFragment = new MainMineFragment();
            mainMineFragment = new NewMainMineFragment();
            transaction.add(R.id.fly_new_main_content, mainMineFragment, "mine");
        }*/
        /* transaction.show(mainIndexFragment);*/
        /*    transaction.commit();*/
    }

    private void hideFragment(FragmentTransaction transaction){
        if(productFragment !=null){
            transaction.hide(productFragment);
        }
        if(findFragment != null){
            transaction.hide(findFragment);
        }
        if(mineFragment != null){
            transaction.hide(mineFragment);
        }
    /*    if(mainAdviceFragment != null){
            transaction.hide(mainAdviceFragment);
        }
        if(chatMessageFragmentl != null){
            transaction.hide(chatMessageFragmentl);
        }
        if(mainMineFragment != null){
            transaction.hide(mainMineFragment);
        }*/
    }
    private void getFragment(String type){
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
      /*  if(isFirst) {
            initFragment(transaction);
            isFirst = false;
        }*/
        hideFragment(transaction);
        // 动态增加Fragment
        switch (type){
            case "product":

                if(productFragment !=null){
                    transaction.show(productFragment);
                }else {

                    productFragment = new ProductFragment();
                    transaction.add(R.id.p_main_content, productFragment, "index");
                }
                break;
            case "find":

                if(findFragment != null){

                    transaction.show(findFragment);
                }else {
                    findFragment = new FindFragment();

                    transaction.add(R.id.p_main_content, findFragment, "release");
                }
                break;
            case "left":

              /*  if(mainAdviceFragment != null){

                    transaction.show(mainAdviceFragment);
                }else {
                    mainAdviceFragment = new MainAdviceFragment();

                    transaction.add(R.id.fly_new_main_content, mainAdviceFragment, "advice");
                }*/
                break;

            case "mine":
//                mainController.initStatusBar("mine");
                if(mineFragment != null){

                    transaction.show(mineFragment);
                }else {
                    mineFragment = new MineFragment();

                    transaction.add(R.id.p_main_content, mineFragment, "mine");
                }
                break;

        }

        transaction.commit();
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //调用c++ 3处
//    public native String stringFromJNI();
}
