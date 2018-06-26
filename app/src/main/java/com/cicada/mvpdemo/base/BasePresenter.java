package com.cicada.mvpdemo.base;

import java.lang.ref.WeakReference;

/**
 * @author Cicada
 * @date 2018/6/25 0025
 * @describe presenter基类
 * @email gcicada@163.com
 */
public abstract class BasePresenter<V> {

    protected WeakReference<V> mViewRef;

    /**
     * 绑定的方法
     * 在onCreate()中调用
     *
     * @param view
     */
    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    /**
     * 解绑
     * 在onDestroy方法中调用，防止内存泄漏
     */
    public void detach() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
        onDestroy();
    }

    //释放资源处理
    public abstract void onDestroy();
}
