package com.happy.go.service;

import com.github.pagehelper.PageInfo;
import com.happy.go.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fandz
 * @since 2021-01-26
 */
public interface IUserService extends IService<User> {

    User getUser(User user);

    PageInfo<User> queryUserList(User user);

}
