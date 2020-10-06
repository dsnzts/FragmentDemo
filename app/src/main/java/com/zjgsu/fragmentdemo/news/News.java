package com.zjgsu.fragmentdemo.news;

/*
 *  项目名:    FragmentDemo
 *  包名:      com.zjgsu.fragmentdemo.news
 *  文件名:    News
 *  创建者:    Geely
 *  创建时间:  2020/10/6 15:16
 *  描述:      Desp
 */
public class News {

    private String title;
    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
