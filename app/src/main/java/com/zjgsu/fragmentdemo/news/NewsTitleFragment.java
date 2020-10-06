package com.zjgsu.fragmentdemo.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zjgsu.fragmentdemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *  项目名:    FragmentDemo
 *  包名:      com.zjgsu.fragmentdemo.news
 *  文件名:    NewsTitleFragment
 *  创建者:    Geely
 *  创建时间:  2020/10/6 14:50
 *  描述:      Desp
 */
public class NewsTitleFragment extends Fragment {

    private boolean isTwoPane = false;
    private RecyclerView newsTitleRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.news_title_frag, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        newsTitleRecyclerView = getActivity().findViewById(R.id.newsTitleRecyclerView);
        if (getActivity().findViewById(R.id.newsContentLayout) != null) {
            isTwoPane = true;
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsTitleRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews(), getActivity());
        newsTitleRecyclerView.setAdapter(adapter);
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            News news = new News("This is news title " + i, getRandomLengthString("This is news content" + i + "."));
            newsList.add(news);
        }
        return newsList;
    }

    private String getRandomLengthString(String str) {
        int n = new Random().nextInt(20) + 1;
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

        private List<News> newsList;
        private Context mContext;

        public NewsAdapter(List<News> newsList, Context mContext) {
            this.newsList = newsList;
            this.mContext = mContext;
        }

        @NonNull
        @Override
        public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.news_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = newsList.get(holder.getAdapterPosition());
                    if (isTwoPane) {
                        // 如果是双页模式，则刷新NewsContentFragment中的内容
                        NewsContentFragment fragment = (NewsContentFragment) getActivity().
                                getSupportFragmentManager().
                                findFragmentById(R.id.newsContentFrag);
                        fragment.refresh(news.getTitle(), news.getContent());
                    } else {
                        // 如果是单页模式，则直接启动NewsContentActivity
                        Intent intent = new Intent(getActivity(), NewsContentActivity.class);
                        intent.putExtra("news_title", news.getTitle());
                        intent.putExtra("news_content", news.getContent());
                        startActivity(intent);
                    }
                }
            });

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            News news = newsList.get(position);
            holder.newsTitle.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return newsList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView newsTitle;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                newsTitle = itemView.findViewById(R.id.newsTitle);
            }
        }
    }
}
