package com.cicada.mvpdemo.presenter;

import com.cicada.mvpdemo.base.BaseResponse;
import com.cicada.mvpdemo.contract.HistoryContract;
import com.cicada.mvpdemo.entity.LotteryResultEntity;
import com.cicada.mvpdemo.manager.HttpManager;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author Cicada
 * @date 2018/6/26 0026
 * @describe 中奖历史Presenter
 * @email gcicada@163.com
 */
public class HistoryPresenter extends HistoryContract.HistoryPresenter<HistoryContract.HistoryView> {

    @Override
    public void onDestroy() {

    }

    @Override
    public void getHistory(final HistoryContract.HistoryView historyView, String lottery_id,
                           String page_size, String page) {
        HttpManager.getInstance().getHistory(lottery_id, page_size, page,
                new Observer<BaseResponse<LotteryResultEntity>>() {

            Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                this.d = d;
            }

            @Override
            public void onNext(BaseResponse<LotteryResultEntity> lotteryResultEntityBaseResponse) {
                historyView.update(lotteryResultEntityBaseResponse.getResult().getLotteryResList());
            }

            @Override
            public void onError(Throwable e) {
                d.dispose();
            }

            @Override
            public void onComplete() {
                d.dispose();
                historyView.success();
            }
        });
    }
}
