package com.example.newproject.common.base;


import java.lang.ref.WeakReference;

/**
 * 创建时间： 2018/1/9.
 * 编写人：韩宇
 * 电话微信同：18698802347
 * BasePresenter
 */
public abstract class BasePresenter<M, V> {
    private WeakReference actReference;
    protected M iModel;

    public M getiModel() {
        iModel = loadModel(); //使用前先进行初始化
        return iModel;
    }

    public void attachView(V view) {
        actReference = new WeakReference(view);
    }

    public void detachView() {
        if (actReference != null) {
            actReference.clear();
            actReference = null;
        }
    }

    public V getIView() {
        if (actReference != null&&actReference.get()!=null) {
            return (V) actReference.get();
        } else {
            return null;
        }
    }

    public abstract M loadModel();
}
