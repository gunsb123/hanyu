package com.example.newproject.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.newproject.R;


/**
 * 创建时间： 2018/1/9.
 * 编写人：韩宇
 * 电话微信同：18698802347
 * 头像更换对话框
 */
public class MineAvatarDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private TextView photograph;//拍照
    private TextView photoAlbum;//相册
    private TextView collOff;//相册
    private BcakChooose mBackChoose;

    public MineAvatarDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(
                R.layout.photo_select_dialog, null);
        setContentView(view);
        getWindow().getAttributes().width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setGravity(Gravity.BOTTOM);
        photograph = (TextView) findViewById(R.id.dialog_avatar_photograph);
        photoAlbum = (TextView) findViewById(R.id.dialog_avatar_photoAlbum);
        collOff = (TextView) findViewById(R.id.dialog_avatar_cancel);
        collOff.setOnClickListener(this);
        photograph.setOnClickListener(this);
        photoAlbum.setOnClickListener(this);
    }


    public void getChoose(BcakChooose c) {
        this.mBackChoose = c;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_avatar_photograph:
                mBackChoose.isChoose(false);
                dismiss();

                break;
            case R.id.dialog_avatar_photoAlbum:
                mBackChoose.isChoose(true);
                dismiss();
                break;
            default:
                dismiss();

        }
    }

    public interface BcakChooose {
        public void isChoose(boolean choose);

    }

    public interface BcakChoooseView {
        public void isChoose(boolean choose);

    }
}
