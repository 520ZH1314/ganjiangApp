package moye.ganjiang.com.ganjiang.model.regist;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/10.
 * 注册
 */

public class RegistResponseBean {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    //状态码
    public String status;
    //短信验证码
    public String code;

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String Msg;
    public String getMobliephone() {
        return mobliephone;
    }

    public void setMobliephone(String mobliephone) {
        this.mobliephone = mobliephone;
    }

    //手机号码
    public String mobliephone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //用户名
    public String username;

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }

    //请求方法
    public String Method;
}
