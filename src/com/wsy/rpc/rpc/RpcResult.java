package com.wsy.rpc.rpc;

import java.io.Serializable;
import java.util.Map;

/**
 * Rpc的结果
 * 之所以要设计Result是因为正常的请求除了结果，还有状态
 * 通常异常信息都是要的
 * 另外设计attachment是为了扩展以后一些其他的信息
 */
public class RpcResult implements Result, Serializable{
    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public Throwable getException() {
        return null;
    }

    @Override
    public boolean hasException() {
        return false;
    }

    @Override
    public Object recreate() throws Throwable {
        return null;
    }

    @Override
    public Map<String, String> getAttachments() {
        return null;
    }

    @Override
    public String getAttachment(String key) {
        return null;
    }

    @Override
    public String getAttachment(String key, String defaultValue) {
        return null;
    }
}
