package com.yuzhou.utils;

import com.yuzhou.model.Result;

public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMessage("成功");
        result.setDate(object);
        return result;
    }

    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setDate(null);
        return result;
    }

    public static Result success() {
        return success(null);
    }
}
