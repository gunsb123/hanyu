package com.example.newproject.common.base;

import android.os.Bundle;

//import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.newproject.R;
import com.example.newproject.common.util.SettingTextColorUtil;
import com.example.newproject.common.util.StatusBarUtil;
import com.example.newproject.common.util.SubmitUtil;


/**
 * 创建时间： 2018/1/9.
 * 编写人：韩宇
 * 电话微信同：18698802347
 * baseActivity
 */
public abstract class BaseActivity1 extends FragmentActivity {
    protected View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        StatusBarUtil.transparencyBar(this);
        StatusBarUtil.StatusBarLightMode(this);
        MutualApplication.getInstance().addActivity(this);
        initView();
        initData();
    }

    /**
     * 返回键的监听
     *
     * @param view
     */
    public void onBack(View view) {
        if (!SubmitUtil.clickTes()){
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 设置标题文字设置
     *
     * @param titles
     */
    public void setTitle(String titles) {
        TextView textView = findViewById(R.id.head_title);
        if (textView != null) {
            textView.setText(titles);
        }
    }

    public void setText6_0() {
        LinearLayout state_view = findViewById(R.id.view_state);
        SettingTextColorUtil.text6_0(state_view, this);
    }
//    public void setText6_01() {
//        LinearLayout state_view = findViewById(R.id.view_state1);
//        SettingTextColorUtil.text6_0(state_view, this);
//    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();

    /**
     * @return 显示的内容
     */
    public View getView() {
        view = View.inflate(this, getLayoutId(), null);
        return view;
    }
}

