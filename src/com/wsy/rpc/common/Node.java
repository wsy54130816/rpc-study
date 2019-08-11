package com.wsy.rpc.common;

/**
 * 一个common的接口，主要是为了引入Url
 */
public interface Node {

    URL getUrl();

    boolean isAvailable();

    void destroy();
}
