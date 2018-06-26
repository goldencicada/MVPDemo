package com.cicada.mvpdemo.ui;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicada.mvpdemo.R;
import com.cicada.mvpdemo.entity.LotteryEntity;

import java.util.List;

/**
 * @author Cicada
 * @date 2018/6/26 0026
 * @describe 彩票种类适配器
 * @email gcicada@163.com
 */
public class LotteryAdapter extends BaseQuickAdapter<LotteryEntity, BaseViewHolder> {

    public LotteryAdapter(int layoutResId, @Nullable List<LotteryEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LotteryEntity item) {
        helper.setText(R.id.tv_lottery, item.getLottery_name());
        helper.setText(R.id.tv_lottery_time, item.getRemarks());

        ImageView ivImg = helper.getView(R.id.iv_lottery);
        switch (item.getLottery_id()){
            case "ssq":
                ivImg.setImageResource(R.mipmap.logo_ssq);
                break;
            case "dlt":
                ivImg.setImageResource(R.mipmap.logo_dlt);
                break;
            case "qlc":
                ivImg.setImageResource(R.mipmap.logo_qlc);
                break;
            case "qxc":
                ivImg.setImageResource(R.mipmap.logo_qxc);
                break;
            case "fcsd":
                ivImg.setImageResource(R.mipmap.logo_3d);
                break;
            case "pls":
                ivImg.setImageResource(R.mipmap.logo_pl3);
                break;
            case "plw":
                ivImg.setImageResource(R.mipmap.logo_pl5);
                break;

        }
    }
}
