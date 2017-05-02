package com.abc.marilyzj.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.AccountMannagerActivity;
import com.abc.marilyzj.activity.MainActivity;
import com.abc.marilyzj.fragment.base.BaseFragment;
import com.abc.marilyzj.util.SharedPreferencesUtil;
import com.abc.marilyzj.util.ToastUtil;

/**
 * Created by acer on 2017/4/27.
 */

public class AccountFragment extends BaseFragment implements View.OnClickListener{


    private TextView accountName;
    private View noCommit;
    private View noComplet;
    private View allOder;
    private View accountManager;
    private Button exit;



    @Override
    protected int getLayoutRes() {
        return R.layout.accout_layout;
    }

    @Override
    protected void initData() {
        super.initData();
        accountName = (TextView) mContentView.findViewById(R.id.account_name);
        accountName.setText(SharedPreferencesUtil.getPrefString(getContext(), "USER_NAME", ""));
        noCommit = mContentView.findViewById(R.id.no_submit_oder);
        noComplet = mContentView.findViewById(R.id.no_complet_oder);
        allOder = mContentView.findViewById(R.id.all_oder);
        accountManager = mContentView.findViewById(R.id.account_management);
        exit = (Button) mContentView.findViewById(R.id.exit);
        noCommit.setOnClickListener(this);
        noComplet.setOnClickListener(this);
        allOder.setOnClickListener(this);
        accountManager.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.no_submit_oder:
                break;
            case R.id.no_complet_oder:
                break;
            case R.id.all_oder:
                break;
            case R.id.account_management:
                Intent intent = new Intent(getContext(), AccountMannagerActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.exit:
                SharedPreferencesUtil.setPrefString(getContext(), "USER_NAME", "");
                SharedPreferencesUtil.setPrefString(getContext(), "USER_ID", "");
                ToastUtil.showToast(getContext(), "您已安全退出");
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.setTabSelection(0);
                break;

        }

    }
}
