package com.happy.go.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.happy.go.entity.User;
import com.happy.go.entity.VO.UserQuery;
import com.happy.go.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/axios")
@Api("查询接口测试控制类")
public class AxiosController {

    @Autowired
    private IUserService iUserService;


    @PostMapping("/updateUser")
    @ApiOperation("修改用户")
    public void update(@RequestBody User user) {
        //修改测试
        System.out.println("update");
        System.out.println("id:" + user.getId() + "---name:" + user.getUsername() + "--sex:" + user.getSex() + "--address:" + user.getAddress() + "--birthday:" + user.getBirthday());
        System.out.println(iUserService.updateUser(user));
    }
    @PostMapping("/addUser")
    @ApiOperation("添加用户")
    public void add(@RequestBody User user) {
        //修改测试
        System.out.println("add");
        System.out.println("id:"+user.getId()+"---name:"+user.getUsername()+"--sex:"+user.getSex()+"--address:"+user.getAddress()+"--birthday:"+user.getBirthday());
        System.out.println(iUserService.addUser(user));
    }

    @PostMapping("/delUser")
    @ApiOperation("修改用户")
    public void del(@RequestBody User user) {
        //修改测试
        System.out.println("del");
        System.out.println("id:" + user.getId() + "---name:" + user.getUsername() + "--sex:" + user.getSex() + "--address:" + user.getAddress() + "--birthday:" + user.getBirthday());
        System.out.println(iUserService.delUser(user));
    }


    @PostMapping("/queryUserList")
    @ApiOperation("性别查询")
    //如雷,
    public PageInfo<User> query(@RequestBody User user) {
        System.out.println("学会："+user.getUsername());
        user.setAddress("远离尘世的理想之乡");
////        for (
//                User m : pageInfo.getList()
//        ) {
////            System.out.println(m);
//        }
        return iUserService.queryUserList(user);
    }

    @PostMapping("/queryUserListByterm")
    @ApiOperation("性别&id查询")
    public PageInfo<User> queryUserListByterm(@RequestBody User user) {
        /*
        *    // 每页显示数量
            pageSize: 5,
            // 第几页
            pageNum: 1,
        * */
        return iUserService.queryUserListByterm(user);
    }

    @PostMapping("/queryinfo")
    @ApiOperation("分页查询")
    public PageInfo<UserQuery> queryinfo(@RequestBody UserQuery page) {
        System.out.println("加刻："+page.getPageNum());
        System.out.println("大小：" + page.getPageSize());
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return iUserService.pageInfo(page);
    }

    @PostMapping("/del")
    public void delFun(@RequestBody UserQuery userQuery) {

    }
    @GetMapping
    public void naugxt() {

    }

}
