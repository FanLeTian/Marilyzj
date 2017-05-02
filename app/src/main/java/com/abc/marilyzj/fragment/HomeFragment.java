package com.abc.marilyzj.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.LoginActivity;
import com.abc.marilyzj.adpter.HomeAdapter;
import com.abc.marilyzj.beans.HomeListBean;
import com.abc.marilyzj.fragment.base.BaseFragment;
import com.abc.marilyzj.util.SharedPreferencesUtil;
import com.abc.marilyzj.util.ToastUtil;
import com.abc.marilyzj.widgets.recycler.OnItemClickListener;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 2017/4/27.
 */

public class HomeFragment extends BaseFragment implements OnItemClickListener<HomeListBean.ObjBean>, OnRefreshListener {


    private EditText etSerach;
    private Button btSerach;


    private IRecyclerView homeRecycler;
    private HomeAdapter homeAdapter;
    private View noDataView;
    private List<HomeListBean.ObjBean> dataList = new ArrayList<>();


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
        getHomeRequest();
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
        getHomeRequest();
    }

    private void getHomeRequest() {
        if (dataList.size() != 0) {
            dataList.clear();
        }
        HomeListBean.ObjBean objbean1 = new HomeListBean.ObjBean();
        HomeListBean.ObjBean objbean2 = new HomeListBean.ObjBean();
        HomeListBean.ObjBean objbean3 = new HomeListBean.ObjBean();

        objbean1.setRepairName("常规保修");
        objbean1.setRepairItemsId("1000.0");
        objbean2.setRepairName("大修");
        objbean2.setRepairItemsId("5000.0");
        objbean3.setRepairName("保养");
        objbean3.setRepairItemsId("2000.0");
        dataList.add(objbean1);
        dataList.add(objbean2);
        dataList.add(objbean3);
        homeAdapter.refreshItems(dataList);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                homeRecycler.setRefreshing(false);
            }
        }, 2000);

    }


    @Override
    public void onItemClick(int position, HomeListBean.ObjBean objBean, View v) {
        ToastUtil.showToast(mContext, objBean.getRepairName());
    }
}
