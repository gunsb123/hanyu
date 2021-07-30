package com.example.newproject.common.util;

import java.io.Serializable;

/**
 * 作者：韩宇 on 2017/6/21 0021 13:50
 * 邮箱：18698802347@163.com
 * QQ：1760010478
 * 功能：用户属性封装
 */
public class UserBean implements Serializable {
    private String uid;//会员编码
    private String nickname;//会员昵称
    private String randomId;//出生日期
    private String path;//性别
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setRandomId(String randomId) {
        this.randomId = randomId;
    }

    public String getRandomId() {
        return randomId;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
