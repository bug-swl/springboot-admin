package cn.bug.admin.service;

import cn.bug.admin.entity.User;
import cn.bug.admin.entity.UserToken;

/**
 * Description
 *
 * @author by bug
 * @Date 2021/11/27
 */
public interface LoginService {
    UserToken login(User user);
}
