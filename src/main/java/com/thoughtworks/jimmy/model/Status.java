package com.thoughtworks.jimmy.model;

public class Status {
    private int code;
    private String describe;

    public Status(int code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public Status() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
