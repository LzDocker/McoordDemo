package com.zxd.mcoorddemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/10/26.
 */
public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredMyViewHoder> {
    //用于每个item的布局
    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;
    //瀑布流控制高度
    private List<Integer> mHeights;

    @Override
    //创建ViewHoler
    public StaggeredMyViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        //item布局
        View view = mInflater.inflate(R.layout.item_view, parent, false);
        //传入item布局
        StaggeredMyViewHoder staggeredMyViewHoder = new StaggeredMyViewHoder(view);
        return staggeredMyViewHoder;
    }

    @Override
    //绑定ViewHolder
    public void onBindViewHolder(StaggeredMyViewHoder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = mHeights.get(position);
        holder.itemView.setLayoutParams(layoutParams);
        holder.textView.setText(mDatas.get(position));
    }


    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public StaggeredAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);
        mHeights = new ArrayList<Integer>();
        for (int i = 0;i<mDatas.size();i++){
            mHeights.add((int) (100+Math.random()*300));
        }
    }
}

class StaggeredMyViewHoder extends RecyclerView.ViewHolder {
    TextView textView;

    public StaggeredMyViewHoder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.tv_num);
    }
}
