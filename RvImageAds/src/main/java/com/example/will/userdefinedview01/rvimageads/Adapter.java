package com.example.will.userdefinedview01.rvimageads;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imooc.rvimageads.R;

import java.util.List;

/**
 * Created by will on 2017/9/28.
 * <p>
 * https://mp.weixin.qq.com/s/BHbmtfUzg3XTaGrGcX5-bg
 * 竖向滑动的时候,图片显示山下部分
 */


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private List<String> dates;

    public Adapter(Context context, List<String> dates) {
        this.context = context;
        this.dates = dates;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(View.inflate(context, R.layout.item, null));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (position > 0 && position % 7 == 0) {
            holder.mIdTvTitle.setVisibility(View.GONE);
            holder.mIdTvDesc.setVisibility(View.GONE);
            holder.mIdIvAd.setVisibility(View.VISIBLE);
        } else {
            holder.mIdTvTitle.setVisibility(View.VISIBLE);
            holder.mIdTvDesc.setVisibility(View.VISIBLE);
            holder.mIdIvAd.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return dates == null ? 0 : dates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mIdTvTitle;
        private TextView mIdTvDesc;
        private AdImageViewVersion1 mIdIvAd;

        public ViewHolder(View itemView) {
            super(itemView);
            mIdTvTitle = (TextView) itemView.findViewById(R.id.id_tv_title);
            mIdTvDesc = (TextView) itemView.findViewById(R.id.id_tv_desc);
            mIdIvAd = (AdImageViewVersion1) itemView.findViewById(R.id.id_iv_ad);
        }
    }
}
