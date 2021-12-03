package cn.bug.admin.service.impl;

import cn.bug.admin.entity.User;
import cn.bug.admin.entity.UserToken;
import cn.bug.admin.exception.UserException;
import cn.bug.admin.mapper.UserMapper;
import cn.bug.admin.service.LoginService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Description
 *
 * @author by bug
 * @Date 2021/11/27
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;
    
    @Override
    public UserToken login(User user) {
        UserToken userToken = new UserToken();
        User userRst = userMapper.selectOne(
            Wrappers.<User>lambdaQuery()
                    .eq(User::getUsername, user.getUsername())
                    .eq(User::getPassword, user.getPassword())
        );
        if (userRst == null) {
            throw new UserException(UserException.UserExEnum.LOGIN_EX);
        }
        userToken.setUserToken(UUID.randomUUID().toString().replace("-", ""));
        userToken.setUser(userRst);
        userToken.setLogin(true);
        userToken.setExpireTime(LocalDateTime.now());
        return userToken;
    }
}
