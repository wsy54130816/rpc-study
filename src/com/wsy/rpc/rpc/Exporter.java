package com.wsy.rpc.rpc;

/**
 * 暴露服务用的接口
 * @param <T>
 */
public interface Exporter<T> {

    Invoker<T> getInvoker();

    void export();

}
