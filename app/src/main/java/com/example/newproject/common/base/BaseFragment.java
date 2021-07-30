package com.example.newproject.common.base;

import android.app.Fragment;
import android.os.Bundle;
//import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.newproject.R;
import com.example.newproject.common.util.StatusBarUtil;
import com.example.newproject.common.util.SubmitUtil;


/**
 * 作者：韩宇 on 2017/6/21 0021 13:50
 * 邮箱：18698802347@163.com
 * QQ：1760010478
 * 功能：fragment继承的base
 */

public abstract class BaseFragment extends Fragment {
    protected View view;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), null);
        initView(inflater,view);
        StatusBarUtil.StatusBarLightMode(getActivity());
        StatusBarUtil.transparencyBar(getActivity());
        initData();
        return view;
    }
    /**
     * 返回键的监听
     *
     * @param view
     */
    public void onBack(View view) {
        if (!SubmitUtil.clickTes()){
            getActivity().finish();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        StatusBarUtil.StatusBarLightMode(getActivity());
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden==false){
            StatusBarUtil.StatusBarLightMode(getActivity());
        }
    }

    /**
     * 设置标题文字设置
     *
     * @param titles
     */
    public void setTitle(String titles) {
        TextView textView = (TextView) view.findViewById(R.id.head_title);
        if (textView != null) {
            textView.setText(titles);
        }
    }
    protected abstract void initData();
    protected abstract void initView(LayoutInflater inflater, View view);
    protected abstract int getLayoutId();
}
