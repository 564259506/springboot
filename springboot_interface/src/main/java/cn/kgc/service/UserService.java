package cn.kgc.service;

import cn.kgc.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Author:wxc
 * project: springboot_zongJie
 * ClassName: UserService
 * Date: 2020/8/11 15:59 周二
 * yy:猥琐别浪，等我发育。
 */
public interface UserService {
    //1.分页的方法
    List<User> getUserByPage(Map<String,Object> map);

    // 2. 查询总记录数total
    int getUserTotal();

    // 3.添加的方法
    int insertSelective(User user);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User user);

    int deleteByPrimaryKey(Integer id);
}
