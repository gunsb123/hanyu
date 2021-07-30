package com.example.newproject.common.toast;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.newproject.R;


/**
 * 作者：韩宇 on 2017/6/21 0021 13:50
 * 邮箱：18698802347@163.com
 * QQ：1760010478
 * 功能：不带finish的toast
 */
public class ToastLoginUtil extends Dialog {
    private static volatile ToastLoginUtil mInstance = null;
    private Activity mContext;
    private Dialog mDialog;
    private TextView mTipsText;

    public ToastLoginUtil(Activity context) {
        super(context, R.style.myStyle);
        this.mContext = context;
        mDialog = new Dialog(mContext, R.style.Dialogs);
        mDialog.setCancelable(true);
        initView();
        initData();
    }

    public static ToastLoginUtil getInstance(Activity context) {
        if (context != null) {
            mInstance = new ToastLoginUtil(context);
        }
        return mInstance;
    }

    private void initView() {
        mDialog.setContentView(R.layout.custom_toast);
        mTipsText = (TextView) mDialog.findViewById(R.id.toastText);
    }

    private void initData() {
        Window dialogWindow = mDialog.getWindow();
        WindowManager.LayoutParams winLayoutParams = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER);
        winLayoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        winLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogWindow.setAttributes(winLayoutParams);
        mDialog.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            dismiss();
                            break;
                    }
                }
                return false;
            }
        });
    }
    public void setMessage(CharSequence msg) {
        mTipsText.setText(msg);
        if (!mContext.isFinishing()){
            show();
        }
    }

    public void setMessage(int msg) {
        mTipsText.setText(msg);
        if (!mContext.isFinishing()){
            show();
        }
    }

    public void show() {
        if (!mContext.isFinishing()){
            mDialog.show();
            ToastTimer t = new ToastTimer(2000, 1000, mDialog, mContext, 3);
            t.start();
        }
    }
}