package com.abc.marilyzj.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.base.BackBaseActivity;
import com.abc.marilyzj.beans.CreateOderBean;
import com.abc.marilyzj.netutil.MyWealthApi;
import com.abc.marilyzj.netutil.SuscriberX;
import com.abc.marilyzj.util.SharedPreferencesUtil;
import com.abc.marilyzj.util.ToastUtil;

import java.util.HashMap;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by acer on 2017/5/16.
 */

public class ReservationActivity extends BackBaseActivity {


    private EditText etPhone;
    private EditText etName;
    private EditText etEmail;
    private EditText etDate;
    private EditText etRemark;
    private Button reservation;
    private String userId;
    private String productId;
    private String phone;
    private String email;
    private String name;
    private String date;
    private String remark;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_layout);
        setTitle(getIntent().getStringExtra("title"));
        userId = SharedPreferencesUtil.getPrefString(this, "USER_ID", "");
        productId = getIntent().getStringExtra("id");
        initView();
    }

    private void initView() {
        etPhone = (EditText) findViewById(R.id.mobie);
        etName = (EditText) findViewById(R.id.name);
        etEmail = (EditText) findViewById(R.id.et_youxiang);
        etDate = (EditText) findViewById(R.id.et_time);
        etRemark = (EditText) findViewById(R.id.et_remark);
        reservation = (Button) findViewById(R.id.reservation);
        reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = etPhone.getText().toString();
                name = etName.getText().toString();
                email = etEmail.getText().toString();
                date = etDate.getText().toString();
                remark = etRemark.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    ToastUtil.showToast(ReservationActivity.this, "电话不能为空");
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    ToastUtil.showToast(ReservationActivity.this, "姓名不能为空");
                    return;
                }
                if (TextUtils.isEmpty(date)) {
                    ToastUtil.showToast(ReservationActivity.this, "日期不能为空");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    ToastUtil.showToast(ReservationActivity.this, "邮箱不能为空");
                    return;
                }
                creatOderRequest();
            }
        });
    }

    private void creatOderRequest() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userid", userId);
        params.put("id", productId);
        params.put("date", date);
        params.put("username", name);
        params.put("phone", phone);
        params.put("email", email);
        params.put("remark", remark);
        mSubscription.add(MyWealthApi.getInstance().getMyWealthService().creatOder(params)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new SuscriberX<CreateOderBean>(this){
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(CreateOderBean createOderBean) {
                super.onNext(createOderBean);
                switch (createOderBean.getCode()) {
                    case "0":
                        ToastUtil.showToast(ReservationActivity.this, "成功");
                        finish();
                        finish();
                        break;
                }
            }
        }));

    }


}
