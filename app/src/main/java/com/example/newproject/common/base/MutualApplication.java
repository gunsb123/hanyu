package com.example.newproject.common.base;

import android.app.Activity;
import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.LinkedList;
import java.util.List;

;


/**
 * 创建时间： 2018/1/9.
 * 编写人：韩宇
 * 电话微信同：18698802347
 * application
 */
public class MutualApplication extends Application {
    private List<Activity> mList = new LinkedList();
    private static MutualApplication application;
    public static RequestQueue requestQueue;
//    public static IWXAPI mWXapi;

    public synchronized static MutualApplication getInstance() {
        if (null == application) {
            application = new MutualApplication();
        }
        return application;
    }

    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    public void exit() {
        try {
            for (Activity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        requestQueue = Volley.newRequestQueue(this);
//        mWXapi = WXAPIFactory.createWXAPI(this, null);
//        // 将该app注册到微信
//        mWXapi.registerApp(ConstantUtil.APP_ID);
    }


    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
