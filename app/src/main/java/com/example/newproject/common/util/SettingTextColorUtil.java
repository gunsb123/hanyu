package com.example.newproject.common.util;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 创建时间：2018/3/31
 * 电话微信同：18698802347
 * 编写人：韩宇
 * 状态栏问题
 */
public class SettingTextColorUtil {
    public static void text6_0(View view, Context context) {
        int statusBarHeight2 = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusBarHeight2 = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) view.getLayoutParams();
        lp.height = statusBarHeight2;//lp.height=LayoutParams.WRAP_CONTENT;
        view.setLayoutParams(lp);
    }
}
