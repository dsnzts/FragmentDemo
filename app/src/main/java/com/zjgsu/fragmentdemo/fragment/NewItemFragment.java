package com.zjgsu.fragmentdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zjgsu.fragmentdemo.R;

/*
 *  项目名:    FragmentDemo
 *  包名:      com.zjgsu.fragmentdemo.fragment
 *  文件名:    NewsItemFragment
 *  创建者:    Geely
 *  创建时间:  2020/10/6 20:50
 *  描述:      Desp
 */
public class NewItemFragment extends Fragment {

    // Fragment 与 Activity 通信
    // Fragment 与 另外一个 Fragment 通信
    // 都应该依靠他们所附着的 Activity 来完成通信代码，而不是在 Fragment 直接获得这个引用来完成业务代码

    // 声明一个接口，定义你要向 Activity 传递的方法
    public interface OnNewItemAddListener {
        public void newItemAdded(String content);
    }

    // 声明一个接口引用变量
    private OnNewItemAddListener onNewItemAddListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // 要求该 Fragment 所附着的 Activity 必须实现这个方法
        onNewItemAddListener = (OnNewItemAddListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_item, container, false);
        final EditText newItem = view.findViewById(R.id.et_new_item);
        // 绑定按下操作
        newItem.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    // 判断回车键
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        String content = newItem.getText().toString();
                        onNewItemAddListener.newItemAdded(content);
                        newItem.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
        return view;
    }
}
