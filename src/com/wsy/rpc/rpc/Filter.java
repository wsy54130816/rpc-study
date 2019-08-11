package com.wsy.rpc.rpc;

public interface Filter {
    Result invoke(Invoker<?> invoker, Invocation invocation);
}
