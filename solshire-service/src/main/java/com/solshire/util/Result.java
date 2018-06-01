package com.solshire.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author koabs
 * @Date 2018/5/30.
 * @Describe
 */
@Getter
@Setter
public class Result {
    // 返回状态码仿照http 状态码
    private String code;
    private String msg;

    public static Result success() {
        Result result = new Result();
        result.code = "200";
        result.msg = "Success";
        return result;
    }

}
