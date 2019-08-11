package com.wsy.rpc.rpc;

/**
 * 需要实现 spi 但是个人觉得不需要使用 dubbo的spi
 */
public interface InvokerListener {

    // todo 不懂
    void referred(Invoker<?> invoker) throws RpcException;

    // todo 不懂
    void destroyed(Invoker<?> invoker);
}
