package com.zjgsu.fragmentdemo.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zjgsu.fragmentdemo.R;

/*
 *  项目名:    FragmentDemo
 *  包名:      com.zjgsu.fragmentdemo.fragment
 *  文件名:    CheckFragment
 *  创建者:    Geely
 *  创建时间:  2020/10/5 20:24
 *  描述:      Desp
 */
public class CheckFragment extends Fragment {

    private Button btnJudge;

    private Toast mToast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check, container, false);
        btnJudge = view.findViewById(R.id.btn_judge);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 在 Fragment 中去获得它所属的 Activity 的控件
        final CheckBox cbIsEngineer = getActivity().findViewById(R.id.cb_is_engineer);

        btnJudge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbIsEngineer != null) {
                    if (cbIsEngineer.isChecked()) {
                        mToast = Toast.makeText(getActivity(), "checkBox 被选中了", Toast.LENGTH_SHORT);
                        mToast.setGravity(Gravity.CENTER, 0, 0);
                        mToast.show();
                    } else {
                        mToast = Toast.makeText(getActivity(), "checkBox 没有被选中", Toast.LENGTH_SHORT);
                        mToast.setGravity(Gravity.CENTER, 0, 0);
                        mToast.show();
                    }
                }
            }
        });
    }
}
