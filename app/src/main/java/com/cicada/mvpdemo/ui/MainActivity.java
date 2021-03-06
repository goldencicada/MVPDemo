package com.cicada.mvpdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicada.mvpdemo.R;
import com.cicada.mvpdemo.base.BaseActivity;
import com.cicada.mvpdemo.contract.MainContract;
import com.cicada.mvpdemo.entity.LotteryEntity;
import com.cicada.mvpdemo.entity.LotteryResultEntity;
import com.cicada.mvpdemo.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity<MainContract.MainView,
        MainPresenter<MainContract.MainView>> implements MainContract.MainView,
        BaseQuickAdapter.OnItemClickListener{

    public LotteryAdapter mAdapter;

    private List<LotteryEntity> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView mRecyclerView = findViewById(R.id.rv);

        mAdapter = new LotteryAdapter(R.layout.item_lottery, new ArrayList<LotteryEntity>());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter.setOnItemClickListener(this);

        mRecyclerView.setAdapter(mAdapter);

        mPresenter.getLotteries(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter<MainContract.MainView> initPresenter() {
        return new MainPresenter<>();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void update(List<LotteryEntity> lotteries) {
        mData = lotteries;
        mAdapter.setNewData(lotteries);
    }

    @Override
    public void success() {
        findViewById(R.id.progress).setVisibility(View.GONE);
    }

    @Override
    public void showError(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(this, HistoryActivity.class);
        intent.putExtra("lottery_id", mData.get(position).getLottery_id());
        startActivity(intent);
    }
}
