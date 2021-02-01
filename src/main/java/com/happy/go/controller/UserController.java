package com.happy.go.controller;


import com.happy.go.entity.UserS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fandz
 * @since 2021-01-26
 */

//@RestController       @Controller和@ResponseBody
@RequestMapping("/user")
@Controller
//@ResponseBody           //加上此注解时可以为前端数据返回response数据，方法里需要有return,需要放在方法上面，f否则提示编码错误
//@RequestBody           //获取前端发送的请求
public class UserController {

//每个control只能返回一个页面,必须要有post和get的返回方法

    @PostMapping
    @ResponseBody
    public UserS getJsonVal(@RequestBody UserS user) {//@RequestBody一个类一个就可以覆盖所有的方法,
        System.out.println(user.getName());
        user.setName("鸠占鹊巢");
        System.out.println(user.getName());
        return user;
    }


//    @ResponseBody         //同时存在多个ResponseBody时会返回最后一个方法的ResponseBody，方法为get时一般为json格式的数据网页
                        //无response时get方式无法准确获取响应参数，同上面矛盾，故使用post方法
    @GetMapping
    public UserS getuser(UserS user) {
        System.out.println("种田梨沙-.-");
        System.out.println(user.getId());
        user.setName("御坂");
        return user;
    }

}

