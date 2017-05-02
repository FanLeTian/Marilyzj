package com.abc.marilyzj.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.base.BackBaseActivity;
import com.abc.marilyzj.beans.SetInfoBean;
import com.abc.marilyzj.netutil.MyWealthApi;
import com.abc.marilyzj.netutil.SuscriberX;
import com.abc.marilyzj.util.SharedPreferencesUtil;
import com.abc.marilyzj.util.ToastUtil;

import java.util.HashMap;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by acer on 2017/4/28.
 */

public class SetPersonInfoActivity extends BackBaseActivity {


    private EditText loginName;
    private EditText userName;
    private EditText sexE;
    private EditText phoneNumber;
    private EditText e_mail;
    private EditText remarkE;
    private Button submit;

    private String username;
    private String sex;
    private String phone;
    private String email;
    private String remark;
    private String userId;
    private String loginname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_person_info_layout);
        setTitle("完善个人信息");
        initView();
        userId = SharedPreferencesUtil.getPrefString(SetPersonInfoActivity.this, "USER_ID", "");
        Log.e("FanLeTian", userId);
    }

    private void initView() {
        loginName = (EditText) findViewById(R.id.login_name);
        userName = (EditText) findViewById(R.id.real_name);
        sexE = (EditText) findViewById(R.id.sex_et);
        phoneNumber = (EditText) findViewById(R.id.phone_number);
        e_mail = (EditText) findViewById(R.id.e_mail);
        remarkE = (EditText) findViewById(R.id.remark);
        submit = (Button) findViewById(R.id.bt_enter_info);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginname = loginName.getText().toString();
                username = userName.getText().toString();
                sex = sexE.getText().toString();
                phone = phoneNumber.getText().toString();
                email = e_mail.getText().toString();
                remark = remarkE.getText().toString();
                setPersonInfo();
            }
        });
    }



    private void setPersonInfo() {
        HashMap<String, String> params = new HashMap<>();
        params.put("loginname", loginname);
        params.put("userid", userId);
        params.put("username", username);
        params.put("sex", sex);
        params.put("phone", phone);
        params.put("email", email);
        params.put("remark", remark);
        mSubscription.add(MyWealthApi.getInstance().getMyWealthService().setPersonInfo(params)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new SuscriberX<SetInfoBean>(SetPersonInfoActivity.this){
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(SetInfoBean setInfoBean) {
                super.onNext(setInfoBean);
                switch (setInfoBean.getCode()) {
                    case "0":
                        ToastUtil.showToast(SetPersonInfoActivity.this, setInfoBean.getMsg());
                        finish();
                        break;
                    default:
                        ToastUtil.showToast(SetPersonInfoActivity.this, setInfoBean.getMsg());
                }
            }
        }));

    }


}
