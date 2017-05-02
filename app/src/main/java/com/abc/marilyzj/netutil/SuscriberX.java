package com.abc.marilyzj.netutil;


import android.content.Context;

import com.abc.marilyzj.R;
import com.abc.marilyzj.beans.StatusBean;
import com.abc.marilyzj.util.ToastUtil;

import rx.Subscriber;



public class SuscriberX<T extends StatusBean> extends Subscriber<T> {
    private Context context;

    public SuscriberX(Context context) {
        super();
        this.context = context;
    }

    public SuscriberX() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        ToastUtil.showToast(context,context.getResources().getString(R.string.net_error_msg));
    }

    @Override
    public void onNext(T t) {

    }
}
