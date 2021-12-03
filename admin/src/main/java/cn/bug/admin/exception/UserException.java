package cn.bug.admin.exception;

/**
 * Description
 *
 * @author by bug
 * @Date 2021/11/26
 */
public class UserException extends RuntimeException {
    
    
    public UserException(UserExEnum userExEnum) {
        super(userExEnum.code + " - " + userExEnum.msg);
    }
    
    public enum UserExEnum {
        UNIQUE_USERNAME(1, "用户名重复"),
        LOGIN_EX(2, "用户名或密码错误");
        public int code;
        public String msg;
        
        UserExEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
        
    }
}
