package com.example.newproject.common.timer;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * 作者：韩宇 on 2017/6/21 0021 13:50
 * 邮箱：18698802347@163.com
 * QQ：1760010478
 * 功能：获取验证码倒计时
 */
public class TimerCode extends CountDownTimer {
    private Context context;
    private TextView textView;

    public TimerCode(long millisInFuture, long countDownInterval, TextView textView,Context context) {
        super(millisInFuture, countDownInterval);
        this.textView = textView;
    }

    public TimerCode(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onFinish() {
        textView.setClickable(true);
        textView.setText("获取验证码");
    }

    @Override
    public void onTick(long arg0) {
        textView.setClickable(false);
        textView.setText(arg0 / 1000 + "s");
    }

}
