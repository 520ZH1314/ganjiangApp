package moye.ganjiang.com.ganjiang.base;

import java.io.Serializable;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/17.
 */

public class BaseModelmp<T> implements Serializable {
    public String code;
    public String msg;

    public T data;


    public boolean success() {
        return code.equals("1");
    }


    @Override
    public String toString() {
        return "BaseModel{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }


}
