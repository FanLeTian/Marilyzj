package com.abc.marilyzj.fragment.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abc.marilyzj.widgets.LoadingDialog;

import rx.subscriptions.CompositeSubscription;



public abstract class BaseFragment extends Fragment {
    protected CompositeSubscription mSubscription = new CompositeSubscription();
    protected View mContentView;
    private LoadingDialog mLoadingDialog;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mContentView == null) {
            initView(inflater, container, savedInstanceState);
            initData();
        } else {
            ViewGroup parent = (ViewGroup) mContentView.getParent();
            if (parent != null) {
                parent.removeView(mContentView);
            }
        }
        return mContentView;
    }

    protected void initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContentView = inflater.inflate(getLayoutRes(), container, false);
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected void initData() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unSubscribe();
    }

    protected void unSubscribe() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

    public void showLoadingDialog() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new LoadingDialog.Builder()
                    .setMessage("正在加载中...")
                    .create();
        }
        if (!mLoadingDialog.isAdded()) {
            mLoadingDialog.show(getActivity().getSupportFragmentManager(), "loading");
        }
    }

    public void closeLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isAdded()) {
            mLoadingDialog.dismiss();
        }
    }
}
