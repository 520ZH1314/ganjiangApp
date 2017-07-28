package moye.ganjiang.com.ganjiang.utils;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/17.
 */
public class ApiException extends Exception{

    private int code;

    public ApiException(String msg) {
        super(msg);
    }

    public ApiException(String msg, int code) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

