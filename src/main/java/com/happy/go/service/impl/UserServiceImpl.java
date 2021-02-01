package com.happy.go.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import com.happy.go.entity.User;
import com.happy.go.mapper.UserMapper;
import com.happy.go.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fandz
 * @since 2021-01-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User getUser(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, user.getId());
        user = mapper.selectOne(wrapper);
        return user;
    }

    @Override
    public PageInfo<User> queryUserList(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getSex, user.getSex());
        List<User> users = mapper.selectList(wrapper);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }


}
