package com.larrylian.boot.demo.controller;

import com.larrylian.boot.demo.exception.MyException;
import com.larrylian.boot.demo.utils.JsonReply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Larry on 2017/9/4
 */
@Controller
public class IndexController {
    //首页
    @RequestMapping({"/", "", "index", "index.html"})
    public String index() {
        return "index";
    }

    /**
     * json测试
     * @return
     */
    @RequestMapping("hello")
    @ResponseBody
    public Map<String, String> helloJson() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "larry");
        map.put("age", "22");
        return map;
    }

    /**
     * JsonReply 返回消息体测试
     * @return
     */
    @RequestMapping("json/success")
    @ResponseBody
    public JsonReply jsonSuccess() {
        return JsonReply.success("成功");
    }

    /**
     * JsonReply 失败消息体测试
     * @return
     */
    @RequestMapping("json/error")
    @ResponseBody
    public JsonReply jsonError() {
        return JsonReply.error("1000001", "测试接口");
    }

    /**
     * 统一异常处理测试
     * @return
     * @throws Exception
     */
    @RequestMapping("error/test")
    public JsonReply errorTest() throws Exception {
        throw new MyException("001001", "统一异常处理");
    }

    /**
     * 未捕获异常处理测试
     * @return
     */
    @RequestMapping("error/other")
    public JsonReply errorOther() {
        int i = 3/0;
        return JsonReply.success(i);
    }

}
