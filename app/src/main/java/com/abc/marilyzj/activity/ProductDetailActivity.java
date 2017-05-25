package com.abc.marilyzj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.base.BackBaseActivity;
import com.abc.marilyzj.beans.ProductBean;
import com.abc.marilyzj.netutil.MyWealthApi;
import com.abc.marilyzj.netutil.SuscriberX;

import java.util.HashMap;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by acer on 2017/5/2.
 */

public class ProductDetailActivity extends BackBaseActivity implements View.OnClickListener{


    private TextView productName;
    private TextView productPrice;
    private TextView productCompany;
    private TextView productAddress;
    private TextView productPhone;
    private TextView productEmail;
    private Button reservation;
    private String repairItemsId;
    private String title;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detial_layout);
        title = getIntent().getStringExtra("title");
        repairItemsId = getIntent().getStringExtra("repairItemsId");
        setTitle(title);
        initView();
        getProductRequest();
    }

    private void initView() {
        productName = (TextView) findViewById(R.id.product_name);
        productPrice = (TextView) findViewById(R.id.product_price);
        productCompany = (TextView) findViewById(R.id.product_company);
        productAddress = (TextView) findViewById(R.id.product_address);
        productPhone = (TextView) findViewById(R.id.company_phone);
        productEmail = (TextView) findViewById(R.id.company_email);
        reservation = (Button) findViewById(R.id.to_reservation);
        reservation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_reservation:
                Intent intent = new Intent(this, ReservationActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("id", repairItemsId);
                startActivity(intent);
                break;
        }

    }

    private void getProductRequest() {
        HashMap<String, String> params = new HashMap<>();
        params.put("repairid", repairItemsId);
        mSubscription.add(MyWealthApi.getInstance().getMyWealthService().getProduct(params)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new SuscriberX<ProductBean>(this){
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
            @Override
            public void onNext(ProductBean productBean) {
                super.onNext(productBean);
                productName.setText(productBean.getObj().getRepairItems().getRepairName());
                productPrice.setText(productBean.getObj().getRepairItems().getPrice());
                productCompany.setText(productBean.getObj().getDept().getDeptName());
                productAddress.setText(productBean.getObj().getDept().getDeptAddress());
                productPhone.setText(productBean.getObj().getDept().getDeptPhone());
                productEmail.setText(productBean.getObj().getDept().getDeptEmail());
            }
        }));
    }



}
