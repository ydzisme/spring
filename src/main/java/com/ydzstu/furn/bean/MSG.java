package com.ydzstu.furn.bean;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class MSG {
    //返回一个代码200-代表成功，400代表失败
    private int code;
    //返回错误信息
    private String msg;
    //后端返回的数据信息
    private Map<String,Object> extend = new HashMap<>();
    //成功时返回的数据不包含后端数据
    public static MSG success(){
        MSG msg = new MSG();
        msg.setMsg("success");
        msg.setCode(200);
        return msg;
    }
    //失败时返回的数据，不包含后端数据
    public static MSG fail(){
        MSG msg = new MSG();
        msg.setMsg("fail");
        msg.setCode(400);
        return msg;
    }
    //加上后端返回的数据
    public MSG addBackInfo(String name,Object value){
        extend.put(name, value);
        return this;
    }
}
