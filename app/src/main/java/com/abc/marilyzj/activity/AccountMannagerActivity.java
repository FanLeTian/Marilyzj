package com.abc.marilyzj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.abc.marilyzj.R;
import com.abc.marilyzj.activity.base.BackBaseActivity;
import com.abc.marilyzj.util.SharedPreferencesUtil;

/**
 * Created by acer on 2017/5/1.
 */

public class AccountMannagerActivity extends BackBaseActivity {


    private TextView name;
    private View completInfo;
    private View resetPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_mamager_laout);
        setTitle("账户管理");
        initView();
    }

    private void initView() {
        name = (TextView) findViewById(R.id.name);
        completInfo = findViewById(R.id.to_prove);
        resetPass = findViewById(R.id.change_login);
        name.setText(SharedPreferencesUtil.getPrefString(this, "USER_NAME", ""));
        completInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountMannagerActivity.this, SetPersonInfoActivity.class);
                startActivity(intent);
            }
        });
        resetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountMannagerActivity.this, FindPassWordActivity.class);
                startActivity(intent);
            }
        });
    }
}
