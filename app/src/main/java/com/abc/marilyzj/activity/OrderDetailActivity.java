package com.abc.marilyzj.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.base.BackBaseActivity;
import com.abc.marilyzj.beans.ChangeOderTypeBean;
import com.abc.marilyzj.beans.OderInfoBean;
import com.abc.marilyzj.netutil.MyWealthApi;
import com.abc.marilyzj.netutil.SuscriberX;
import com.abc.marilyzj.util.ToastUtil;

import java.util.HashMap;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by acer on 2017/5/2.
 */

public class OrderDetailActivity extends BackBaseActivity {


    private String orderid;
    private String type;

    private TextView oderId;
    private TextView oderName;
    private TextView oderPrice;
    private TextView companyName;
    private TextView companyAdd;
    private TextView companyPhone;
    private TextView userName;
    private TextView oderTime;
    private Button enter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oder_detail_layout);
        setTitle(getIntent().getStringExtra("title"));
        orderid = getIntent().getStringExtra("oderId");
        type = getIntent().getStringExtra("type");
        initView();
        initData();
    }



    private void initData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderid", orderid);
        mSubscription.add(MyWealthApi.getInstance().getMyWealthService().getOderDetail(params)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new SuscriberX<OderInfoBean>(this) {
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(OderInfoBean oderInfoBean) {
                super.onNext(oderInfoBean);
                switch (oderInfoBean.getCode()) {
                    case "0":
                        oderName.setText(oderInfoBean.getObj().getObj().getOrder().getOrderName());
                        oderId.setText("订单号：" + oderInfoBean.getObj().getObj().getOrder().getOrderId());
                        oderPrice.setText(oderInfoBean.getObj().getObj().getOrder().getPrice());
                        companyName.setText(oderInfoBean.getObj().getObj().getDept().getDeptName());
                        companyAdd.setText(oderInfoBean.getObj().getObj().getDept().getDeptAddress());
                        companyPhone.setText(oderInfoBean.getObj().getObj().getDept().getDeptPhone());
                        userName.setText(oderInfoBean.getObj().getObj().getOrder().getUserName());
                        oderTime.setText(oderInfoBean.getObj().getObj().getOrder().getOrderData());
                        ToastUtil.showToast(OrderDetailActivity.this, oderInfoBean.getMsg());
                        break;
                    default:
                        ToastUtil.showToast(OrderDetailActivity.this, oderInfoBean.getMsg());
                        break;
                }
            }
        }));
    }

    private void initView() {
        oderName = (TextView) findViewById(R.id.oder_name);
        oderPrice = (TextView) findViewById(R.id.oder_price);
        oderId = (TextView) findViewById(R.id.oder_id);
        oderTime = (TextView) findViewById(R.id.oder_time);
        companyName = (TextView) findViewById(R.id.oder_company);
        companyPhone = (TextView) findViewById(R.id.company_phone);
        companyAdd = (TextView) findViewById(R.id.oder_address);
        userName = (TextView) findViewById(R.id.oder_personnmae);
        enter = (Button) findViewById(R.id.to_enter_oder);
        if (type.equals("0")) {

        } else if (type.equals("1")) {
            enter.setEnabled(true);
            enter.setText("确认");
            enter.setBackgroundColor(ContextCompat.getColor(this, R.color.aaaaa));
        } else if (type.equals("2")) {
            enter.setEnabled(false);
            enter.setText("待完成");
            enter.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        } else if (type.equals("3")) {
            enter.setEnabled(false);
            enter.setText("已完成");
            enter.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        } else if (type.equals("4")) {
            enter.setEnabled(false);
            enter.setText("已取消");
            enter.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        }
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeType();
            }
        });
    }

    private void changeType() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderid", orderid);
        params.put("type", "2");
        mSubscription.add(MyWealthApi.getInstance().getMyWealthService()
        .changeType(params)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new SuscriberX<ChangeOderTypeBean>(this){
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
            @Override
            public void onNext(ChangeOderTypeBean changeOderTypeBean) {
                super.onNext(changeOderTypeBean);
                switch (changeOderTypeBean.getCode()) {
                    case "0":
                        ToastUtil.showToast(OrderDetailActivity.this, changeOderTypeBean.getMsg());
                        enter.setEnabled(false);
                        enter.setText("待完成");
                        enter.setBackgroundColor(ContextCompat.getColor(OrderDetailActivity.this, R.color.black));
                        break;
                }
            }
        }));
    }



}
