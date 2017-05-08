package com.abc.marilyzj.activity.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.abc.marilyzj.R;
import com.abc.marilyzj.util.StatusBarCompat;
import com.abc.marilyzj.widgets.LoadingDialog;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by acer on 2016/8/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected CompositeSubscription mSubscription = new CompositeSubscription();
    protected Toolbar toolbar;
    protected TextView customTitle;
    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        StatusBarCompat.compat(this);
        ActivityCollector.addActivity(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        customTitle = (TextView) findViewById(R.id.toolbar_title);
        setupToolbar();
    }

    protected void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    protected void setTitle(String title) {
        if (customTitle != null) {
            customTitle.setText(title);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unSubscribe();
        ActivityCollector.removeActivity(this);
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
            mLoadingDialog.show(getSupportFragmentManager(), "loading");
        }
    }

    public void closeLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isAdded()) {
            mLoadingDialog.dismiss();
        }
    }




}

