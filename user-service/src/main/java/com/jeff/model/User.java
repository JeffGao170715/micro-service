package com.jeff.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 用户信息数据模型
 * Created by Jeff on 2018/6/15.
 */
public class User {
    @Id
    private Long id;
    @NotNull
    private String mobile;          // 手机号
    private String name;            // 姓名
    private String certiNo;          // 身份证号
    private String email;           // 邮箱

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertiNo() {
        return certiNo;
    }

    public void setCertiNo(String certiNo) {
        this.certiNo = certiNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
