package cn.bug.admin.service;

import cn.bug.admin.entity.User;

/**
 * Description
 *
 * @author by bug
 * @Date 2021/11/26
 */
public interface UserService {
    User add(User user);
    
    User modify(User user);
}
