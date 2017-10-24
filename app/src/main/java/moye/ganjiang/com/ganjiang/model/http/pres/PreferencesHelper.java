package moye.ganjiang.com.ganjiang.model.http.pres;

/**
 * @author: lovezh
 * @date: 2017/9/21
 * @description:Preferenceshelper的接口
 */

public interface PreferencesHelper {

    String getUserName();
    void setUserName(String UserName);
    String getMethod();
    void setMethod(String Method);
    String getSessionId();
    void setSessionId(String SessionId);
    void clearSessionId(String  Key);
    void setUserNumber(String Phone);
    String getUserNumber();
    void setOpenBankStatus(String status);
    String getUserOpenBankStatus();
    void setLoginStatus(String status);
    String getLoginStatus();
    void setReq_url(String req_url);
    String getReq_url();
}
