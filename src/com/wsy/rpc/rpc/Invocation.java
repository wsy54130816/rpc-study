package com.wsy.rpc.rpc;

import java.util.Map;

/**
 * Invoker方法的参数，其实是一种命令设计模式
 */
public interface Invocation {

    String getMethodName();

    Class<?>[] getParameterTypes();

    Object[] getArguments();

    // todo
    Map<String, String> getAttachments();

    String getAttachment(String key, String defaultValue);

    String getAttachment(String key);

    Invoker<?> getInvoker();
}
