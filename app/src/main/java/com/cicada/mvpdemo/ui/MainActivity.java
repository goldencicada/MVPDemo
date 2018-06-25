package com.cicada.mvpdemo.ui;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.cicada.mvpdemo.R;
import com.cicada.mvpdemo.base.BaseActivity;
import com.cicada.mvpdemo.contract.MainContract;
import com.cicada.mvpdemo.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainContract.MainView,
        MainPresenter<MainContract.MainView>> implements MainContract.MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.getCities(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter<MainContract.MainView> initPresenter() {
        return new MainPresenter<>();
    }

    @Override
    public void showToast(String message) {
        ((TextView)findViewById(R.id.lottery)).setText(message);
    }

    @Override
    public void showError(String err) {

    }
}
