package com.wsy.rpc.rpc;

import com.wsy.rpc.common.Node;

/**
 * rpc执行方法的核心
 */
public interface Invoker<T> extends Node{

    Class<T> getInterface();

    Result invoke(Invocation invocation) throws RpcException;

}
