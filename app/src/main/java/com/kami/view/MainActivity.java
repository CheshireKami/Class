package com.kami.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager vp_container;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<>();

//    private Fragment transcationFrg,meFrg;
    private LinearLayout tab_msg,tab_flag,tab_me;
    private ImageView img_msg,img_flag,img_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        vp_container = (ViewPager) findViewById(R.id.container);


        tab_msg = (LinearLayout) findViewById(R.id.tab_msg);
        tab_flag = (LinearLayout) findViewById(R.id.tab_flag);
        tab_me = (LinearLayout) findViewById(R.id.tab_me);

        img_msg = (ImageView) findViewById(R.id.img_msg);
        img_flag = (ImageView) findViewById(R.id.img_flag);
        img_me = (ImageView) findViewById(R.id.img_me);

        tab_msg.setOnClickListener(this);
        tab_flag.setOnClickListener(this);
        tab_me.setOnClickListener(this);

        Fragment msgFrg = new MeFrg();
        mFragments.add(msgFrg);
        Fragment transcationFrg = new TranscationFrg();
        mFragments.add(transcationFrg);
        Fragment meFrg = new MeFrg();
        mFragments.add(meFrg);

        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),mFragments);

        vp_container.setAdapter(mAdapter);

    }

    //重置所有按钮为正常状态
    private void resetImg(){
        img_msg.setBackgroundResource(R.drawable.tab_msg_normal);
        img_flag.setBackgroundResource(R.drawable.tab_flag_normal);
        img_me.setBackgroundResource(R.drawable.tab_me_normal);
    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()){
            case R.id.tab_msg:
                select(0);
                break;
            case R.id.tab_flag:
                select(1);
                break;
            case R.id.tab_me:
                select(2);
                break;
        }
    }

    //点击按钮的对应事件
    private void select(int i) {
        switch (i){
            case 0:
                img_msg.setBackgroundResource(R.drawable.tab_msg_pressed);
                vp_container.setCurrentItem(i);
                break;
            case 1:
                img_flag.setBackgroundResource(R.drawable.tab_flag_pressed);
                vp_container.setCurrentItem(i);
                break;
            case 2:
                img_me.setBackgroundResource(R.drawable.tab_me_pressed);
                vp_container.setCurrentItem(i);
                break;
        }
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter{

        List<Fragment> mFragments;

        public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
            super(fm);
            this.mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

}
