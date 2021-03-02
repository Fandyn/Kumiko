package com.happy.go.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.PageInfo;
import com.happy.go.converter.UserConverter;
import com.happy.go.entity.User;
import com.happy.go.entity.VO.UserQuery;
import com.happy.go.mapper.UserMapper;
import com.happy.go.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 *  天上如是，地上依然
 * </p>
 *
 * @author fandz
 * @since 2021-01-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserConverter converter;

    @Override
    @ApiImplicitParam("添加")
    public int addUser(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        return mapper.insert(user);
    }

    @Override
    @ApiImplicitParam("删除")
    public int delUser(User user) {
        return mapper.deleteById(user.getId());
    }

    @Override
    @ApiImplicitParam("修改")
    public int updateUser(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, user.getId());
//        wrapper.eq(User::getUsername, user.getUsername());
        return mapper.update(user, wrapper);
    }


    @Override
    @ApiImplicitParam("根据条件查询")
    public User getUser(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, user.getId());
        user = mapper.selectOne(wrapper);
        return user;
    }

    @Override
    @ApiImplicitParam("性别查询")
    public PageInfo<User> queryUserList(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(user.getSex()),User::getSex, user.getSex());
        List<User> users = mapper.selectList(wrapper);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    @ApiImplicitParam("性别&id查询")
    public PageInfo<User> queryUserListByterm(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (user.getId() != null) {
            wrapper.eq(User::getId, user.getId());
        }
        wrapper.eq(StringUtils.isNotBlank(user.getSex()),User::getSex, user.getSex());
        List<User> users = mapper.selectList(wrapper);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    @ApiImplicitParam("分页查询")
    public PageInfo<UserQuery> pageInfo(UserQuery userQuery) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (userQuery.getId() != null) {
            wrapper.eq(User::getId, userQuery.getId());
        }
        wrapper.eq(StringUtils.isNotBlank(userQuery.getSex()),User::getSex, userQuery.getSex());
        List<User> users = mapper.selectList(wrapper);
        List<UserQuery> list = converter.userlist2querylist(users);
        PageInfo<UserQuery> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


}
