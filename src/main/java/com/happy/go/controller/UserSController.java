package com.happy.go.controller;
import com.happy.go.entity.UserS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fandz
 * @since 2021-01-26
 */
@Controller
public class UserSController {

    @RequestMapping(value = "/json")//默认post与get都可以
    public String index(Model model){
        System.out.println("已执行");
        return "json";
    }

    @PostMapping("/json")
    @ResponseBody            //加上此注解时可以为前端数据返回response数据，方法里需要有return
    public UserS getJsonVal(@RequestBody UserS user) {
        System.out.println(user.getName());
        user.setName("失落圣诞");
        System.out.println(user.getName());
        return user;
    }

}
