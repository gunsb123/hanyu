package com.example.newproject.common.toast;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;

//import com.example.administrator.design.design.login.view.LoginActivity;

/**
 * 作者：韩宇 on 2017/6/21 0021 13:50
 * 邮箱：18698802347@163.com
 * QQ：1760010478
 * 功能：toast显示时间倒计时
 */
public class ToastTimer extends CountDownTimer {
    private Dialog dialog;
    private Context mContext;
    private int type;

    public ToastTimer(long millisInFuture, long countDownInterval, Dialog dialog, int type) {
        super(millisInFuture, countDownInterval);
        this.dialog = dialog;
        this.type = type;

    }

    public ToastTimer(long millisInFuture, long countDownInterval, Dialog dialog, Context mContext, int type) {
        super(millisInFuture, countDownInterval);
        this.dialog = dialog;
        this.mContext = mContext;
        this.type = type;
    }

    @Override
    public void onFinish() {
        dialog.dismiss();
        if (type == 2) {
            if (mContext!=null){
                ((Activity) mContext).finish();
            }
        }else if (type==3){
            if (mContext!=null){
//                mContext.startActivity(new Intent(mContext, LoginActivity.class));
            }
        }
    }

    @Override
    public void onTick(long arg0) {
    }
}
