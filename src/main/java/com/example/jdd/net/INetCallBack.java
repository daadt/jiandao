package com.example.jdd.net;

public interface INetCallBack<T> {
    void onSuccess(T t);
    void onError(Throwable throwable);
}
