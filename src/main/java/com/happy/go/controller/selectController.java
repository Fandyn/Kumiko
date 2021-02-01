package com.happy.go.controller;


import com.github.pagehelper.PageInfo;
import com.happy.go.entity.User;
import com.happy.go.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/select")
public class selectController {

    @Autowired
    private IUserService iUserService;

    @PostMapping
    @ResponseBody
    @RequestMapping("/getUser")
    public User getUser(@RequestBody User user) {
        System.out.println(user.getId());
        user=iUserService.getUser(user);
        return user;
    }

    @PostMapping
    @ResponseBody
    @RequestMapping("/queryUserList")
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
    public void naugxt() { }

}
