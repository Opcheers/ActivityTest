package com.example.firstcode.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;

import com.example.firstcode.R;
import com.example.firstcode.base.BaseActivity;

public class SecondActivity extends BaseActivity {

    private Button mButton;
    private Button mToThirdBtn;

    @Override
    public int getView() {
        return R.layout.activity_second;
    }

    @Override
    public void initView() {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        mButton = this.findViewById(R.id.button);
        mToThirdBtn = this.findViewById(R.id.toThirdBtn);
    }

    @Override
    public void initEvent() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        mToThirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    public static void actionStart(Context context, String data1, String data2){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
