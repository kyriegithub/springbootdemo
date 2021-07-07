package com.example.springboot.exception;

/**
 * 自定义业务异常
 *
 * @author caojianyi@dxy.cn
 * @date 7/7/21 11:27 PM
 * @Description
 */
public class BusinessException extends RuntimeException {

    private int code;
    private String msg;

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
