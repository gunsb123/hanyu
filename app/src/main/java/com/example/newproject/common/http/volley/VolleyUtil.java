package com.example.newproject.common.http.volley;

import android.content.Context;

import com.example.newproject.common.util.UserInfoUtil;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2019/12/7 0007.
 * body请求公用参数
 */

public class VolleyUtil {
    public static JSONObject bodyToken(Context context) {
        JSONObject jsonObject = new JSONObject();
        if (UserInfoUtil.getInstance().getUser(context) != null) {
            try {
                jsonObject.put("token", UserInfoUtil.getInstance().getUser(context).getToken());

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }

    public static JSONObject body(Context context) {
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }
}
