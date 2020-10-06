package com.zjgsu.fragmentdemo.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zjgsu.fragmentdemo.R;

/*
 *  项目名:    FragmentDemo
 *  包名:      com.zjgsu.fragmentdemo.news
 *  文件名:    NewsContentFragment
 *  创建者:    Geely
 *  创建时间:  2020/10/6 14:51
 *  描述:      Desp
 */
public class NewsContentFragment extends Fragment {

    private LinearLayout contentLayout;
    private TextView newsTitle;
    private TextView newsContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.news_content_frag, container, false);
        contentLayout = view.findViewById(R.id.contentLayout);
        newsTitle = view.findViewById(R.id.newsTitle);
        newsContent = view.findViewById(R.id.newsContent);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void refresh(String title, String content) {
        contentLayout.setVisibility(View.VISIBLE);
        newsTitle.setText(title);
        newsContent.setText(content);
    }
}
