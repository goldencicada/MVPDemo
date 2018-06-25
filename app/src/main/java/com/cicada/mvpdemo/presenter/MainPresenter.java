package com.cicada.mvpdemo.presenter;

import android.util.Log;

import com.cicada.mvpdemo.base.BaseResponse;
import com.cicada.mvpdemo.contract.MainContract;
import com.cicada.mvpdemo.entity.LotteryEntity;
import com.cicada.mvpdemo.manager.HttpManager;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainPresenter<V> extends MainContract.MainPresenter<MainContract.MainView>{

    @Override
    public void fetch() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void getCities(MainContract.MainView view) {
        HttpManager.getInstance().getLotteries(new Observer<BaseResponse<List<LotteryEntity>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseResponse<List<LotteryEntity>> listBaseResponse) {
                Log.e("test", "onNext: " + listBaseResponse.toString() );
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
