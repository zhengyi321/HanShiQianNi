package com.zhyan.hanshiqianni;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import butterknife.ButterKnife;

/**
 * Created by az on 2017/4/25.
 */

public  abstract class BaseFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        init();
    }


    protected abstract void  init();

}
