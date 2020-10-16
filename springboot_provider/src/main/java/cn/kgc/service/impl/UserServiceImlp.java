package cn.kgc.service.impl;

import cn.kgc.dao.UserMapper;
import cn.kgc.entity.User;
import cn.kgc.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Author:wxc
 * project: springboot_zongJie
 * ClassName: UserServiceImlp
 * Date: 2020/8/11 16:03 周二
 * yy:猥琐别浪，等我发育。
 */

@Component
@Service(interfaceClass = UserService.class)
public class UserServiceImlp implements UserService {
      @Autowired
    private UserMapper userMapper;


    public List<User> getUserByPage(Map<String, Object> map) {
        return userMapper.getUserByPage(map);
    }


    public int getUserTotal() {
        return userMapper.getUserTotal();
    }

    @Override
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
