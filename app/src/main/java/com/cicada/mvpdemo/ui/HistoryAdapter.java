package com.cicada.mvpdemo.ui;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicada.mvpdemo.R;
import com.cicada.mvpdemo.entity.LotteryResultEntity;

import java.util.List;

/**
 * @author Cicada
 * @date 2018/6/26 0026
 * @describe 中奖历史适配器
 * @email gcicada@163.com
 */
public class HistoryAdapter extends BaseQuickAdapter<LotteryResultEntity.LotteryResListBean, BaseViewHolder> {

    public HistoryAdapter(int layoutResId, @Nullable List<LotteryResultEntity.LotteryResListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LotteryResultEntity.LotteryResListBean item) {
        helper.setText(R.id.tv_res, item.getLottery_res());
        helper.setText(R.id.tv_no, item.getLottery_no());
        helper.setText(R.id.tv_date, item.getLottery_date());
        helper.setText(R.id.tv_exdate, item.getLottery_exdate());
        helper.setText(R.id.tv_lottery_sale_amount, item.getLottery_sale_amount());
        helper.setText(R.id.tv_lottery_pool_amount, item.getLottery_pool_amount());
    }
}
