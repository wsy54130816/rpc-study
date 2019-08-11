package com.wsy.rpc.rpc;

import java.util.Map;

public interface Result {

    Object getValue();

    Throwable getException();

    boolean hasException();

    Object recreate() throws Throwable;

    // 省略过期接口 @Deprecated getResults

    // todo map的value为什么是String
    Map<String, String> getAttachments();

    String getAttachment(String key);

    String getAttachment(String key, String defaultValue);

}
