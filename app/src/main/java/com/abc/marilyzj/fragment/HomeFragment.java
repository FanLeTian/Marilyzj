package com.abc.marilyzj.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.LoginActivity;
import com.abc.marilyzj.fragment.base.BaseFragment;
import com.abc.marilyzj.util.SharedPreferencesUtil;
import com.abc.marilyzj.widgets.recycler.OnItemClickListener;
import com.aspsine.irecyclerview.OnRefreshListener;

/**
 * Created by acer on 2017/4/27.
 */

public class HomeFragment extends BaseFragment implements OnItemClickListener, OnRefreshListener {


    private EditText etSerach;
    private Button btSerach;


    @Override
    protected int getLayoutRes() {
        return R.layout.home_layout;
    }

    @Override
    public void onItemClick(int position, Object o, View v) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    protected void initData() {
        super.initData();
        if (SharedPreferencesUtil.getPrefString(getContext(), "USER_ID", "").equals("")) {
            Intent intent = new Intent(getContext(), LoginActivity.class);
            getContext().startActivity(intent);
        }
        etSerach = (EditText) mContentView.findViewById(R.id.et_search);
        etSerach.clearFocus();
        btSerach = (Button) mContentView.findViewById(R.id.bt_serch);
        btSerach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
