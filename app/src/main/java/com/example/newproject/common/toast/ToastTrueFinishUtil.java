package com.example.newproject.common.toast;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newproject.R;


/**
 * 作者：韩宇 on 2017/6/21 0021 13:50
 * 邮箱：18698802347@163.com
 * QQ：1760010478
 * 功能：带finish的toast
 */
public class ToastTrueFinishUtil extends Dialog {
    private static volatile ToastTrueFinishUtil mInstance = null;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTipsText;
    private ImageView imageView;
    private int path;

    public ToastTrueFinishUtil(Context context, int path) {
        super(context, R.style.myStyle);
        this.mContext = context;
        this.path=path;
        mDialog = new Dialog(mContext, R.style.Dialogs2);
        mDialog.setCancelable(false);
        initView();
        initData();
    }

    public static ToastTrueFinishUtil getInstance(Context context,int path) {
        mInstance = new ToastTrueFinishUtil(context,path);
        return mInstance;
    }

    private void initView() {
        mDialog.setContentView(R.layout.custom_toast_true);
        mTipsText = (TextView) mDialog.findViewById(R.id.toastText);
        imageView=mDialog.findViewById(R.id.path);
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
        imageView.setImageResource(path);
        show();
    }

    public void setMessage(int msg) {
        mTipsText.setText(msg);
        imageView.setImageResource(path);
        show();
    }

    public void show() {
        mDialog.show();
        ToastTimer t = new ToastTimer(1000, 1000, mDialog, mContext, 1);
        t.start();
    }
}