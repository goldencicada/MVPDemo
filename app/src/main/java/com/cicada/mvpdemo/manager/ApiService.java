package com.cicada.mvpdemo.manager;

import com.cicada.mvpdemo.base.BaseResponse;
import com.cicada.mvpdemo.entity.LotteryEntity;
import com.cicada.mvpdemo.entity.LotteryResultEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author Cicada
 * @date 2018/6/25 0025
 * @describe 接口类
 * @email gcicada@163.com
 */
public interface ApiService {

    /**
     * 获取彩票种类
     * @param key
     * @return
     */
    @GET("types")
    Observable<BaseResponse<List<LotteryEntity>>> getLotteries(@Query("key") String key);

    /**
     * 中奖历史
     * @param key 聚合key
     * @param lottery_id  彩票id
     * @param page_size 页面大小
     * @param page 当前页
     * @return
     */
    @FormUrlEncoded
    @POST("history")
    Observable<BaseResponse<LotteryResultEntity>> getHistory(@Field("key") String key,
                                                             @Field("lottery_id") String lottery_id,
                                                             @Field("page_size") String page_size,
                                                             @Field("page") String page);
}
