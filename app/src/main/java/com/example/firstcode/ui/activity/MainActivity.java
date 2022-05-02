package com.example.firstcode.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.firstcode.R;
import com.example.firstcode.base.BaseActivity;
import com.example.firstcode.domain.PersonParcelable;
import com.example.firstcode.domain.PersonSerializable;

public class MainActivity extends BaseActivity {

    @Override
    public int getView() {
        return R.layout.activity_main;
    }

    /**
     * 让菜单显示出来
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 菜单相应事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1_1:
                Toast.makeText(MainActivity.this, "点击第1-1个菜单！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu1_2:
                Toast.makeText(MainActivity.this, "点击第1-2个菜单！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(MainActivity.this, "点击第二个菜单！", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    public void toSecondPager(View view) {
//        显式跳转
//        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//        startActivityForResult(intent, 1);

        SecondActivity.actionStart(MainActivity.this, "yxq", "yxqq");

    }

    public void toBaidu(View view) {
        //隐式跳转
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    public void dataTransBySerializable(View view){
        //以Serializable方式传递对象
        Intent intent = new Intent(MainActivity.this, DataTransActivity.class);
        PersonSerializable person = new PersonSerializable();
        person.setName("yxq dataTransBySerializable");
        person.setAge(18);
        intent.putExtra("person", person);
        startActivity(intent);
    }



    public void dataTransByParcelable(View view) {
        //以Parcelable方式传递对象
        Intent intent = new Intent(MainActivity.this, DataTransActivity.class);
        PersonParcelable person = new PersonParcelable();
        person.setName("yxq dataTransByParcelable");
        person.setAge(18);

        intent.putExtra("person", person);
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(this, "成功！", Toast.LENGTH_SHORT).show();
                } else if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "取消！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}