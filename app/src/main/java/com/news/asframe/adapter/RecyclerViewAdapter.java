package com.news.asframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.news.asframe.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/11.
 * 项目名称：AsFrame
 * 类描述：
 * 创建人：longshihan
 * 创建时间：2016/4/11 15:42
 * 修改人：Administrator
 * 修改时间：2016/4/11 15:42
 * 修改备注：
 * 邮箱： longshihan@163.com
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private List<String> mDatas;
    private Context context;

    private List<Integer> mHeights;

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public RecyclerViewAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(context);
        mHeights = new ArrayList<Integer>();
        for (int i = 0; i < mDatas.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //创建ViewHolder
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_simple, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    //绑定viewHolder
    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.MyViewHolder holder, final int position) {
        ViewGroup.LayoutParams layoutParams = holder.textView.getLayoutParams();
        layoutParams.height = mHeights.get(position);
        holder.textView.setLayoutParams(layoutParams);
        holder.textView.setText(mDatas.get(position));

        if (mOnItemClickLitener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
            //longClick
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    removeData(pos);
                    return false;
                }
            });
        }
    }

    public void addData(int position) {
        mDatas.add(position, "Insert One");
        mHeights.add( (int) (100 + Math.random() * 300));
        notifyItemInserted(position);
    }

    public void removeData(int pos) {
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.id_recyclerView);
        }
    }
}
