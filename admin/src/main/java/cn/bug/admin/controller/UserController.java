package cn.bug.admin.controller;

import cn.bug.admin.common.Result;
import cn.bug.admin.entity.User;
import cn.bug.admin.mapper.UserMapper;
import cn.bug.admin.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author by bug
 * @Date 2021/10/20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;
    
    private Result<User> rst;
    
    @ApiOperation("保存用户")
    @PostMapping
    public Result<User> save(@RequestBody User user) {
        try {
            rst = Result.success(userService.add(user));
        } catch (Exception e) {
            e.printStackTrace();
            rst = Result.error(e.getMessage());
        }
        return rst;
    }
    
    @Transactional
    @ApiOperation("更新用户")
    @PutMapping
    public Result<User> update(@RequestBody User user) {
        try {
            rst = Result.success(userService.modify(user));
        } catch (Exception e) {
            e.printStackTrace();
            rst = Result.error(e.getMessage());
        }
        return rst;
    }
    
    @Transactional
    @ApiOperation("删除用户")
    @DeleteMapping
    public Result<User> delete(String id) {
        userMapper.deleteById(id);
        return Result.success();
    }
    
    
    @ApiOperation("查询用户")
    @GetMapping
    public Result<Page<User>> list(@RequestParam(defaultValue = "1") Integer currentPage,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   @RequestParam(defaultValue = "") String search) {
        Page<User> page = new Page<>(currentPage, pageSize);
        page.setOptimizeCountSql(false);
        Page<User> userPage = userMapper.selectPage(page, Wrappers.<User>lambdaQuery().like(User::getUsername, search));
        return Result.success(userPage);
    }
    
    
}
