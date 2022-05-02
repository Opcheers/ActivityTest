package com.example.firstcode.ui.activity;

import android.content.Intent;
import android.widget.TextView;

import com.example.firstcode.R;
import com.example.firstcode.base.BaseActivity;
import com.example.firstcode.domain.PersonParcelable;
import com.example.firstcode.domain.PersonSerializable;

public class DataTransActivity extends BaseActivity {

    @Override
    public int getView() {
        return R.layout.activity_data_trans;
    }

    @Override
    public void initView() {
        TextView name = this.findViewById(R.id.name);
        TextView age = this.findViewById(R.id.age);
        Intent intent = getIntent();
        //PersonSerializable person = (PersonSerializable) intent.getSerializableExtra("person");
        PersonParcelable person = intent.getParcelableExtra("person");
        name.setText(person.getName());
        age.setText(person.getAge()+"");
    }
}
