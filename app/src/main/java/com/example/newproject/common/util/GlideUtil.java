package com.example.newproject.common.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.newproject.R;

/**
 * 作者：韩宇 on 2017/6/26 0026 08:26
 * 邮箱：18698802347@163.com
 * QQ：1760010478
 * 功能：glide加载图片框架
 */
public class GlideUtil {
    public static void image(Context context, String url, final ImageView imageView, int path) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .error(path)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }
    public static void image(Context context, String url, final ImageView imageView) {
        RequestOptions options = new RequestOptions()
                .error(R.drawable.imageloading)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }
    public static void image(int number,Context context, String url, final ImageView imageView) {
        RequestOptions options1 = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.imageloading)//预加载图片
                .error(R.drawable.imageloading)//加载失败显示图片
                .priority(Priority.HIGH)//优先级
                .diskCacheStrategy(DiskCacheStrategy.NONE)//缓存策略
                .transform(new GlideRoundTransform(context, number));//转化为圆角
        Glide.with(context).load(url).apply(options1).into(imageView);
    }

    public static void image(Context context, int url, final ImageView imageView, int path) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .error(path)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    public static void image(int number,Context context, int url, final ImageView imageView) {
        RequestOptions options1 = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.imageloading)//预加载图片
                .error(R.drawable.imageloading)//加载失败显示图片
                .priority(Priority.HIGH)//优先级
                .diskCacheStrategy(DiskCacheStrategy.NONE)//缓存策略
                .transform(new GlideRoundTransform(context, number));//转化为圆角
        Glide.with(context).load(url).apply(options1).into(imageView);
    }

    /**
     * load normal  for  circle or round img
     *
     * @param url
     * @param iv
     */
    public static void glideLoader(Context context, String url, final ImageView iv) {
        RequestOptions mRequestOptions = RequestOptions.circleCropTransform()
                .diskCacheStrategy(DiskCacheStrategy.ALL)//不做磁盘缓存
                .error(R.drawable.morentoux)
                .skipMemoryCache(true);//不做内存缓存

        Glide.with(context).load(url).apply(mRequestOptions).into(iv);
    }

    /**
     * load normal  for  circle or round img
     *
     * @param url
     * @param iv
     */
    public static void glideLoader(Context context, int url, final ImageView iv) {

        RequestOptions mRequestOptions = RequestOptions.circleCropTransform()
                .diskCacheStrategy(DiskCacheStrategy.ALL)//不做磁盘缓存
                .error(R.drawable.morentoux)
                .skipMemoryCache(true);//不做内存缓存

        Glide.with(context).load(url).apply(mRequestOptions).into(iv);
    }

}
