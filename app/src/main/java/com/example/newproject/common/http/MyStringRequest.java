package com.example.newproject.common.http;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;

/**
 * 创建时间：2018/1/30
 * 电话微信同：18698802347
 * 编写人：韩宇
 * 自定义网络请求框架
 */
public class MyStringRequest extends StringRequest {

    public MyStringRequest(int method, String url, Response.Listener<String> listener,
                           Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    /**
     * 重写以解决乱码问题
     */
    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String str = null;
        try {
            str = new String(response.data, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Response.success(str,
                HttpHeaderParser.parseCacheHeaders(response));
    }
}
