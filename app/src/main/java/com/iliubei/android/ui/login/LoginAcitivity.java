package com.iliubei.android.ui.login;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.iliubei.android.R;
import com.iliubei.android.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eaway on 2017/4/4.
 */

public class LoginAcitivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_acitivity);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
        super.initView();
        setToolbar(mToolbar, "登录");
        mToolbar.inflateMenu(R.menu.menu_main);
    }
}

