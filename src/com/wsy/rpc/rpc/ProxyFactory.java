package com.wsy.rpc.rpc;

import com.wsy.rpc.common.URL;

/**
 * 代理工厂
 * 1. 工厂是创建对象的工厂
 * 2. 代理工厂是生产代理对象的工厂
 * 3. 代理工厂接口不同的实现类，有不同的生产代理对象的方式
 * 4. dubbo默认使用的是javassist来生产，理由是反射生成对象慢
 */
public interface ProxyFactory {

    <T> T getProxy(Invoker<T> invoker) throws RpcException;

    /**
     * // todo url的设计理念 我仍然不是很明白
     * @param proxy
     * @param type
     * @param url
     * @param <T>
     * @return
     */
    <T> Invoker<T> getInvoker(T proxy, Class<T> type, URL url);
}
