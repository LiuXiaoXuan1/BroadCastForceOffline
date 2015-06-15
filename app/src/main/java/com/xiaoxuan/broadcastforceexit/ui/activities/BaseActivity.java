package com.xiaoxuan.broadcastforceexit.ui.activities;

import android.app.Activity;
import android.os.Bundle;

import com.xiaoxuan.broadcastforceexit.entities.ActivityCollector;

/**
 * Created by xiaoxuan on 2015/6/15.
 * 此类BaseActivity作为所有类的父类
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
