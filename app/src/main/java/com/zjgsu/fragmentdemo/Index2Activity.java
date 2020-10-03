package com.zjgsu.fragmentdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.zjgsu.fragmentdemo.fragment.FirstFragment;
import com.zjgsu.fragmentdemo.fragment.SecondFragment;

public class Index2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btnReplace;
    private Button btnRemove;

    private FirstFragment f1;
    private SecondFragment f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index2);

        initView();
    }

    // 初始化 View
    private void initView() {
        btnReplace = findViewById(R.id.btn_replace);
        btnRemove = findViewById(R.id.btn_remove);

        btnReplace.setOnClickListener(this);
        btnRemove.setOnClickListener(this);

        initFragment();
    }

    // 初始化 Fragment
    private void initFragment() {
        f1 = new FirstFragment();
        f2 = new SecondFragment();

        addFragment();
    }

    // 添加 Fragment
    private void addFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.layout_container, f1)
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_replace:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.layout_container, f2)
                        // 点击 返回键 可以回到原来的 Fragment
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_remove:
                getSupportFragmentManager()
                        .beginTransaction()
                        .remove(f2)
                        .commit();
                break;
        }
    }
}
