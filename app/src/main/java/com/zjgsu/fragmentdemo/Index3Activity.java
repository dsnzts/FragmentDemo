package com.zjgsu.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zjgsu.fragmentdemo.fragment.BottomFragment;
import com.zjgsu.fragmentdemo.fragment.CheckFragment;

public class Index3Activity extends AppCompatActivity {

    private CheckBox cbIsEngineer;

    private CheckFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index3);

        fragment = new CheckFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();

        initView();
    }

    private void initView() {
        cbIsEngineer = findViewById(R.id.cb_is_engineer);

        cbIsEngineer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (fragment != null) {
                        TextView tvResult = fragment.getView().findViewById(R.id.tv_result);
                        tvResult.setText("是程序员");
                    }
                } else {
                    if (fragment != null) {
                        TextView tvResult = fragment.getView().findViewById(R.id.tv_result);
                        tvResult.setText("不是程序员");
                    }
                }
            }
        });
    }
}
