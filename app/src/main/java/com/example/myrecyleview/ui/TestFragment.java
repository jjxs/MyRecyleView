package com.example.myrecyleview.ui;

import android.view.LayoutInflater;
import android.view.View;

import com.example.myrecyleview.DataMocker;
import com.example.myrecyleview.R;
import com.example.myrecyleview.cell.BannerCell;
import com.example.myrecyleview.cell.ImageCell;
import com.example.myrecyleview.cell.TestCell;
import com.example.myrecyleview.cell.TextCell;
import com.example.myrecyleview.model.DetailEntry;
import com.example.myrecyleview.model.Entry;
import com.zhouwei.rvadapterlib.base.Cell;
import com.zhouwei.rvadapterlib.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.example.myrecyleview.DataMocker.mockData;
import static com.example.myrecyleview.DataMocker.mockMoreData;
import static com.example.myrecyleview.DataMocker.mockStaggerData;

/**
 * Created by Fangzheng on 2017/9/19.
 */

public class TestFragment extends AbsBaseFragment<DetailEntry>{


    @Override
    public void onRecyclerViewInitialized() {
        mBaseAdapter.setData(getCells(mockStaggerData()));
    }

    @Override
    public void onPullRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    protected List<Cell> getCells(List<DetailEntry> list) {
        List<Cell> cells = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            cells.add(new TestCell(list.get(i)));
        }
        return cells;
    }
}
