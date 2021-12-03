package cn.bug.admin.common;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description
 *
 * @author by bug
 * @Date 2021/10/20
 */
@Data
@NoArgsConstructor
public class Result<T> {
    private String code;
    private String msg;
    private T data;
    
    
    public Result(T data) {
        this.data = data;
    }
    
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode("200");
        result.setMsg("success");
        return result;
    }
    
    public static <T> Result<T> success(T data) {
        Result<T> result = Result.success();
        result.setData(data);
        return result;
    }
    
    public static <T> Result<T> error() {
        Result<T> result = new Result<>();
        result.setCode("400");
        result.setMsg("fail");
        return result;
    }
    
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setCode("400");
        result.setMsg(msg);
        return result;
    }
    
}
