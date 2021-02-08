package com.happy.go.controller;


import com.github.pagehelper.PageInfo;
import com.happy.go.entity.User;
import com.happy.go.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController          //@Controller和@ResponseBody
@RequestMapping("/select")
@Api("查询接口测试控制类")
public class SelectController {

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
