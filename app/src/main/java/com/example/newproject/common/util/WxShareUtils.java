package com.example.newproject.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import com.example.newproject.common.toast.ToastUtil;
//import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
//import com.tencent.mm.opensdk.modelmsg.WXImageObject;
//import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
//import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
//import com.tencent.mm.opensdk.openapi.IWXAPI;
//import com.tencent.mm.opensdk.openapi.WXAPIFactory;


/**
 * Created by Administrator on 2019/12/23 0023.
 */

public class WxShareUtils {
//    /**
//     * 分享网页类型至微信
//     *
//     * @param context 上下文
//     */
//    public static void shareWeb(Context context, String webUrl, String title, String desc, String imageUrl) {
//        IWXAPI wxapi = WXAPIFactory.createWXAPI(context, ConstantUtil.APP_ID);
//        if (!wxapi.isWXAppInstalled()) {
//            ToastUtil.getInstance(context).setMessage("您还没有安装微信");
//            return;
//        }
//        WXWebpageObject webpageObject = new WXWebpageObject();
//        webpageObject.webpageUrl = webUrl;
//        WXMediaMessage msg = new WXMediaMessage(webpageObject);
//        msg.title = title;
//        msg.description = desc;
//        Bitmap thumbBmp = BitMap.getInstance().returnBitMap(imageUrl);
//        msg.thumbData=PicUtils.bmpToByteArray(thumbBmp,32);
//        thumbBmp.recycle();
//        SendMessageToWX.Req req = new SendMessageToWX.Req();
//        req.transaction = "webpage";
//        req.message = msg;
//        req.scene = SendMessageToWX.Req.WXSceneSession;
//        wxapi.sendReq(req);
//    }
//
//    /**
//     * 分享图片类型至微信
//     *
//     * @param context 上下文
//     */
//    public static void shareImage(Context context, String imageUrl) {
//        IWXAPI wxapi = WXAPIFactory.createWXAPI(context, ConstantUtil.APP_ID);
//        if (!wxapi.isWXAppInstalled()) {
//            ToastUtil.getInstance(context).setMessage("您还没有安装微信");
//            return;
//        }
//        Bitmap bmp = BitMap.getInstance().returnBitMap(imageUrl);
//        WXImageObject imgObj = new WXImageObject(bmp);
//        bmp.recycle();
//        WXMediaMessage msg = new WXMediaMessage(imgObj);
//        SendMessageToWX.Req req = new SendMessageToWX.Req();
//        req.transaction = "webpage";
//        req.message = msg;
//        req.scene = SendMessageToWX.Req.WXSceneSession;
//        // 向微信发送请求
//        wxapi.sendReq(req);
//    }
//
//    /**
//     * 分享图片类型至微信
//     *
//     * @param context 上下文
//     */
//    public static void shareImage(Context context, View imageUrl) {
//        IWXAPI wxapi = WXAPIFactory.createWXAPI(context, ConstantUtil.APP_ID);
//        if (!wxapi.isWXAppInstalled()) {
//            ToastUtil.getInstance(context).setMessage("您还没有安装微信");
//            return;
//        }
//        Bitmap bmp = createBitmap(imageUrl);
//        WXImageObject imgObj = new WXImageObject(PicUtils.bmpToByteArray(bmp,10240));
//        bmp.recycle();
//        WXMediaMessage msg = new WXMediaMessage(imgObj);
//        SendMessageToWX.Req req = new SendMessageToWX.Req();
//        req.transaction = "webpage";
//        req.message = msg;
//        req.scene = SendMessageToWX.Req.WXSceneSession;
//        // 向微信发送请求
//        wxapi.sendReq(req);
//    }

    private static Bitmap createBitmap(View view) {
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }
}
