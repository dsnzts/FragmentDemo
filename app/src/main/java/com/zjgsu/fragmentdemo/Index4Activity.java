package com.zjgsu.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.zjgsu.fragmentdemo.fragment.NewItemFragment;
import com.zjgsu.fragmentdemo.fragment.ToDoListFragment;

import java.util.ArrayList;

public class Index4Activity extends AppCompatActivity implements NewItemFragment.OnNewItemAddListener {

    /**
     * ListView
     * Adapter
     * data
     */

    // 数据源
    private ArrayList<String> data;
    // 适配器
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index4);

        // 初始化
        data = new ArrayList<>();

        // 构建适配器
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        // 在 Activity 中获得其管辖的 Fragment
        ToDoListFragment fragment = (ToDoListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_to_do_list);
        if (fragment != null) {
            fragment.setListAdapter(adapter);
        }
    }

    @Override
    public void newItemAdded(String content) {
        // 构建数据源
        data.add(content);
        adapter.notifyDataSetChanged();
    }
}
