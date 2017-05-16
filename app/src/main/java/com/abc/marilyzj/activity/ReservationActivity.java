package com.abc.marilyzj.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.base.BackBaseActivity;

/**
 * Created by acer on 2017/5/16.
 */

public class ReservationActivity extends BackBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_layout);
        setTitle(getIntent().getStringExtra("title"));
    }
}
