package com.cicada.mvpdemo.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicada.mvpdemo.R;
import com.cicada.mvpdemo.base.BaseActivity;
import com.cicada.mvpdemo.contract.HistoryContract;
import com.cicada.mvpdemo.entity.LotteryEntity;
import com.cicada.mvpdemo.entity.LotteryResultEntity;
import com.cicada.mvpdemo.presenter.HistoryPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * 中奖历史页面
 */
public class HistoryActivity extends BaseActivity<HistoryContract.HistoryView,
        HistoryContract.HistoryPresenter<HistoryContract.HistoryView>> implements
        HistoryContract.HistoryView, BaseQuickAdapter.OnItemClickListener {

    private HistoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String lottery_id = getIntent().getStringExtra("lottery_id");

        RecyclerView mRecyclerView = findViewById(R.id.rv);

        mAdapter = new HistoryAdapter(R.layout.item_history, new ArrayList<LotteryResultEntity.LotteryResListBean>());

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mAdapter);

        mPresenter.getHistory(this, lottery_id, "50", "1");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected HistoryContract.HistoryPresenter<HistoryContract.HistoryView> initPresenter() {
        return new HistoryPresenter();
    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void update(List<LotteryResultEntity.LotteryResListBean> lotteries) {
        mAdapter.setNewData(lotteries);
    }

    @Override
    public void success() {
        findViewById(R.id.progress).setVisibility(View.GONE);
    }

    @Override
    public void showError(String err) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
