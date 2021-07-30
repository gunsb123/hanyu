package com.example.newproject.common.http.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.newproject.common.base.MutualApplication;
import com.example.newproject.common.http.MyStringRequest;
import com.example.newproject.common.util.UserInfoUtil;

import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/7 0007.
 * 公用model待请求头和不带请求头的
 */

public class Model {
    public void volley(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, final JSONObject jsonObject, String url) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, listener, errorListener) {
            @Override
            public String getBodyContentType() {
                return "application/json;charset=UTF-8";
            }
        };
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(50000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        jsonObjectRequest.setTag("volley");
        MutualApplication.getRequestQueue().add(jsonObjectRequest);
    }

    public void volley(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, final JSONObject jsonObject, String url, String tag) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, listener, errorListener) {
            @Override
            public String getBodyContentType() {
                return "application/json;charset=UTF-8";
            }
        };
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(50000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        jsonObjectRequest.setTag(tag);
        MutualApplication.getRequestQueue().add(jsonObjectRequest);
    }

    public void volley(Response.Listener<String> listener, Response.ErrorListener errorListener, String url, String tag) {
        MyStringRequest jsonObjectRequest = new MyStringRequest(Request.Method.POST, url, listener, errorListener);
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(50000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        jsonObjectRequest.setTag(tag);
        MutualApplication.getRequestQueue().add(jsonObjectRequest);
    }


    public void volleyHeader(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, final JSONObject jsonObject, String url) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, listener, errorListener) {
            @Override
            public String getBodyContentType() {
                return "application/json;charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> headers = new LinkedHashMap<>();
                headers.put("token", UserInfoUtil.getInstance().getUser(MutualApplication.getInstance()) != null ? UserInfoUtil.getInstance().getUser(MutualApplication.getInstance()).getToken() : "");
                return headers;
            }
        };
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(50000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        jsonObjectRequest.setTag("volley");
        MutualApplication.getRequestQueue().add(jsonObjectRequest);
    }
}
