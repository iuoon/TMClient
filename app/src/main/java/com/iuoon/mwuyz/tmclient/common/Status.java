package com.iuoon.mwuyz.tmclient.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mwuyz on 2016/8/30.
 */
public class Status {
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Message")
    private String message;

    public Status(String code,String message){
        this.code=code;
        this.message=message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
