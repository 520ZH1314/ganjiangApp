package moye.ganjiang.com.ganjiang.model.regist;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/10.
 */

public class RegistOrLoginResponseBean {
    private int status;// 状态
    private String Msg;//返回信息

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
}
