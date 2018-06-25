package com.cicada.mvpdemo.manager;

import com.cicada.mvpdemo.app.App;
import com.cicada.mvpdemo.base.BaseResponse;
import com.cicada.mvpdemo.entity.LotteryEntity;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Cicada
 * @date 2018/6/25 0025
 * @describe 网络请求manager
 * @email gcicada@163.com
 */
public class HttpManager {

    private volatile static HttpManager instance;
    private static final String BASE_URL = "http://apis.juhe.cn/lottery/";
    private static final int TIME_OUT = 10000;
    private Retrofit retrofit;
    private ApiService apiService;

    private HttpManager(){
        OkHttpClient client = new OkHttpClient();
        client.newBuilder().connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static HttpManager getInstance(){
        if (instance == null) {
            synchronized (App.class) {
                instance = new HttpManager();
            }
        }
        return instance;
    }

    /**
     * 获取彩票种类列表
     * @param observer
     */
    public void getLotteries(Observer<BaseResponse<List<LotteryEntity>>> observer){
        apiService.getLotteries("977434db9831c2b30ccb714808715733")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
