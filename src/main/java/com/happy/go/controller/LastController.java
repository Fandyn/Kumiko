package com.happy.go.controller;


import com.happy.go.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/last")
public class LastController {

    @PostMapping
    @ResponseBody
    public User lastdemo(@RequestBody User user) {
        System.out.println(user.getUsername());
        user.setAddress("远离尘世的理想之乡");
        return user;
    }

    @GetMapping
    public void naugxt() { }

}
