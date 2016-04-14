package com.news.asframe;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.news.asframe.activity.BaseActivity;
import com.news.asframe.activity.PhotoActivity;
import com.news.asframe.activity.RecyActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.btn_1)
    Button btn1;
    @InjectView(R.id.btn_2)
    Button btn2;
    @InjectView(R.id.btn_3)
    Button btn3;
    @InjectView(R.id.btn_4)
    Button btn4;
    @InjectView(R.id.btn_5)
    Button btn5;
    @InjectView(R.id.btn_6)
    Button btn6;
    @InjectView(R.id.btn_7)
    Button btn7;
    @InjectView(R.id.btn_8)
    Button btn8;
    @InjectView(R.id.btn_9)
    Button btn9;
    @InjectView(R.id.btn_10)
    Button btn10;

  /*  private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };*/

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    protected int getLayout() {

        return R.layout.activity_main;
    }


    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_10})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                Intent intent = new Intent(MainActivity.this, PhotoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_2:
                initIntent(this, RecyActivity.class);
                break;
            case R.id.btn_3:
                break;
            case R.id.btn_4:
                break;
            case R.id.btn_5:
                break;
            case R.id.btn_6:
                break;
            case R.id.btn_7:
                break;
            case R.id.btn_8:
                break;
            case R.id.btn_9:
                break;
            case R.id.btn_10:
                break;
        }
    }

    public void initIntent(Context context, Class class2) {
        Intent intent = new Intent(context, class2);
        startActivity(intent);
    }

}
