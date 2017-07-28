package moye.ganjiang.com.ganjiang.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/24.
 */

public class UserMeassageBean extends RealmObject implements Parcelable {

    public UserMeassageBean() {

    }

    public UserMeassageBean(String status, String resultCode,
                            String msg, String tradepass,
                            String ismobileverify, String realNameStr,
                            String id, String isopenfsinfo, String emailstr,
                            String mobilephone, String loginname, String isreally,
                            String imagepath, String email, String certificationnumberstr,
                            String realName, String accounttype, String certificationnumber,
                            String mobilephonestr, String isemailverify) {
        this.status = status;
        this.resultCode = resultCode;
        Msg = msg;
        this.tradepass = tradepass;
        this.ismobileverify = ismobileverify;
        this.realNameStr = realNameStr;
        this.id = id;
        this.isopenfsinfo = isopenfsinfo;
        this.emailstr = emailstr;
        this.mobilephone = mobilephone;
        this.loginname = loginname;
        this.isreally = isreally;
        this.imagepath = imagepath;
        this.email = email;
        this.certificationnumberstr = certificationnumberstr;
        this.realName = realName;
        this.accounttype = accounttype;
        this.certificationnumber = certificationnumber;
        this.mobilephonestr = mobilephonestr;
        this.isemailverify = isemailverify;
    }



    protected UserMeassageBean(Parcel in) {
        status = in.readString();
        resultCode = in.readString();
        Msg = in.readString();
        tradepass = in.readString();
        ismobileverify = in.readString();
        realNameStr = in.readString();
        id = in.readString();
        isopenfsinfo = in.readString();
        emailstr = in.readString();
        mobilephone = in.readString();
        loginname = in.readString();
        isreally = in.readString();
        imagepath = in.readString();
        email = in.readString();
        certificationnumberstr = in.readString();
        realName = in.readString();
        accounttype = in.readString();
        certificationnumber = in.readString();
        mobilephonestr = in.readString();
        isemailverify = in.readString();
    }

    public static final Creator<UserMeassageBean> CREATOR = new Creator<UserMeassageBean>() {
        @Override
        public UserMeassageBean createFromParcel(Parcel in) {
            return new UserMeassageBean(in);
        }

        @Override
        public UserMeassageBean[] newArray(int size) {
            return new UserMeassageBean[size];
        }
    };

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

    public String getTradepass() {
        return tradepass;
    }

    public void setTradepass(String tradepass) {
        this.tradepass = tradepass;
    }

    public String getIsmobileverify() {
        return ismobileverify;
    }

    public void setIsmobileverify(String ismobileverify) {
        this.ismobileverify = ismobileverify;
    }

    public String getRealNameStr() {
        return realNameStr;
    }

    public void setRealNameStr(String realNameStr) {
        this.realNameStr = realNameStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsopenfsinfo() {
        return isopenfsinfo;
    }

    public void setIsopenfsinfo(String isopenfsinfo) {
        this.isopenfsinfo = isopenfsinfo;
    }

    public String getEmailstr() {
        return emailstr;
    }

    public void setEmailstr(String emailstr) {
        this.emailstr = emailstr;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getIsreally() {
        return isreally;
    }

    public void setIsreally(String isreally) {
        this.isreally = isreally;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCertificationnumberstr() {
        return certificationnumberstr;
    }

    public void setCertificationnumberstr(String certificationnumberstr) {
        this.certificationnumberstr = certificationnumberstr;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getCertificationnumber() {
        return certificationnumber;
    }

    public void setCertificationnumber(String certificationnumber) {
        this.certificationnumber = certificationnumber;
    }

    public String getMobilephonestr() {
        return mobilephonestr;
    }

    public void setMobilephonestr(String mobilephonestr) {
        this.mobilephonestr = mobilephonestr;
    }

    public String getIsemailverify() {
        return isemailverify;
    }

    public void setIsemailverify(String isemailverify) {
        this.isemailverify = isemailverify;
    }

    public String status;//状态码    1成功    2需要用户重新登录    0 失败
    public String resultCode;//具体返回码
    public String Msg;//消息提示
    public String tradepass;//是否 设置徽商交易密码  1 已设置 0未设置
    public String ismobileverify;//手机验证状态   1已验证 0未验证
    public String realNameStr;//身份证姓名（加*后）
    @PrimaryKey
    public String id;//用户主键ID (唯一)
    public String isopenfsinfo;//是否开通徽商电子账号  1已开通 0未开通
    public String emailstr;//用户email地址 （加*后）
    public String mobilephone;//用户手机号（测试环境返回 方便测试  ，生产环境不返回）
    public String loginname;//用户名
    public String isreally;//是否实名认证: 1已认证 0 未认证
    public String imagepath;//头像图片路径
    public String email;//用户email地址（测试环境返回 方便测试  ，生产环境不返回）
    public String certificationnumberstr;//身份证号码（加*后）
    public String realName;//身份证姓名（测试环境返回 方便测试  ，生产环境不返回）
    public String accounttype;//用户类型：1个人 0企业
    public String certificationnumber;//身份证号码（测试环境返回 方便测试  ，生产环境不返回）
    public String mobilephonestr;//用户手机号（加*后）
    public String isemailverify;//邮件验证 1已验证 0未验证


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(resultCode);
        dest.writeString(Msg);
        dest.writeString(tradepass);
        dest.writeString(ismobileverify);
        dest.writeString(realNameStr);
        dest.writeString(id);
        dest.writeString(isopenfsinfo);
        dest.writeString(emailstr);
        dest.writeString(mobilephone);
        dest.writeString(loginname);
        dest.writeString(isreally);
        dest.writeString(imagepath);
        dest.writeString(email);
        dest.writeString(certificationnumberstr);
        dest.writeString(realName);
        dest.writeString(accounttype);
        dest.writeString(certificationnumber);
        dest.writeString(mobilephonestr);
        dest.writeString(isemailverify);
    }
}
