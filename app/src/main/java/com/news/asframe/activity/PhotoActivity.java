package com.news.asframe.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.news.asframe.R;
import com.news.asframe.utils.Bitmap.ImageLoader;
import com.news.asframe.utils.Conteact;
import com.news.asframe.utils.http.Net;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PhotoActivity extends AppCompatActivity {
    private Context context;
    private ImageLoader image;

    private String TAG = "PhotoActivity";
    @InjectView(R.id.photo_1)
    ImageView photo1;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (Net.SUCCESS == msg.what) {
                Log.e(TAG, "我看看");
                Bitmap bitmap = (Bitmap) msg.obj;
                photo1.setImageBitmap(bitmap);
            } else {
                // TLUtil.showToast(getApplicationContext(), "错误");
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.inject(this);
        image = new ImageLoader(context);
        context = this;
        initView();
    }

    private void initView() {
        image.DisplayImage(Conteact.URL_1, photo1);
        //  Net.sendHttpBitmap(context, handler, "photo_image", "加载中。。。", Conteact.URL_1);

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
