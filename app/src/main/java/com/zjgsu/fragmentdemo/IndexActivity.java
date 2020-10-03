package com.zjgsu.fragmentdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.zjgsu.fragmentdemo.fragment.BottomFragment;
import com.zjgsu.fragmentdemo.fragment.CenterFragment;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        /*
          动态添加 Fragment 到 Activity 中
          要涉及到两个操作对象
          FragmentManager 和
          FragmentTransaction
         */
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layout_center, new CenterFragment());
        fragmentTransaction.add(R.id.layout_bottom, new BottomFragment());
        fragmentTransaction.commit();
    }
}
