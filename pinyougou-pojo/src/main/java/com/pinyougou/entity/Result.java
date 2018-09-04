package com.pinyougou.entity;

import java.io.Serializable;

/**
 * <pre>
 *  返回结果
 * </pre>
 *
 * @author frankJiang
 * @version $ Id: Result.java, v 0.1 2018/9/2 14:17 frankJiang Exp $
 */
public class Result implements Serializable {

    private boolean success;

    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
