package com.cicada.mvpdemo.manager;

import com.cicada.mvpdemo.base.BaseResponse;
import com.cicada.mvpdemo.entity.LotteryEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author Cicada
 * @date 2018/6/25 0025
 * @describe 接口类
 * @email gcicada@163.com
 */
public interface ApiService {

    /**
     * 获取彩票种类
     * @return
     */
    @GET("types")
    Observable<BaseResponse<List<LotteryEntity>>> getLotteries();
}
