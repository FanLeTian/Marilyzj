package com.abc.marilyzj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.base.BackBaseActivity;
import com.abc.marilyzj.beans.RegisterBean;
import com.abc.marilyzj.netutil.MyWealthApi;
import com.abc.marilyzj.netutil.SuscriberX;
import com.abc.marilyzj.util.SharedPreferencesUtil;
import com.abc.marilyzj.util.ToastUtil;

import java.util.HashMap;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by acer on 2017/4/27.
 */

public class RegisterActivity extends BackBaseActivity implements View.OnClickListener{


    private EditText account;
    private EditText passWord;
    private Button register;
    private String loginName;
    private String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        setTitle("注册");
        initView();
    }

    private void initView() {
        account = (EditText) findViewById(R.id.phone);
        passWord = (EditText) findViewById(R.id.eregister_password);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        loginName = account.getText().toString();
        password = passWord.getText().toString();
        switch (v.getId()) {
            case R.id.register:
                if (TextUtils.isEmpty(loginName)) {
                    ToastUtil.showToast(this, "账号不能为空");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    ToastUtil.showToast(this, "密码不能为空");
                    return;
                }
                toRigister(loginName, password);
                break;
        }
    }

    private void toRigister(final String loginName, String password) {
        HashMap<String, String> params = new HashMap<>();
        params.put("loginname", loginName);
        params.put("password", password);
        mSubscription.add( MyWealthApi.getInstance().getMyWealthService().getRegister(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SuscriberX<RegisterBean>(RegisterActivity.this){
                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        super.onNext(registerBean);
                        Log.e("FanLEtian", registerBean.getCode());
                        switch (registerBean.getCode()) {
                            case "0":
                                ToastUtil.showToast(RegisterActivity.this, registerBean.getMsg());
                                SharedPreferencesUtil.setPrefString(RegisterActivity.this, "USER_ID", registerBean.getObj().getUserId());
                                SharedPreferencesUtil.setPrefString(RegisterActivity.this, "USER_NAME", registerBean.getObj().getLoginName());
                                finish();
                                Intent intent = new Intent(RegisterActivity.this, SetPersonInfoActivity.class);
                                startActivity(intent);
                                break;
                            case "1":
                                ToastUtil.showToast(RegisterActivity.this, registerBean.getMsg());
                                break;
                            case "2":
                                ToastUtil.showToast(RegisterActivity.this, registerBean.getMsg());
                                break;
                            default:
                                ToastUtil.showToast(RegisterActivity.this, registerBean.getMsg());
                                break;
                        }
                    }
                }));
    }
}
