package com.happy.go.service.impl;

import com.happy.go.entity.User;
import com.happy.go.mapper.UserMapper;
import com.happy.go.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
