package moye.ganjiang.com.ganjiang.model.regist;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/10.
 * 注册
 */

public class RegistOrLoginBean {
    public RegistOrLoginBean(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    private String PhoneNumber;// 手机号码
}
