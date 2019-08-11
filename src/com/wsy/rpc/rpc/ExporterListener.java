package com.wsy.rpc.rpc;

/**
 * // todo 这个接口有什么用
 */
public interface ExporterListener {

    void exported(Exporter<?> exporter) throws RpcException;

    void unexported(Exporter<?> exporter); // 设计的原则void都是命令，所以这应该是一个命令
}
