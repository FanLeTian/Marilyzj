package com.abc.marilyzj.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.abc.marilyzj.R;
import com.abc.marilyzj.beans.OderListBean;
import com.abc.marilyzj.widgets.recycler.OnItemClickListener;

/**
 * Created by acer on 2017/5/16.
 */

public class OderAdapter extends BaseRecyclerAdapter<OderListBean.ObjBeanX.ObjBean.ReslutBean> {

    private OnItemClickListener<OderListBean.ObjBeanX.ObjBean.ReslutBean> onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener<OderListBean.ObjBeanX.ObjBean.ReslutBean> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public OderAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.oder_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ((ViewHolder) holder).itemContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position, getItem(position), v);
            }
        });
        OderListBean.ObjBeanX.ObjBean.ReslutBean objbean = getItem(position);
        ((ViewHolder) holder).repairName.setText(objbean.getRepairItems().getRepairName());
        ((ViewHolder) holder).oderName.setText(objbean.getOrder().getOrderName());
        ((ViewHolder) holder).oderPrice.setText(objbean.getOrder().getPrice() + "");
        if (objbean.getOrder().getPayStatus().equals("1")) {
            ((ViewHolder) holder).status.setText("待提交");
        } else {
            ((ViewHolder) holder).status.setText("待完成");
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout itemContent;
        TextView oderName;
        TextView oderPrice;
        TextView repairName;
        TextView status;


        private ViewHolder(View itemView) {
            super(itemView);
            itemContent = (RelativeLayout) itemView.findViewById(R.id.oder_itemcontent);
            oderName = (TextView) itemView.findViewById(R.id.oder_name);
            oderPrice = (TextView) itemView.findViewById(R.id.my_oder_price);
            repairName = (TextView) itemView.findViewById(R.id.product_name);
            status = (TextView) itemView.findViewById(R.id.paystaus);
        }
    }
}

