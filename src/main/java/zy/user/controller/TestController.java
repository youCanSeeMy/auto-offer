package zy.user.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @program: offer
 * @description: 测试
 * @author: 张钰
 * @create: 2020-08-06 11:29
 **/
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class TestController {

    @RequestMapping(name = "测试",path = "/test",method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public String test(){
        return "66666666";
    }
}
