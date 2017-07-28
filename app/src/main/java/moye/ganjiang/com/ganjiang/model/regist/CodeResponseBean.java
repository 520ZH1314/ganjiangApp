package moye.ganjiang.com.ganjiang.model.regist;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/19.
 */

public class CodeResponseBean {

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String Msg;
    private String code;
}
