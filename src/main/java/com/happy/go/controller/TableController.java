package com.happy.go.controller;


import com.github.pagehelper.PageInfo;
import com.happy.go.entity.User;
import com.happy.go.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/table")
@Api("查询接口测试控制类")
//模板设置可以不带后缀直接访问templates里面的html文件，但是无法访问该文件夹里面对应的css和js文件
//所以必须放入static里面，连带html一起放入，此时需要带后缀进行访问
public class TableController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/getUser")
    @ApiOperation("按条件查询")
    public User getUser(@RequestBody User user) {
        System.out.println(user.getId());
        user=iUserService.getUser(user);
        return user;
    }

    @PostMapping("/queryUserList")
    @ApiOperation("分页查询")
    public PageInfo<User> query(@RequestBody User user) {
        System.out.println(user.getUsername());
        PageInfo<User> pageInfo = iUserService.queryUserList(user);
        for (
                User m : pageInfo.getList()
        ) {
            System.out.println(m);
        }
        user.setAddress("远离尘世的理想之乡");
        return pageInfo;
    }


    @GetMapping
    public void naugxt() {}

}
