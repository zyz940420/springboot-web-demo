package com.yuzhou.exception;

import com.yuzhou.enums.ResultEnum;

public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
