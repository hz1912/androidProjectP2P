package com.learn.p2p;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import UIUtils.UIUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fragement.HomeFragment;
import fragement.MeFragment;
import fragement.MoreFragment;
import fragement.TouziFragment;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.iv_touzi)
    ImageView ivTouzi;
    @BindView(R.id.tv_touzi)
    TextView tvTouzi;
    @BindView(R.id.ll_touzi)
    LinearLayout llTouzi;
    @BindView(R.id.iv_me)
    ImageView ivMe;
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.ll_me)
    LinearLayout llMe;
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.ll_more)
    LinearLayout llMore;
    private HomeFragment homeFragment;
    private TouziFragment touziFragment;
    private MeFragment meFragment;
    private MoreFragment moreFragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }


    @OnClick({R.id.ll_home, R.id.ll_touzi, R.id.ll_me, R.id.ll_more})
    public void changeTab(View view) {
        restTabe();
        switch (view.getId()) {
            case R.id.ll_home:
                setSelect(0);
                break;
            case R.id.ll_touzi:
                setSelect(1);
                break;
            case R.id.ll_me:
                setSelect(2);
                break;
            case R.id.ll_more:
                setSelect(3);
                break;
        }
    }

    public void setSelect(int select) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment();

        switch (select) {
            case 0:
                //  首页
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content, homeFragment);
                }
                ivHome.setImageResource(R.drawable.bid01);
                tvHome.setTextColor(UIUtils.getColor(tvHome, R.color.home_back_selected));
                fragmentTransaction.show(homeFragment);
                break;
            case 1:
                // 投资
                if (touziFragment == null) {
                    touziFragment = new TouziFragment();
                    fragmentTransaction.add(R.id.content, touziFragment);
                }
                ivTouzi.setImageResource(R.drawable.bid03);
                tvTouzi.setTextColor(UIUtils.getColor(ivTouzi, R.color.home_back_selected));
                fragmentTransaction.show(touziFragment);
                break;
            case 2:
                //资产
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    fragmentTransaction.add(R.id.content, meFragment);
                }
                ivMe.setImageResource(R.drawable.bid05);
                tvMe.setTextColor(UIUtils.getColor(tvMe, R.color.home_back_selected));
                fragmentTransaction.show(meFragment);
                break;
            case 3:
                //更多
                if (moreFragment == null) {
                    moreFragment = new MoreFragment();
                    fragmentTransaction.add(R.id.content, moreFragment);
                }
                ivMore.setImageResource(R.drawable.bid07);
                tvMore.setTextColor(UIUtils.getColor(tvMore, R.color.home_back_selected));
                fragmentTransaction.show(moreFragment);
                break;
        }
        fragmentTransaction.commit();
    }

    private void restTabe() {
        ivHome.setImageResource(R.drawable.bid02);
        ivTouzi.setImageResource(R.drawable.bid04);
        ivMe.setImageResource(R.drawable.bid06);
        ivMore.setImageResource(R.drawable.bid08);
        tvMe.setTextColor(UIUtils.getColor(tvMe, R.color.home_back_unselected));
        tvTouzi.setTextColor(UIUtils.getColor(ivTouzi, R.color.home_back_unselected));
        tvHome.setTextColor(UIUtils.getColor(tvHome, R.color.home_back_unselected));
        tvMore.setTextColor(UIUtils.getColor(tvMore, R.color.home_back_unselected));
    }

    private void hideFragment() {
        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);
        }
        if (touziFragment != null) {
            fragmentTransaction.hide(touziFragment);
        }
        if (meFragment != null) {
            fragmentTransaction.hide(meFragment);
        }
        if (moreFragment != null) {
            fragmentTransaction.hide(moreFragment);
        }
    }
}
