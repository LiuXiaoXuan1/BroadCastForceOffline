package com.xiaoxuan.broadcastforceexit.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.xiaoxuan.broadcastforceexit.R;
import com.xiaoxuan.broadcastforceexit.utils.Tools;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by xiaoxuan on 2015/6/15.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @InjectView(R.id.account)
    EditText accoutEdit;
    @InjectView(R.id.password)
    EditText pwdEdit;
    @InjectView(R.id.login)
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.inject(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int item = view.getId();
        switch (item) {
            case R.id.login:
                String account = accoutEdit.getText().toString().trim();//对首部空字符导致用户名无效的处理
                String pwd = pwdEdit.getText().toString();
                //如果账号是admin且密码是123456，就默认登录成功
                if (account.equals("admin") && pwd.equals("123456")) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Tools.ToolsToast(this,"用户名或密码无效");
                }
                break;
        }
    }
}
