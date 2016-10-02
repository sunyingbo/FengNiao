package com.sqw.fnsy.fengniao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sqw.fnsy.fengniao.R;
import com.sqw.fnsy.fengniao.bean.Choiceness;
import com.sqw.fnsy.fengniao.bean.ZiXunBean;

import java.util.List;

/**
 * Created by SUN on 2016/10/1.
 */

public class MyListViewAdapter extends BaseAdapter {

    private Context context = null;
    private List<ZiXunBean> totalList = null;
    private int type;

    public MyListViewAdapter(Context context, List<ZiXunBean> totalList, int type) {
        this.context = context;
        this.totalList = totalList;
        this.type = type;
    }

    @Override
    public int getCount() {
        return totalList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_zx, parent, false);
            myViewHolder = new MyViewHolder();
            myViewHolder.img = (ImageView) convertView.findViewById(R.id.img_item_listview_zx);
            myViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_itemtitle_listview_zx);
            myViewHolder.tvDate = (TextView) convertView.findViewById(R.id.tv_itemday_listview_zx);
            myViewHolder.tvPingLun = (TextView) convertView.findViewById(R.id.tv_itempl_listview_zx);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        if (type == 0) {
            Choiceness choiceness = (Choiceness) totalList.get(position);
            Picasso.with(context).load(choiceness.getPic_url())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(myViewHolder.img);
            myViewHolder.tvTitle.setText(choiceness.getTitle());
            myViewHolder.tvDate.setText(choiceness.getDate());
            myViewHolder.tvPingLun.setText(choiceness.getComments_num() + " 评论");
        } else {
            ZiXunBean ziXunBean = totalList.get(position);
            Picasso.with(context).load(ziXunBean.getPic_url())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(myViewHolder.img);
            myViewHolder.tvTitle.setText(ziXunBean.getTitle());
            myViewHolder.tvPingLun.setText(ziXunBean.getComments_num() + " 评论");
        }


        return convertView;
    }

    class MyViewHolder {
        private ImageView img;
        private TextView tvTitle;
        private TextView tvDate;
        private TextView tvPingLun;
    }

}
