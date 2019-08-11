package com.wsy.rpc.rpc;

import java.io.Serializable;
import java.util.Map;

/**
 * Invoker方法的参数 Invocation接口实现类
 */
public class RpcInvocation implements Invocation, Serializable{
    @Override
    public String getMethodName() {
        return null;
    }

    @Override
    public Class<?>[] getParameterTypes() {
        return new Class[0];
    }

    @Override
    public Object[] getArguments() {
        return new Object[0];
    }

    /**
     * attachment存放的是group，version等信息
     * @return
     */
    @Override
    public Map<String, String> getAttachments() {
        return null;
    }

    @Override
    public String getAttachment(String key, String defaultValue) {
        return null;
    }

    @Override
    public String getAttachment(String key) {
        return null;
    }

    @Override
    public Invoker<?> getInvoker() {
        return null;
    }
}
