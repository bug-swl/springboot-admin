package cn.bug.admin.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description
 *
 * @author by bug
 * @Date 2021/11/27
 */
@Data
public class UserToken {
    private User user;
    private String userToken;
    private LocalDateTime expireTime;
    private boolean isLogin;
}
