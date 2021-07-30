package com.example.newproject.view;

import android.widget.TextView;

import com.example.newproject.R;
import com.example.newproject.common.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class One extends BaseActivity {
    @BindView(R.id.text)
    TextView textView;
    @Override
    protected void initData() {
     textView.setText("韩语");
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
