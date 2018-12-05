package com.example.demo.shiro.Model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/27 4:34 PM
 * @Version 1.0
 * @Description 接口返回对象
 */

@Component
public class ResultMap extends HashMap<String, Object> {
    public ResultMap() {
    }

    public ResultMap success() {
        this.put("result", "success");
        return this;
    }

    public ResultMap fail() {
        this.put("result", "fail");
        return this;
    }

    public ResultMap message(Object message) {
        this.put("message", message);
        return this;
    }
}
