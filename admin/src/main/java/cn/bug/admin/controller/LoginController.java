package cn.bug.admin.controller;

import cn.bug.admin.common.Result;
import cn.bug.admin.entity.User;
import cn.bug.admin.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author by bug
 * @Date 2021/11/26
 */
@RestController
public class LoginController {
    @Resource
    private LoginService loginService;
    
    @PostMapping("login")
    public Result<?> login(@RequestBody User user) {
        return Result.success(loginService.login(user));
    }
}
