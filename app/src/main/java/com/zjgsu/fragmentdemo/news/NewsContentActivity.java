package com.zjgsu.fragmentdemo.news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zjgsu.fragmentdemo.R;

public class NewsContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        String newsTitle = getIntent().getStringExtra("news_title");
        String newsContent = getIntent().getStringExtra("news_content");

        if (newsTitle != null && newsContent != null) {
            // 静态加载，只能通过这种形式
            NewsContentFragment fragment = (NewsContentFragment) getSupportFragmentManager().
                    findFragmentById(R.id.newsContentFrag);
            fragment.refresh(newsTitle, newsContent);
        }
    }
}
