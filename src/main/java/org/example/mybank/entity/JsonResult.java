package org.example.mybank.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
//实体类里面必须写引用类型，成员变量建议都使用包装类
public class JsonResult {
    //标识此次请求是否正确
    private Boolean result;
    private Object data;
    private String msg;

    public JsonResult(Object data) {
        this.result = true;
        this.data = data;
    }
    public JsonResult(Boolean result, String msg) {
        this.result = result;
        this.msg = msg;
    }
    public JsonResult(String errMsg)
    {
        this.result = false;
        this.msg = errMsg;
    }

//    public JsonResult getInstance(Object data) {
//        return JsonResult()
//    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}