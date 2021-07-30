package com.example.newproject.common.util;


import android.content.Context;

import com.example.newproject.common.toast.ToastUtil;

/**
 * 创建时间：2018/3/9
 * 电话微信同：18698802347
 * 编写人：韩宇
 * 提示语工具类
 */
public class HintUtil {
    public static void network_error(Context context) {
        ToastUtil.getInstance(context).setMessage("网络出问题啦！");
    }
    public static void searchnull(Context context) {
        ToastUtil.getInstance(context).setMessage("请输入要搜索的关键词！");
    }
    /**
     * 已清除缓存
     * @param context
     */
    public static void clearcache(Context context) {
        ToastUtil.getInstance(context).setMessage("已清除缓存！");
    }
}
