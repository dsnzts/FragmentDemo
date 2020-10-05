package com.zjgsu.fragmentdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zjgsu.fragmentdemo.R;

/*
 *  项目名:    FragmentDemo
 *  包名:      com.zjgsu.fragmentdemo.fragment
 *  文件名:    BottomFragment
 *  创建者:    Geely
 *  创建时间:  2020/10/3 20:46
 *  描述:      Desp
 */
public class FirstFragment extends Fragment {

    private static final String TAG = "FragmentTAG";

    /**
     * Fragment 连接到它的父 Activity 时调用
     * @param context
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Log.e(TAG, "FirstFragment onAttach");
    }

    /**
     * 创建 Fragment 并初始化
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e(TAG, "FirstFragment onCreate");
    }

    /**
     * 加载一个 View
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Log.e(TAG, "FirstFragment onCreateView");
        return view;
    }

    /**
     * 当 Fragment 和所属的 Activity 都被创建时调用
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.e(TAG, "FirstFragment onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.e(TAG, "FirstFragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e(TAG, "FirstFragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.e(TAG, "FirstFragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.e(TAG, "FirstFragment onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.e(TAG, "FirstFragment onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e(TAG, "FirstFragment onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.e(TAG, "FirstFragment onDetach");
    }
}
