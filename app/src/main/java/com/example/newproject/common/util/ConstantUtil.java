package com.example.newproject.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * 作者：韩宇 on 2017/6/22 0022 10:25
 * 邮箱：18698802347@163.com
 * QQ：1760010478
 * 功能：常量工具
 */
public class ConstantUtil {
    public final static String APP_ID = "wx0e12fc69d0d46df8";//微信APPID
    public final static String userInfoName = "design";//个人信息表名
    public static String tiao = "0";
    public static  String phone="";

    /**
     * @param context
     * @return
     */
    public static SharedPreferences setSharedPreferences(Context context) {
        return context.getSharedPreferences(userInfoName, Context.MODE_PRIVATE);
    }


    /**
     * 搜索取消按钮的显示与隐藏
     *
     * @param editText
     * @param imageView
     */
    public static void searchDelete(final EditText editText, final ImageView imageView) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.toString().length() > 0) {
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 0) {
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
    }

    /**
     * 186****2347格式的电话
     *
     * @param Mobphone
     * @return
     */
    public static String mobPhone(String Mobphone) {
        if (Mobphone.length() == 11) {
            return Mobphone.substring(0, 3) + "****" + Mobphone.substring(7, 11);
        } else {
            return Mobphone;
        }
    }
}
