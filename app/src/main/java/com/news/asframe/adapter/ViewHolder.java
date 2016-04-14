package com.news.asframe.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/4/12.
 * 项目名称：Asframe
 * 类描述：
 * 创建人：longshihan
 * 创建时间：2016/4/12 13:24
 * 修改人：Administrator
 * 修改时间：2016/4/12 13:24
 * 修改备注：
 * 邮箱： longshihan@163.com
 */
public class ViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    public ViewHolder(Context context, ViewGroup parent, int LayoutId, int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(LayoutId, parent, false);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int LayoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, LayoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition =position;
            return holder;
        }
    }

    /**
    * 通过viewId获取控件
    *
    * */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }
}
