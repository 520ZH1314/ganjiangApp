package moye.ganjiang.com.ganjiang.utils;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/11.
 */

public class ResponseCodeError extends RuntimeException {
    public ResponseCodeError(String msg) {
        super(msg);
    }
}
