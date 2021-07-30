package com.example.newproject.common.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.newproject.R;


/**
 * 创建时间：2018/3/1
 * 电话微信同：18698802347
 * 编写人：韩宇
 * 等待界面
 */
public class Loading extends ProgressDialog {

    public Loading(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getContext());
    }

    private void init(Context context) {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.loading);//loading的xml文件
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);
    }

    @Override
    public void show() {//开启
        super.show();
    }

    @Override
    public void dismiss() {//关闭
        super.dismiss();
    }
}
