package com.zjgsu.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.zjgsu.fragmentdemo.news.NewsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                startActivity(new Intent(this, IndexActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(this, Index2Activity.class));
                break;
            case R.id.btn_3:
                startActivity(new Intent(this, Index3Activity.class));
                break;
            case R.id.btn_4:
                startActivity(new Intent(this, NewsActivity.class));
                break;
            case R.id.btn_5:
                startActivity(new Intent(this, Index4Activity.class));
                break;
        }
    }
}
