package com.example.firstcode.ui.activity;


import android.view.View;
import android.widget.Button;

import com.example.firstcode.R;
import com.example.firstcode.base.BaseActivity;
import com.example.firstcode.utils.ActivityManager;

public class ThirdActivity extends BaseActivity {

    private Button mExitBtn;

    @Override
    public int getView() {
        return R.layout.activity_third;
    }

    @Override
    public void initView() {
        mExitBtn = this.findViewById(R.id.exit);
    }

    @Override
    public void initEvent() {
        mExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityManager.finishAll();
                //ζζθΏη¨
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }
}
