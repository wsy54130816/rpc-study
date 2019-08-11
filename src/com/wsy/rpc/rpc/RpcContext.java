package com.wsy.rpc.rpc;

import com.wsy.rpc.common.URL;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * 注意 RpcContext是一个临时状态记录器，比如A调用B，B再调用C
 * 那么在B调用C之前，RpcContext记录的是A调用B，永远记录的是临时的状态
 * 通过观察属性知道，这个上下文记录的应该是临时的一次请求的，而不是全局的
 */
public class RpcContext {

    private final Map<String, String> attachments = new HashMap<String, String>();
    // 这个values要记录的是什么，不便于理解
    private final Map<String, Object> values = new HashMap<String, Object>();
    // 这个future又是要存什么
    private Future<?> future;

    private List<URL> urls;

    private String methodName;

    private Class<?>[] parameterTypes;

    private Object[] arguments;

    private InetSocketAddress localAddress;

    private InetSocketAddress remoteAddress;

    @Deprecated
    private List<Invoker<?>> invokers;

    // 剩下的先略
}
