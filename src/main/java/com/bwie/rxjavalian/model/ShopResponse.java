package com.bwie.rxjavalian.model;

/**
 * Created by lenovo on 2017/12/5.
 */

public class ShopResponse<T> {
    public int code;
    public String msg;
    public T data;

    @Override
    public String toString() {
        return "ShopResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
