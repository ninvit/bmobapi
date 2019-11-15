package com.bmob.exception;

public enum ErrorCode {
	CUSTOM_ALIAS_ALREADY_EXISTS(001), SHORTENED_URL_NOT_FOUND(002), ;
 
    private int errorCode;
 
    private ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
 
    public int getErrorCode() {
        return errorCode;
    }
}