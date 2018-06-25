package com.cicada.mvpdemo.base;

import android.support.v4.app.Fragment;

/**
 * @author Cicada
 * @date 2018/6/25 0025
 * @describe fragment基类
 * @email gcicada@163.com
 */
public abstract class BaseFragment<V extends BaseView, P extends BasePresenter> extends Fragment {

    private V mView;

    private P mPresenter;

}
