package org.kevin.blog.common;

/**
 * @author Kevin.Z
 * @version 12/11/18
 */
public enum ResultCode {
    SUCCESS(200,"success"),
    FAIL(400,"fali");

    private int code;
    private String msg;
    private ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
