package com.abc.marilyzj.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.base.BackBaseActivity;
import com.abc.marilyzj.beans.ResetPassBean;
import com.abc.marilyzj.beans.YanZhengBean;
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

public class FindPassWordActivity extends BackBaseActivity implements View.OnClickListener{

    private EditText e_mail;
    private EditText passWord;
    private EditText code;
    private Button submit;
    private Button send;
    private String email;
    private String password;
    private String yanzhengma;
    private String userId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_pass_layout);
        setTitle("找回密码");
        initView();
        userId = SharedPreferencesUtil.getPrefString(FindPassWordActivity.this, "USER_ID", "");

    }

    private void initView() {
        e_mail = (EditText) findViewById(R.id.find_accout);
        passWord = (EditText) findViewById(R.id.new_pass);
        code = (EditText) findViewById(R.id.find_yanzeng_edit);
        send = (Button) findViewById(R.id.send_yanzheng);
        submit = (Button) findViewById(R.id.find_submit);
        send.setOnClickListener(this);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        yanzhengma = code.getText().toString();
        email = e_mail.getText().toString();
        password = passWord.getText().toString();
        switch (v.getId()) {
            case R.id.send_yanzheng:
                if (TextUtils.isEmpty(email)) {
                    ToastUtil.showToast(this, "邮箱不能为空");
                    return;
                }
                sendCode();
                break;
            case R.id.find_submit:
                if (TextUtils.isEmpty(password)) {
                    ToastUtil.showToast(this, "请输入新的密码");
                    return;
                }
                if (TextUtils.isEmpty(yanzhengma)) {
                    ToastUtil.showToast(this, "验证码不能为空");
                } else {
                    if (yanzhengma.equals(SharedPreferencesUtil.getPrefString(FindPassWordActivity.this, "CODE", ""))){
                        requestFind();
                    }
                }
                break;
        }
    }

    private void requestFind() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userid", userId);
        params.put("password", password);
        mSubscription.add(MyWealthApi.getInstance().getMyWealthService().getResetPass(params)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new SuscriberX<ResetPassBean>(FindPassWordActivity.this){
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(ResetPassBean resetPassBean) {
                super.onNext(resetPassBean);
                switch (resetPassBean.getCode()) {
                    case "0":
                        ToastUtil.showToast(FindPassWordActivity.this, resetPassBean.getMsg());
                        finish();
                        break;
                    default:
                        ToastUtil.showToast(FindPassWordActivity.this, resetPassBean.getMsg());
                        break;
                }
            }
        }));
    }

    private void sendCode() {
        HashMap<String, String> params = new HashMap<>();
        params.put("email", email);
        mSubscription.add(MyWealthApi.getInstance().getMyWealthService().getYanZheng(params)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new SuscriberX<YanZhengBean>(FindPassWordActivity.this)
        {
            @Override
            public void onCompleted() {
                super.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(YanZhengBean yanZhengBean) {
                super.onNext(yanZhengBean);
                switch (yanZhengBean.getCode()) {
                    case "0":
                        ToastUtil.showToast(FindPassWordActivity.this, yanZhengBean.getMsg());
                        SharedPreferencesUtil.setPrefString(FindPassWordActivity.this, "CODE", yanZhengBean.getMsg());
                        break;
                    default:
                        ToastUtil.showToast(FindPassWordActivity.this, yanZhengBean.getMsg());
                }
            }
        }));

    }
}
