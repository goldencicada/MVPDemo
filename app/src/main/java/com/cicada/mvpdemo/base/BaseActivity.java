package com.cicada.mvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Cicada
 * @date 2018/6/25 0025
 * @describe Activity基类
 * @email gcicada@163.com
 */
public abstract class BaseActivity<V, P extends BasePresenter<V>> extends AppCompatActivity {

    protected P mPresenter;

    private Activity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mContext = this;

        mPresenter = initPresenter();

        if (mPresenter != null) {
            mPresenter.attachView((V) this);
            mPresenter.fetch();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detach();
    }

    protected abstract int getLayoutId();

    protected abstract P initPresenter();
}

