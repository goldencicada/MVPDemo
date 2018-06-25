package com.cicada.mvpdemo.contract;

import com.cicada.mvpdemo.base.BasePresenter;
import com.cicada.mvpdemo.base.BaseView;

/**
 * @author Cicada
 * @date 2018/6/25 0025
 * @describe Main契约
 * @email gcicada@163.com
 */
public interface MainContract {

    interface MainView extends BaseView<MainPresenter>{
        void showToast(String message);
    }

    abstract class MainPresenter<V> extends BasePresenter<MainView>{
        public abstract void getCities(V v);
    }
}
