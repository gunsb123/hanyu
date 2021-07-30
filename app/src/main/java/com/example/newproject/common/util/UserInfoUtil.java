package com.example.newproject.common.util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * 作者：韩宇 on 2017/6/22 0022 10:25
 * 邮箱：18698802347@163.com
 * QQ：1760010478
 * 功能：用户信息储存
 */
public class UserInfoUtil {
    private UserBean user = null;
    private static volatile UserInfoUtil mInstance = null;
    private SharedPreferences sh;

    public static final UserInfoUtil getInstance() {
        if (mInstance == null) {
            synchronized (UserInfoUtil.class) {
                if (mInstance == null) {
                    mInstance = new UserInfoUtil();
                }
            }
        }
        return mInstance;
    }

    public UserBean getUser(Context context) {
        if (context != null) {
            sh = ConstantUtil.setSharedPreferences(context);
            if ("have".equals(sh.getString("id", "0"))) {
                UserBean storeMessageBean = new UserBean();
                storeMessageBean.setUid(sh.getString("uid", "uid"));
                storeMessageBean.setRandomId(sh.getString("randomId", "randomId"));
                storeMessageBean.setNickname(sh.getString("nickname", "nickname"));
                storeMessageBean.setPath(sh.getString("path", "path"));
                storeMessageBean.setToken(sh.getString("token", "token"));
                user = storeMessageBean;
                return user;
            }
        }
        return null;
    }

    public void setUser(UserBean user, Context context) {
        this.user = user;
        if (context != null) {
            sh = ConstantUtil.setSharedPreferences(context);
            SharedPreferences.Editor editor = sh.edit();
            if (user == null) {
                editor.putString("id", "null");
                editor.commit();
            } else {
                editor.putString("uid", user.getUid());
                editor.putString("nickname", user.getNickname());
                editor.putString("randomId", user.getRandomId());
                editor.putString("path", user.getPath());
                editor.putString("token", user.getToken());
                editor.putString("id", "have");
                editor.commit();
            }
        }
    }

    public void setLanguage(Context context, String type) {
        if (context != null) {
            sh = ConstantUtil.setSharedPreferences(context);
            SharedPreferences.Editor editor = sh.edit();
            editor.putString("language", type);
            editor.commit();
        }
    }

    public String getLanguage(Context context) {
        if (context != null) {
            sh = ConstantUtil.setSharedPreferences(context);
            return sh.getString("language", "zh");
        }
        return null;
    }
}
