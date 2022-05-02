package com.example.firstcode.ui.layout;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.firstcode.R;


public class TitleLayout extends LinearLayout {

    public TitleLayout(Context context, AttributeSet attrs) {

        super(context);
        //动态加载标题栏布局
        LayoutInflater.from(context).inflate(R.layout.title, this);
        Button back = this.findViewById(R.id.back);
        Button edit = this.findViewById(R.id.edit);

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });

        edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "edit", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
