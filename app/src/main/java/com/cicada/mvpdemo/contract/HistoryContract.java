package com.cicada.mvpdemo.contract;

import com.cicada.mvpdemo.base.BasePresenter;
import com.cicada.mvpdemo.base.BaseView;
import com.cicada.mvpdemo.entity.LotteryEntity;
import com.cicada.mvpdemo.entity.LotteryResultEntity;

import java.util.List;

/**
 * @author Cicada
 * @date 2018/6/26 0026
 * @describe 中奖历史契约
 * @email gcicada@163.com
 */
public interface HistoryContract {

    interface HistoryView extends BaseView<HistoryContract.HistoryPresenter> {
        void showToast(String message);

        void update(List<LotteryResultEntity.LotteryResListBean>  lotteries);

        void success();
    }

    abstract class HistoryPresenter<V> extends BasePresenter<HistoryContract.HistoryView> {

        public abstract void getHistory(V v, String lottery_id, String page_size, String page);
    }
}
