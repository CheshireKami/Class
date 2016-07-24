package com.kami.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;



public class LoginAty extends AppCompatActivity implements View.OnClickListener {

    private List<View> mViewList = new ArrayList<>();
    private FrameLayout mFrameLayout;
    private Button btn_loginbox,btn_registerbox;
    private boolean isLoginBox = true;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login_aty);

        initView();

    }

    //    初始化界面
    private void initView() {
        mFrameLayout = (FrameLayout) findViewById(R.id.fl_container);

        LayoutInflater mInflater = LayoutInflater.from(this);
        View view1 = mInflater.inflate(R.layout.pager_loginbox,null);
        mViewList.add(view1);
        View view2 = mInflater.inflate(R.layout.pager_registbox,null);
        mViewList.add(view2);

        btn_login = (Button) view1.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginAty.this,MainActivity.class));
            }
        });

        mFrameLayout.addView(mViewList.get(0));

        btn_loginbox = (Button) findViewById(R.id.btn_loginbox);
        btn_loginbox.setOnClickListener(this);
        btn_registerbox = (Button) findViewById(R.id.btn_registerbox);
        btn_registerbox.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_loginbox:
               selectLogin();
                break;
            case R.id.btn_registerbox:
                selectRegister();
                break;
        }
    }

    //选中登陆选项卡
    private void selectLogin(){
        if (!isLoginBox){
            btn_loginbox.setBackgroundResource(R.drawable.shape_login_sbtn);
            btn_loginbox.setTextColor(0xff333333);
            btn_registerbox.setBackgroundResource(R.drawable.shape_login_nbtn);
            btn_registerbox.setTextColor(0xffffffff);
            mFrameLayout.removeAllViews();
            mFrameLayout.addView(mViewList.get(0));
            isLoginBox = true;
        }
    }

    //选中注册选项卡
    private void selectRegister(){
        if (isLoginBox){
            btn_registerbox.setBackgroundResource(R.drawable.shape_login_sbtn);
            btn_registerbox.setTextColor(0xff333333);
            btn_loginbox.setBackgroundResource(R.drawable.shape_login_nbtn);
            btn_loginbox.setTextColor(0xffffffff);
            mFrameLayout.removeAllViews();
            mFrameLayout.addView(mViewList.get(1));
            isLoginBox = false;
        }
    }

}


