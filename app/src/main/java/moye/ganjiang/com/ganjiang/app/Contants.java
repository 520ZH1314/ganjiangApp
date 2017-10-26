package moye.ganjiang.com.ganjiang.app;

import android.os.Environment;

import java.io.File;

import moye.ganjiang.com.ganjiang.base.App;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/10.
 * 常量
 */

public interface Contants {
    String LOGINORREGIST = "LoginOrRegist";
    String PHONENUMBER = "PhoneNumber";
    String REGISTBathUrl = "http://my.damatouzi.com/";
    String MARKBathUrl = "http://www.damatouzi.com/";
    String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    String PATH_CACHE = PATH_DATA + "/NetCache";
    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "moye.ganjiang" + File.separator + "com.ganjiang";
    String USERNAME="UserName";
    String METHOD="Method";
    String SESSIONID ="SessionId";
    String USERNUMBER ="UserNumber";
    String OPENBANKSTATUS="OpenBankStatus";
    public static final int OPEN= 0X001;
    String LOGINSTATUS="LoginStatus";
    String REQURL="http://mtest.cbhb.com.cn/";
    String SUCCESSINTERCEPT="http://my.damatouzi.com/bohai/userBankAccountRegister/appsuccess.action";
    String FAILINTERCEPT="http://my.damatouzi.com/bohai/userBankAccountRegister/appfail.action";
}
