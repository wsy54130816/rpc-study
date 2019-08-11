package com.wsy.rpc.rpc;

import com.wsy.rpc.common.URL;

/**
 * 协议接口，dubbo核心接口
 */
public interface Protocol {

    /**
     * 获取缺省的端口
     * @return
     */
    int getDefaultPort();

    /**
     * 暴露服务的接口
     * 注：dubbo源码是基于@Adaptive标签标注的这个接口，@Adaptive标签的作用是运行时决定这个方法的实际执行类
     * 这么设计其实是使得代码更不便于阅读的
     * @param invoker
     * @param <T>
     * @return
     * @throws RpcException
     */
    <T> Exporter<T> export(Invoker<T> invoker) throws RpcException;

    /**
     * 引用远程服务的接口
     * @param type
     * @param url
     * @param <T>
     * @return
     * @throws RpcException
     */
    <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException;

    /**
     * 取消该协议引用和暴露的所有服务
     */
    void destory();
}
