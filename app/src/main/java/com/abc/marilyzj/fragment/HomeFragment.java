package com.abc.marilyzj.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.LoginActivity;
import com.abc.marilyzj.activity.ProductDetailActivity;
import com.abc.marilyzj.adpter.HomeAdapter;
import com.abc.marilyzj.beans.HomeBean;
import com.abc.marilyzj.fragment.base.BaseFragment;
import com.abc.marilyzj.netutil.MyWealthApi;
import com.abc.marilyzj.netutil.SuscriberX;
import com.abc.marilyzj.util.SharedPreferencesUtil;
import com.abc.marilyzj.util.ToastUtil;
import com.abc.marilyzj.widgets.recycler.OnItemClickListener;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by acer on 2017/4/27.
 */

public class HomeFragment extends BaseFragment implements OnItemClickListener<HomeBean.ObjBean.ReslutBean>, OnRefreshListener {


    private EditText etSerach;
    private Button btSerach;
    private IRecyclerView homeRecycler;
    private HomeAdapter homeAdapter;
    private View noDataView;
    private List<HomeBean.ObjBean.ReslutBean> listData = new ArrayList<>();

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.home_layout;
    }


    @Override
    public void onRefresh() {
        listData.clear();
        getHomeData();
    }

    @Override
    protected void initData() {
        super.initData();
        if (SharedPreferencesUtil.getPrefString(getContext(), "USER_ID", "").equals("")) {
            Intent intent = new Intent(getContext(), LoginActivity.class);
            getContext().startActivity(intent);
        }
        etSerach = (EditText) mContentView.findViewById(R.id.et_search);
        etSerach.clearFocus();
        btSerach = (Button) mContentView.findViewById(R.id.bt_serch);
        btSerach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        homeAdapter = new HomeAdapter(mContext);
        homeRecycler = (IRecyclerView) mContentView.findViewById(R.id.home_recycler);
        homeAdapter.setOnItemClickListener(this);
        homeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        homeRecycler.setIAdapter(homeAdapter);
        homeRecycler.setOnRefreshListener(this);
        homeRecycler.setLoadMoreEnabled(false);
        getHomeData();
    }


    private void getHomeData() {
        mSubscription.add(MyWealthApi.getInstance().getMyWealthService().getHomeData()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new SuscriberX<HomeBean>(getContext()){
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                homeRecycler.setRefreshing(false);
                super.onError(e);
            }

            @Override
            public void onNext(HomeBean homeBean) {
                super.onNext(homeBean);
                switch (homeBean.getCode()) {
                    case "0":
                        ToastUtil.showToast(getContext(), homeBean.getMsg());
                        listData = homeBean.getObj().getReslut();
                        homeAdapter.refreshItems(listData);
                        break;
                    default:
                        ToastUtil.showToast(getContext(), homeBean.getMsg());
                        break;
                }
                homeRecycler.setRefreshing(false);
            }
        }));
    }

    @Override
    public void onItemClick(int position, HomeBean.ObjBean.ReslutBean reslutBean, View v) {
        Intent intent = new Intent(getContext(), ProductDetailActivity.class);
        intent.putExtra("title", reslutBean.getRepairName());
        intent.putExtra("repairItemsId", reslutBean.getRepairItemsId());
        getActivity().startActivity(intent);
    }
}
