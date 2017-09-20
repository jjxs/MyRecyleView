package com.example.myrecyleview;

import android.view.LayoutInflater;
import android.view.View;

import com.example.myrecyleview.cell.BannerCell;
import com.example.myrecyleview.cell.ImageCell;
import com.example.myrecyleview.cell.TextCell;
import com.example.myrecyleview.model.Entry;
import com.zhouwei.rvadapterlib.base.Cell;
import com.zhouwei.rvadapterlib.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.R.attr.entries;
import static com.example.myrecyleview.DataMocker.mockData;
import static com.example.myrecyleview.DataMocker.mockMoreData;

/**
 * Created by Fangzheng on 2017/9/19.
 */

public class MainFragment extends AbsBaseFragment<Entry>{

    @Override
    public View addToolbar() {
        //设置标题
        View toolbar = LayoutInflater.from(getContext()).inflate(R.layout.title_bar_layout,null);
        return toolbar;
    }

    @Override
    public void onRecyclerViewInitialized() {
        setColorSchemeColors(R.color.colorAccent);
        loadData();
    }

    private void loadData() {
        View loadingView = LayoutInflater.from(getContext()).inflate(R.layout.manu_loading_layout,null);
        mBaseAdapter.showLoading(loadingView);
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mBaseAdapter.hideLoading();
                mBaseAdapter.addAll(getCells(mockData()));
            }
        },2000);
    }

    @Override
    public void onPullRefresh() {
        //下拉刷新回调
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                setRefreshing(false);
            }
        },2000);

    }

    @Override
    public void onLoadMore() {
        //上拉加载回调
        loadMore();
    }

    private void loadMore() {

        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoadMore();
                mBaseAdapter.addAll(getCells(mockMoreData()));

            }
        },10000);
    }

    @Override
    protected List<Cell> getCells(List<Entry> entries) {
        //根据实体生成Cell
        List<Cell> cells = new ArrayList<>();
        cells.add(new BannerCell(Arrays.asList(DataMocker.images)));
        for (int i=0;i<entries.size();i++){
            Entry entry = entries.get(i);
            if(entry.type == Entry.TYPE_IMAGE){
                cells.add(new ImageCell(entry));
            }else{
                cells.add(new TextCell(entry));
            }
        }
        return cells;
    }
}
