package com.example.newproject.common.http;

import android.app.Activity;
import android.content.Context;

import com.example.newproject.common.toast.ToastLoginUtil;
import com.example.newproject.common.toast.ToastUtil;
import com.example.newproject.common.util.UserInfoUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 创建时间： 2018/1/9.
 * 编写人：韩宇
 * 电话微信同：18698802347
 * 返回请求是否成功
 */
public class Status {
    /**
     * 访问成功
     *
     * @param jsonObject
     * @return
     */
    public static boolean status(JSONObject jsonObject) {
        if ("200".equals(text(jsonObject, "code") + "")) {
            return true;
        }
        return false;
    }

    /**
     * 解析String
     *
     * @param jsonObject
     * @param text
     * @return
     */
    public static String text(JSONObject jsonObject, String text) {
        try {
            return jsonObject.getString(text);
        } catch (JSONException e) {
            return null + "";
        }
    }

    public static String textnull(JSONObject jsonObject, String text) {
        try {
            return jsonObject.getString(text);
        } catch (JSONException e) {
            return "";
        }
    }

    /**
     * @param jsonObject
     * @param text
     * @return
     */
    public static JSONArray jsonArray(JSONObject jsonObject, String text) {
        try {
            return jsonObject.getJSONArray(text);
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 解析object
     *
     * @param jsonObject
     * @param text
     * @return
     */
    public static JSONObject object(JSONObject jsonObject, String text) {
        try {
            return jsonObject.getJSONObject(text);
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 用户失效
     *
     * @param jsonObject
     * @return
     */
    public static boolean userNull(JSONObject jsonObject) {
        try {
            if ("016".equals(jsonObject
                    .getString("code"))) {
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 错误信息回弹
     *
     * @param context
     * @param jsonObject
     * @return
     */
    public static boolean fail(Context context, JSONObject jsonObject) {
        if ("201".equals(Status.textnull(jsonObject, "code"))) {
            UserInfoUtil.getInstance().setUser(null, context);
            ToastLoginUtil.getInstance((Activity) context).setMessage(textnull(jsonObject, "msg"));
        } else {
            ToastUtil.getInstance(context).setMessage(text(jsonObject, "msg") + "");
        }
        return false;
    }
}
