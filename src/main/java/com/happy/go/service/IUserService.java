package com.happy.go.service;

import com.github.pagehelper.PageInfo;
import com.happy.go.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.go.entity.VO.UserQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fandz
 * @since 2021-01-26
 */
@Api("User表方法接口")
public interface IUserService extends IService<User> {


    @ApiOperation("添加用户")
    int addUser(User user);

    @ApiOperation("删除用户")
    int delUser(User user);

    @ApiOperation("修改用户")
    int updateUser(User user);

    @ApiOperation("根据条件查询")
    User getUser(User user);

    @ApiOperation("根据条件分页查询")
    PageInfo<User> queryUserList(User user);

    @ApiOperation("根据条件id分页查询")
    PageInfo<User> queryUserListByterm(User user);

    @ApiOperation("根据条件id分页查询")
    PageInfo<UserQuery> pageInfo(UserQuery userQuery);

}
