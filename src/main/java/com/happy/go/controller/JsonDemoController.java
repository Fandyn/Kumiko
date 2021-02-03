package com.happy.go.controller;

import com.happy.go.entity.UserS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class JsonDemoController {

    @RequestMapping("/jsonDemo")
    public String jsonD(Model user) {
        return "jsonDemo";
    }

    @PostMapping("/jsonDemo")
    public List<UserS> getJsonVal(@RequestBody List<UserS> user) throws IOException {
        for(UserS user2 : user){
            System.out.println("user2 = " + user2);
        }
        return user;
    }

}
