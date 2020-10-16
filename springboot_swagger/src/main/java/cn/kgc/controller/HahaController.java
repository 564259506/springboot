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
public class HahaController {

    @PostMapping(value = "/haha")
    public String hello(String s){
        s="与人相处好难啊";
        return "haha"+s;
    }
}
