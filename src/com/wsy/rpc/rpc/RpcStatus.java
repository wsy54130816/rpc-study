package com.wsy.rpc.rpc;

import com.wsy.rpc.common.URL;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * RpcStatus有什么用？
 * 顾名思义应该是记录Rpc的状态的
 */
public class RpcStatus {

    // 线程安全的记录服务状态
    private static final ConcurrentMap<String, RpcStatus> SERVICE_STATISTICS = new ConcurrentHashMap<String, RpcStatus>();

    // 记录方法状态
    private static final ConcurrentMap<String, ConcurrentMap<String, RpcStatus>> METHOD_STATISTICS = new ConcurrentHashMap<String, ConcurrentMap<String, RpcStatus>>();

    // todo 这个接口有什么用？
    private final ConcurrentMap<String, Object> values = new ConcurrentHashMap<String, Object>();

    // todo 下面这些有什么用
    private final AtomicInteger active = new AtomicInteger();
    private final AtomicLong total = new AtomicLong();
    private final AtomicInteger failed = new AtomicInteger();
    private final AtomicLong totalElapsed = new AtomicLong();
    private final AtomicLong failedElapsed = new AtomicLong();
    private final AtomicLong maxElapsed = new AtomicLong();
    private final AtomicLong failedMaxElapsed = new AtomicLong();
    private final AtomicLong succeededMaxElapsed = new AtomicLong();

    private volatile Semaphore executesLimit;
    private volatile int executesPermits;

    // rpcStatus是单例的 单例在代码里的实际应用
    private RpcStatus() {
    }

    /**
     * 获取指定的url的RpcStatus
     * @param url
     * @return
     */
    public static RpcStatus RpcStatus(URL url) {
        String uri = url.toIdentityString();
        // 通过url获得服务的状态
        return SERVICE_STATISTICS.get(uri);
    }

    public static void removeStatus(URL url) {
        // todo 可见URL的url.toIdentityString();
        String uri = url.toIdentityString();
        SERVICE_STATISTICS.remove(uri);
    }

    /**
     * 获取指定服务的某个方法的状态
     * @param url
     * @param methodName
     * @return
     */
    public static RpcStatus getStatus(URL url, String methodName) {
        String uri = url.toIdentityString();
        ConcurrentMap<String, RpcStatus> map = METHOD_STATISTICS.get(uri);
        if (map == null) {
            METHOD_STATISTICS.putIfAbsent(uri, new ConcurrentHashMap<String, RpcStatus>());
            map = METHOD_STATISTICS.get(uri);
        }
        RpcStatus status = map.get(methodName);
        if (status == null) {
            map.putIfAbsent(methodName, new RpcStatus());
            status = map.get(methodName);
        }
        return status;
    }

    /**
     * @param url
     */
    public static void removeStatus(URL url, String methodName) {
        String uri = url.toIdentityString();
        ConcurrentMap<String, RpcStatus> map = METHOD_STATISTICS.get(uri);
        if (map != null) {
            map.remove(methodName);
        }
    }

    /**
     * todo 这个方法有什么用
     * @param url
     */
    public static void beginCount(URL url, String methodName) {
        beginCount(getStatus(url));
        beginCount(getStatus(url, methodName));
    }

    /**
     * @param url
     * @return status
     */
    public static RpcStatus getStatus(URL url) {
        String uri = url.toIdentityString();
        RpcStatus status = SERVICE_STATISTICS.get(uri);
        if (status == null) {
            SERVICE_STATISTICS.putIfAbsent(uri, new RpcStatus());
            status = SERVICE_STATISTICS.get(uri);
        }
        return status;
    }

    private static void beginCount(RpcStatus status) {
        status.active.incrementAndGet();
    }
}
