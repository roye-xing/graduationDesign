package com.roye.project.Entity;

import java.sql.Timestamp;

public class Request {
    private String id;
    private String requester;
    private Timestamp time;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    private String type;
    private String phone;
    private String email;
    private String accept1;
    private String accept2;
    private String accept3;
    private String msg;
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccept1() {
        return accept1;
    }

    public void setAccept1(String accept1) {
        this.accept1 = accept1;
    }

    public String getAccept2() {
        return accept2;
    }

    public void setAccept2(String accept2) {
        this.accept2 = accept2;
    }

    public String getAccept3() {
        return accept3;
    }

    public void setAccept3(String accept3) {
        this.accept3 = accept3;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
