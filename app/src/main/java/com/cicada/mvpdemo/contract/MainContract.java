package com.cicada.mvpdemo.contract;

import com.cicada.mvpdemo.base.BasePresenter;
import com.cicada.mvpdemo.base.BaseView;
import com.cicada.mvpdemo.entity.LotteryEntity;

import java.util.List;

/**
 * @author Cicada
 * @date 2018/6/25 0025
 * @describe Main契约
 * @email gcicada@163.com
 */
public interface MainContract {

    interface MainView extends BaseView<MainPresenter>{
        void showToast(String message);

        void update(List<LotteryEntity> lotteries);

        void success();
    }

    abstract class MainPresenter<V> extends BasePresenter<MainView>{

        public abstract void getLotteries(V v);
    }
}
