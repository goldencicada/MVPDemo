package com.cicada.mvpdemo.presenter;

import com.cicada.mvpdemo.base.BaseResponse;
import com.cicada.mvpdemo.contract.MainContract;
import com.cicada.mvpdemo.entity.LotteryEntity;
import com.cicada.mvpdemo.manager.HttpManager;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainPresenter<V> extends MainContract.MainPresenter<MainContract.MainView>{

    @Override
    public void onDestroy() {

    }

    @Override
    public void getLotteries(final MainContract.MainView view) {
        HttpManager.getInstance().getLotteries(new Observer<BaseResponse<List<LotteryEntity>>>() {

            Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                this.d = d;
            }

            @Override
            public void onNext(BaseResponse<List<LotteryEntity>> listBaseResponse) {
                List<LotteryEntity> lotteries = listBaseResponse.getResult();
                view.update(lotteries);
            }

            @Override
            public void onError(Throwable e) {
                view.showToast(e.getMessage());
                d.dispose();
            }

            @Override
            public void onComplete() {
                view.success();
                d.dispose();
            }
        });
    }
}
