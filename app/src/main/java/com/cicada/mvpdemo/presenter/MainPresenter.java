package com.cicada.mvpdemo.presenter;

import com.cicada.mvpdemo.contract.MainContract;

public class MainPresenter<V> extends MainContract.MainPresenter<MainContract.MainView>{

    @Override
    public void fetch() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void getCities(MainContract.MainView view) {
        view.showToast("哈哈哈哈哈哈哈哈哈哈哈哈哈");
    }

}
