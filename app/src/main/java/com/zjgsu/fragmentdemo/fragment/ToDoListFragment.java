package com.zjgsu.fragmentdemo.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

/*
 *  项目名:    FragmentDemo
 *  包名:      com.zjgsu.fragmentdemo.fragment
 *  文件名:    ToDoListFragment
 *  创建者:    Geely
 *  创建时间:  2020/10/6 20:50
 *  描述:      Desp
 */
public class ToDoListFragment extends ListFragment {

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast mToast = Toast.makeText(getActivity(), "第 " + (position + 1) + " 项被选中了.", Toast.LENGTH_SHORT);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }
}
