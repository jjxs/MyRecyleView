package com.example.myrecyleview.cell;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.myrecyleview.R;
import com.example.myrecyleview.model.DetailEntry;
import com.squareup.picasso.Picasso;
import com.zhouwei.rvadapterlib.base.RVBaseCell;
import com.zhouwei.rvadapterlib.base.RVBaseViewHolder;


/**
 * Created by Fangzheng on 2017/9/20.
 */

public class TestCell extends RVBaseCell<DetailEntry>{
    public TestCell(DetailEntry detailEntry) {
        super(detailEntry);
    }

    @Override
    public int getItemType() {
        return 0;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RVBaseViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_item_layout,null));
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int i) {
        Picasso.with(holder.getItemView().getContext()).load(mData.imageUrl).into(holder.getImageView(R.id.grid_image));
        holder.setText(R.id.grid_title,mData.title);
    }
}
