package com.abc.marilyzj.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.abc.marilyzj.R;
import com.abc.marilyzj.beans.HomeBean;
import com.abc.marilyzj.widgets.recycler.OnItemClickListener;

/**
 * Created by acer on 2017/5/2.
 */

public class HomeAdapter extends BaseRecyclerAdapter<HomeBean.ObjBean.ReslutBean> {

    private OnItemClickListener<HomeBean.ObjBean.ReslutBean> onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener<HomeBean.ObjBean.ReslutBean> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder) holder).itemContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position, getItem(position), v);
            }
        });
        HomeBean.ObjBean.ReslutBean objbean = getItem(position);
        ((ViewHolder) holder).repairName.setText(objbean.getRepairName());
        ((ViewHolder) holder).deptName.setText(objbean.getDeptName());
        ((ViewHolder) holder).price.setText(objbean.getRepairItemsId());
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout itemContent;
        TextView repairName;
        TextView deptName;
        TextView price;


        private ViewHolder(View itemView) {
            super(itemView);
            itemContent = (RelativeLayout) itemView.findViewById(R.id.itemContent);
            repairName = (TextView) itemView.findViewById(R.id.repairName);
            deptName = (TextView) itemView.findViewById(R.id.deptName);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }
}
