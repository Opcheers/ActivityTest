package com.example.firstcode.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstcode.utils.ActivityManager;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName());//知晓当前是哪一个活动实例
        ActivityManager.addActivity(this);

        setContentView(getView());
        initView();
        initEvent();
    }

    public abstract int getView();

    public void initView() {}

    public void initEvent() {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.removeActivity(this);
    }
}
