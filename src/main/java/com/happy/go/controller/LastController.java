package com.happy.go.controller;


import com.happy.go.entity.User;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/last")
public class LastController {

    @PostMapping("/demo")
    public User lastdemo(@RequestBody User user) {
        System.out.println(user.getUsername());
        user.setAddress("远离尘世的理想之乡");
        return user;
    }

    @GetMapping
    public void naugxt() { }

}
