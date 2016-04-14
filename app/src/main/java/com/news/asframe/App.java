package com.news.asframe;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Stack;

/**
 * Created by Administrator on 2016/4/11.
 * 项目名称：AsFrame
 * 类描述：Application
 * 创建人：longshihan
 * 创建时间：2016/4/11 10:07
 * 修改人：Administrator
 * 修改时间：2016/4/11 10:07
 * 修改备注：
 * 邮箱： longshihan@163.com
 */
public class App extends Application {
    private static App _instance;
    public static Context applicationContext;
    private static App application;
    public static RequestQueue queues;
    /*
        * 初始化TAG
        * */
    private static String TAG = App.class.getName();

    /*Activity堆*/
    private Stack<AppCompatActivity> activityStack = new Stack<AppCompatActivity>();

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
        applicationContext = this;
        queues = Volley.newRequestQueue(getApplicationContext());
        //初始化数据的地方
        //。。。。。。。。。

        printAppParameter();
    }

    /*打印出一些app的参数*/
    private void printAppParameter() {
        Log.d(TAG, "OS : " + Build.VERSION.RELEASE + " ( " + Build.VERSION.SDK_INT + " )");

    }

    public void addActivity(final AppCompatActivity curAT) {
        if (null == activityStack) {
            activityStack = new Stack<AppCompatActivity>();
        }
        activityStack.add(curAT);
    }

    public void removeActivity(final AppCompatActivity curAT) {
        if (null == activityStack) {
            activityStack = new Stack<AppCompatActivity>();
        }
        activityStack.remove(curAT);
    }

    //获取最后一个Activity
    public AppCompatActivity currentActivity() {
        if (activityStack == null || activityStack.isEmpty()) {
            return null;
        }
        AppCompatActivity activity = activityStack.lastElement();
        return activity;
    }

    //返回寨内Activity的总数
    public int howManyActivities() {
        return activityStack.size();
    }

    //关闭所有Activity
    public void finishAllActivities() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 结束当前Activity（栈顶Activity）
     */
    public void finishActivity() {
        AppCompatActivity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity(重载)
     */
    public void finishActivity(AppCompatActivity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    //简化吐司
    public void showMyToast(final AppCompatActivity curAT, String text) {

        Toast.makeText(curAT, text, Toast.LENGTH_SHORT);

    }

    public void exit() {
        finishAllActivities();

        android.os.Process.killProcess(android.os.Process.myPid());

        System.exit(0);

    }

    //封装全局的context
    public static App getApplication() {
        return application;
    }

    //封装单例
    public static App instance() {
        return _instance;
    }

    //封装全局请求的volley
    public static RequestQueue getHttpQueues() {
        return queues;
    }
}
