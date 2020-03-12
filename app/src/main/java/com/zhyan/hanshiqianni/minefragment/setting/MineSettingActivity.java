package com.zhyan.hanshiqianni.minefragment.setting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.zhyan.hanshiqianni.R;
import com.zhyan.hanshiqianni.minefragment.setting.myaddress.MineSettingMyAddressActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineSettingActivity extends AppCompatActivity {
    @BindView(R.id.rly_titly_public_back)
    RelativeLayout rlyProductDetailBack;
    @OnClick(R.id.rly_titly_public_back)
    public void rlyProductDetailBackOnClick(){
        this.finish();
    }
    @BindView(R.id.lly_mine_setting_myaddress)
    LinearLayout llyMineSettingMyAddress;
    @OnClick(R.id.lly_mine_setting_myaddress)
    public void setLlyMineSettingMyAddressOnclick(){
        Intent intent = new Intent(this, MineSettingMyAddressActivity.class);
//                intent.putExtra("url",url);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mine_setting);
        init();
    }
    private void init(){
        ButterKnife.bind(this);

    }
}
