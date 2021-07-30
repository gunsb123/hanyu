package com.example.newproject.common.util;

/**
 * 创建时间：2018/3/21
 * 电话微信同：18698802347
 * 编写人：韩宇
 * 限制重复提交
 */
public class SubmitUtil {
    public static long lastClickTime = 0L;
    public final static int FAST_CLICK_DELAY_TIME = 1000;  // 快速点击间隔

    /**
     * 防止重复提交
     */
    public static boolean clickTes() {
        if (System.currentTimeMillis() - lastClickTime < FAST_CLICK_DELAY_TIME) {
            return true;
        }
        lastClickTime = System.currentTimeMillis();
        return false;
    }
}
