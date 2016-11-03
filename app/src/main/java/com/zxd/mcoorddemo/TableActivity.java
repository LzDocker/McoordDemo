package com.zxd.mcoorddemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TableActivity extends Activity {

    public RecyclerView recycleview;
    private List<String> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        initData();
        recycleview = (RecyclerView) findViewById(R.id.recycleview);

      //  recycleview.setLayoutManager(new LinearLayoutManager(this));
       // recycleview.addItemDecoration(new DividerItemDecoration(this,
              //  DividerItemDecoration.VERTICAL_LIT));


        recycleview.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        recycleview.addItemDecoration(new DividerGridItemDecoration(this));
     //   recycleview.setAdapter(new Myadapter());

        StaggeredAdapter adapter = new StaggeredAdapter(this,datas);
        recycleview.setAdapter(adapter);

    }

    private void initData() {
        datas = new ArrayList();

        for (int i = 'A'; i < 'z'; i++)
        {
            datas.add("" + (char) i);
        }
    }

    public class Myadapter extends  RecyclerView.Adapter<Myadapter.MyviewHolder>{


        //用于每个item的布局
        private LayoutInflater mInflater;
        private Context mContext;
        private List<String> mDatas;
        //瀑布流控制高度
        private List<Integer> mHeights;

        @Override
        public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            MyviewHolder holder = new MyviewHolder(LayoutInflater.from(
                    TableActivity.this).inflate(R.layout.item_view, parent,
                    false));
            return holder;

        }

        @Override
        public void onBindViewHolder(MyviewHolder holder, int position) {

          holder.textView.setText(datas.get(position));

        }
        @Override
        public int getItemCount() {
            return datas.size();
        }

        class  MyviewHolder extends RecyclerView.ViewHolder{

            TextView textView;
            public MyviewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.tv_num);
            }
        }
    }

}
