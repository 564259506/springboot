package cn.kgc.controller;

import cn.kgc.entity.User;
import cn.kgc.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:wxc
 * project: springboot_zongJie
 * ClassName: UserController
 * Date: 2020/8/11 16:38 周二
 * yy:猥琐别浪，等我发育。
 */

@Controller
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/index")
    public String index(@RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage, Model model){
        // 设置 每一页的 分页大小
        Integer pageSize = 2;
        // 总记录数
        Integer userTotal = userService.getUserTotal();
        // 计算总分页数
        Integer totalPage = userTotal%pageSize>0 ? (userTotal/pageSize + 1) : (userTotal/pageSize);
        // 分页页签的展示
        Integer[] pageLabelArr = new Integer[totalPage];

        // 获取分页的数据
        Integer startIndex = (currPage -1) * pageSize;
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", startIndex);
        map.put("pageSize", pageSize);
        map.put("currPage", currPage);
        List<User> list = userService.getUserByPage(map);

        model.addAttribute("list", list);
        model.addAttribute("pageLabelArr", pageLabelArr);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currPage", currPage);
        return "index";
    }

    /**
     * 显示用户添加页面的处理方法
     * @return
     */
    @RequestMapping("/showAdd")
    public String showAddUser(){
        return "addUser";
    }

    /**
     * 用户添加的方法
     * @param user
     * @return
     */
    @RequestMapping("/user/add")
    public String userAdd(User user){
        // 添加操作
        int result = userService.insertSelective(user);
        if(result >0){
            // 返回首页
            return "redirect:/index";
        }else{
            // 返回首页
            return "error";
        }
    }
//
//    /**
//     * 显示用户修改页面
//     */
    @RequestMapping("/showUpdateUser")
    public String showUpdateUser(@RequestParam("id") Integer id, Model model){
        // 1. 拿到id的user数据
        User user = userService.selectByPrimaryKey(id);
        // 2. 存数据
        model.addAttribute("user", user);
        // 3. 返回修改页面
        return "updateUser";
    }
//
//    /**
//     * 修改用户的操作
//     */
    @RequestMapping("/user/update")
    public String updateUser(User user){
        // 1. 判空
        if(StringUtils.isEmpty(user)){
            return "error";
        }
        // 2. 修改数据
        int result = userService.updateByPrimaryKeySelective(user);
        // 3. 返回页面
        if(result >0){
            // 返回首页
            return "redirect:/index";
        }else{
            // 返回首页
            return "error";
        }
    }
//
//    /**
//     * 删除用户信息，通过Id
//     */
    @RequestMapping("/delete/user")
    public String deleteUser(@RequestParam("id") Integer id){
        // 1. 判断
        // 2. 删除操作
        int result = userService.deleteByPrimaryKey(id);
        // 返回页面index
        System.out.println("result"+result);
        if(result >0){
            // 返回首页
            return "redirect:/index";
        }else{
            // 返回首页
            return "error";
        }
    }
}