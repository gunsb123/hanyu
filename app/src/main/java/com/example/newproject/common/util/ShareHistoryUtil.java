package com.example.newproject.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：韩宇 on 2017/6/21 0021 13:50
 * 邮箱：18698802347@163.com
 * QQ：1760010478
 * 功能：保存工具
 */
public class ShareHistoryUtil {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static volatile ShareHistoryUtil instence = null;

    private ShareHistoryUtil(Context context) {
        preferences = ConstantUtil.setSharedPreferences(context);
        editor = preferences.edit();
    }

    public static final ShareHistoryUtil getInstance(Context context) {
        if (instence == null) {
            synchronized (ShareHistoryUtil.class) {
                if (instence == null) {
                    instence = new ShareHistoryUtil(context);
                }
            }
        }
        return instence;
    }

    public List<String> getSearchHistory() {
        List<String> history = new ArrayList<String>();
        String his = preferences.getString("search_history", "");
        if (TextUtils.isEmpty(his)) {
            return history;
        }
        String[] array = his.split(";");
        for (int i = 0; i < array.length; i++) {
            history.add(array[i]);
        }
        return history;
    }

    public void addSearchHistory(String key) {
        if (TextUtils.isEmpty(key)) {
            return;
        }
        List<String> pre = getSearchHistory();
        if (pre.contains(key)) {
            pre.remove(key);
        }
        pre.add(0, key);
        StringBuffer newhis = new StringBuffer();
        for (int i = 0; i < pre.size(); i++) {
            newhis.append(pre.get(i) + ";");
        }
        editor.putString("search_history", newhis.toString());
        editor.commit();
    }

    public void deleteSearchHistory() {
        editor.putString("search_history", "");
        editor.commit();
    }
}
