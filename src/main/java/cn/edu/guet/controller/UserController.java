package cn.edu.guet.controller;

import cn.edu.guet.bean.User;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.UserService;

@Controller
public class UserController {
   private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/saveUser")
    public ResponseData saveUser(User user){
        return userService.saveUser(user);
    }
/*//抽象工厂模式：自动创建对象，然后调用set方法注入进来
    @RequestMapping("/saveUser")
    public String saveUser(User user){//方法的返回类型决定了要跳转到那个页面
        System.out.println("保存用户"+user);
        return "";//想跳到哪个页面就return哪个页面
    }
    @RequestMapping("/deleteUser")
    public String deletdUser(int id){
        System.out.println("界面传来的数据"+id);
        userService.deleteUser(id);
        return "viewUesr.jsp";
    }*/


}
