package cn.kgc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:wxc
 * project: springboot_zongJie
 * ClassName: HelloController
 * Date: 2020/8/13 20:41 周四
 * yy:猥琐别浪，等我发育。
 */

@RestController
public class HelloController {

    @PostMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
