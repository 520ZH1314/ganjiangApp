package moye.ganjiang.com.ganjiang.model.http.pres;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface PreferencesHelper {

    String getUserName();
    void setUserName(String UserName);
    String getMethod();
    void setMethod(String Method);
    String getSessionId();
    void setSessionId(String SessionId);
    void clearSessionId(String  Key);
}
