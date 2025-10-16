package com.bing.p7;

import com.bing.p7.proj.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * 主人类
 */
public class Master {
    //账号
    private String loginId;
    //密码
    private String loginPwd;
    //姓名
    private String name;

    // 主人领养的宠物集合
    public List<Pet> pets = new ArrayList<>();

    public Master() {
    }

    public Master(String loginId, String loginPwd, String name) {
        this.loginId = loginId;
        this.loginPwd = loginPwd;
        this.name = name;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loingPwd) {
        this.loginPwd = loingPwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
