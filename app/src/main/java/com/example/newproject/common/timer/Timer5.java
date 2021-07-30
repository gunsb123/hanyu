package com.example.newproject.common.timer;

import android.os.CountDownTimer;
import android.widget.TextView;

import com.example.newproject.R;

/**
 * 作者：韩宇 on 2017/6/21 0021 13:50
 * 邮箱：18698802347@163.com
 * QQ：1760010478
 * 功能：获取验证码倒计时
 */
public class Timer5 extends CountDownTimer {
    private TextView textView;
    private String text;

    public Timer5(long millisInFuture, long countDownInterval, TextView textView, String text) {
        super(millisInFuture, countDownInterval);
        this.textView = textView;
        this.text=text;
    }

    public Timer5(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onFinish() {
        textView.setClickable(true);
        textView.setBackgroundResource(R.drawable.green_4);
        textView.setText(text);
    }

    @Override
    public void onTick(long arg0) {
        textView.setClickable(false);
        textView.setBackgroundResource(R.drawable.gray_gray_4);
        textView.setText(arg0 / 1000 + "秒后可再次点击！");
    }

}
