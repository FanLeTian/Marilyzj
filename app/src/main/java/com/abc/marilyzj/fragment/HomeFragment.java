package com.abc.marilyzj.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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
import java.util.HashMap;
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
    private Spinner spinner;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;


    private String type = "0";
    private String param;


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
        spinner = (Spinner) mContentView.findViewById(R.id.spinner);

        //数据
        data_list = new ArrayList<String>();
        data_list.add("地址");
        data_list.add("单位");
        data_list.add("项目");
        //适配器
        arr_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);
        //添加事件Spinner事件监听
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
        btSerach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                param = etSerach.getText().toString();
                if (TextUtils.isEmpty(param)) {
                    ToastUtil.showToast(getContext(), "搜索内容不能为空");
                    return;
                }
                getDataByType();
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

    private void getDataByType() {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", type);
        params.put("param", param);
        mSubscription.add(MyWealthApi.getInstance().getMyWealthService().getInfoByType(params)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new SuscriberX<HomeBean>(getContext()){
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(HomeBean homeBean) {
                super.onNext(homeBean);
                switch (homeBean.getCode()) {
                    case "0":
                        ToastUtil.showToast(getContext(), homeBean.getMsg());
                        listData.clear();
                        listData = homeBean.getObj().getReslut();
                        homeAdapter.refreshItems(listData);
                        break;
                    default:
                        ToastUtil.showToast(getContext(), homeBean.getMsg());
                        break;
                }
            }
        }));
    }

    @Override
    public void onItemClick(int position, HomeBean.ObjBean.ReslutBean reslutBean, View v) {
        Intent intent = new Intent(getContext(), ProductDetailActivity.class);
        intent.putExtra("title", reslutBean.getRepairName());
        intent.putExtra("repairItemsId", reslutBean.getId());
        getActivity().startActivity(intent);
    }


    //使用数组形式操作
    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            type = arg2 + "";
        }
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
}
