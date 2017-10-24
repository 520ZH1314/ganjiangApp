package moye.ganjiang.com.ganjiang.model.login;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/21.
 */
  /*
        *
        *
        * "sessionId": "7DC60C62E813958F1914E2714A506ABD",
    "status": "1",
    "resultCode": "success",
    "Msg": "登录成功！"
        *
        * */
public class LoginResponseBean {
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }


    public String sessionId;
    public  String status;
    public String resultCode;
    public String Msg;


}
