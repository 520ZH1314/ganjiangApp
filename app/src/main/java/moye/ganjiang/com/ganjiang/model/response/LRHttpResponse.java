package moye.ganjiang.com.ganjiang.model.response;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/17.
 * 登入和注册返回
 */

public class LRHttpResponse<T> {
    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
