package cn.bug.admin.service.impl;

import cn.bug.admin.entity.User;
import cn.bug.admin.exception.UserException;
import cn.bug.admin.mapper.UserMapper;
import cn.bug.admin.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Description
 *
 * @author by bug
 * @Date 2021/11/26
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    
    @Override
    @Transactional
    public User add(User user) {
        if (StringUtils.isEmpty(user.getPassword())) {
            user.setPassword("123456");
        }
        validate(user);
        baseMapper.insert(user);
        return user;
    }
    
    @Override
    public User modify(User user) {
        if (StringUtils.isEmpty(user.getPassword())) {
            user.setPassword("123456");
        }
        validate(user);
        baseMapper.updateById(user);
        return user;
    }
    
    private boolean validate(User user) {
        if (duplicateValidate(user)) {
            throw new UserException(UserException.UserExEnum.UNIQUE_USERNAME);
        }
        return true;
    }
    
    private boolean duplicateValidate(User user) {
        return !baseMapper.selectList(
            Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername())
        ).isEmpty();
    }
    
}
