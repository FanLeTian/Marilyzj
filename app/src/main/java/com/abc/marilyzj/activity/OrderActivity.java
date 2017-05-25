package com.abc.marilyzj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.base.BackBaseActivity;
import com.abc.marilyzj.adpter.OderAdapter;
import com.abc.marilyzj.beans.OderListBean;
import com.abc.marilyzj.netutil.MyWealthApi;
import com.abc.marilyzj.netutil.SuscriberX;
import com.abc.marilyzj.util.SharedPreferencesUtil;
import com.abc.marilyzj.widgets.recycler.OnItemClickListener;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by acer on 2017/5/2.
 */

public class OrderActivity extends BackBaseActivity implements OnItemClickListener<OderListBean.ObjBeanX.ObjBean.ReslutBean>, OnRefreshListener {

    private IRecyclerView mRecyclerView;
    private OderAdapter mOderAdapter;
    private List<OderListBean.ObjBeanX.ObjBean.ReslutBean> dataList = new ArrayList<>();
    private String userId;
    private String type;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oder_layout);
        String title = getIntent().getStringExtra("title");
        type = getIntent().getStringExtra("type");
        userId = SharedPreferencesUtil.getPrefString(this, "USER_ID", "");
        setTitle(title);
        initView();
        if (type.equals("0")) {

        } else if (type.equals("1")) {

        } else if (type.equals("2")) {

        }
    }

    private void initView() {
        mRecyclerView = (IRecyclerView) findViewById(R.id.oder_recycler);
        mOderAdapter = new OderAdapter(this);
        mOderAdapter.setOnItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setIAdapter(mOderAdapter);
        mRecyclerView.setOnRefreshListener(this);
        mRecyclerView.setLoadMoreEnabled(false);
        getOderList();
    }


    @Override
    public void onItemClick(int position, OderListBean.ObjBeanX.ObjBean.ReslutBean reslutBean, View v) {
        Intent intent = new Intent(this, OrderDetailActivity.class);
        intent.putExtra("title", reslutBean.getOrder().getOrderName());
        intent.putExtra("oderId", reslutBean.getOrder().getOrderId());
        intent.putExtra("type", reslutBean.getOrder().getPayStatus());
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        dataList.clear();
        getOderList();
    }


    @Override
    protected void onResume() {
        super.onResume();
        onRefresh();
    }

    private void getOderList() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userid", userId);
        params.put("type", type);
        mSubscription.add(MyWealthApi.getInstance().getMyWealthService().getAllOder(params)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new SuscriberX<OderListBean>(this){
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mRecyclerView.setRefreshing(false);
            }

            @Override
            public void onNext(OderListBean oderListBean) {
                super.onNext(oderListBean);
                dataList = oderListBean.getObj().getObj().getReslut();
                mOderAdapter.refreshItems(dataList);
                mRecyclerView.setRefreshing(false);
            }
        }));
    }

}
