package com.pp.socket;

import java.util.Map;

/**
 * @Description: socket传输
 * @Author: zhaoaolin
 * @Date: 2021/7/21 14:24
 */
public class SocketBo {

    /**
     * 路径
     */
    private String path;

    /**
     * 参数
     */
    private Map<String, Object> params;

    public String getPath() {
        return path;
    }

    public SocketBo setPath(String path) {
        this.path = path;
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public SocketBo setParams(Map<String, Object> params) {
        this.params = params;
        return this;
    }

    public SocketBo() {
    }

    public SocketBo(String path, Map<String, Object> params) {
        this.path = path;
        this.params = params;
    }
}
