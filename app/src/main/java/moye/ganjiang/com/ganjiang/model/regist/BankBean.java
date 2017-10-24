package moye.ganjiang.com.ganjiang.model.regist;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/10/13.
 * 银行开户返回的数据的 bean 类
 */

public class BankBean implements Parcelable {
    private String status;
    private String resultCode;

    public BankBean(String status, String resultCode,
                    String msg, String char_set,
                    String partner_id, String version_no,
                    String biz_type,
                    String sign_type, String merBillNo,
                    String openType, String identType,
                    String identNo, String usrName,
                    String mobileNo, String openBankId,
                    String openAcctId, String pageReturnUrl,
                    String bgRetUrl, String merPriv,
                    String mac, String req_url) {
        this.status = status;
        this.resultCode = resultCode;
        Msg = msg;
        this.char_set = char_set;
        this.partner_id = partner_id;
        this.version_no = version_no;
        this.biz_type = biz_type;
        this.sign_type = sign_type;
        MerBillNo = merBillNo;
        OpenType = openType;
        IdentType = identType;
        IdentNo = identNo;
        UsrName = usrName;
        MobileNo = mobileNo;
        OpenBankId = openBankId;
        OpenAcctId = openAcctId;
        PageReturnUrl = pageReturnUrl;
        BgRetUrl = bgRetUrl;
        MerPriv = merPriv;
        this.mac = mac;
        this.req_url = req_url;
    }

    private String Msg;
    private String char_set;//	字符集
    private String partner_id;    //商户号	string
    private String version_no;    //版本号	string
    private String biz_type;    //消息类型	string
    private String sign_type;    //签名方式	string
    private String MerBillNo;    //商户流水号	string
    private String OpenType;    //开户类型	string
    private String IdentType;    //证件类型	string
    private String IdentNo;//证件号码	string
    private String UsrName;    //姓名	string
    private String MobileNo;    //手机号	string
    private String OpenBankId;    //开户银行代号	string
    private String OpenAcctId;    //开户银行账号	string
    private String PageReturnUrl;    //页面返回url	string
    private String BgRetUrl;    //后台通知url	string
    private String MerPriv;    //商户保留域	string
    private String mac;//签名值	string
    private String req_url;//请求银行url地址	string

    protected BankBean(Parcel in) {
        status = in.readString();
        resultCode = in.readString();
        Msg = in.readString();
        char_set = in.readString();
        partner_id = in.readString();
        version_no = in.readString();
        biz_type = in.readString();
        sign_type = in.readString();
        MerBillNo = in.readString();
        OpenType = in.readString();
        IdentType = in.readString();
        IdentNo = in.readString();
        UsrName = in.readString();
        MobileNo = in.readString();
        OpenBankId = in.readString();
        OpenAcctId = in.readString();
        PageReturnUrl = in.readString();
        BgRetUrl = in.readString();
        MerPriv = in.readString();
        mac = in.readString();
        req_url = in.readString();
    }

    public static final Creator<BankBean> CREATOR = new Creator<BankBean>() {
        @Override
        public BankBean createFromParcel(Parcel in) {
            return new BankBean(in);
        }

        @Override
        public BankBean[] newArray(int size) {
            return new BankBean[size];
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

    public String getChar_set() {
        return char_set;
    }

    public void setChar_set(String char_set) {
        this.char_set = char_set;
    }

    public String getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id;
    }

    public String getVersion_no() {
        return version_no;
    }

    public void setVersion_no(String version_no) {
        this.version_no = version_no;
    }

    public String getBiz_type() {
        return biz_type;
    }

    public void setBiz_type(String biz_type) {
        this.biz_type = biz_type;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getMerBillNo() {
        return MerBillNo;
    }

    public void setMerBillNo(String merBillNo) {
        MerBillNo = merBillNo;
    }

    public String getOpenType() {
        return OpenType;
    }

    public void setOpenType(String openType) {
        OpenType = openType;
    }

    public String getIdentType() {
        return IdentType;
    }

    public void setIdentType(String identType) {
        IdentType = identType;
    }

    public String getIdentNo() {
        return IdentNo;
    }

    public void setIdentNo(String identNo) {
        IdentNo = identNo;
    }

    public String getUsrName() {
        return UsrName;
    }

    public void setUsrName(String usrName) {
        UsrName = usrName;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getOpenBankId() {
        return OpenBankId;
    }

    public void setOpenBankId(String openBankId) {
        OpenBankId = openBankId;
    }

    public String getOpenAcctId() {
        return OpenAcctId;
    }

    public void setOpenAcctId(String openAcctId) {
        OpenAcctId = openAcctId;
    }

    public String getPageReturnUrl() {
        return PageReturnUrl;
    }

    public void setPageReturnUrl(String pageReturnUrl) {
        PageReturnUrl = pageReturnUrl;
    }

    public String getBgRetUrl() {
        return BgRetUrl;
    }

    public void setBgRetUrl(String bgRetUrl) {
        BgRetUrl = bgRetUrl;
    }

    public String getMerPriv() {
        return MerPriv;
    }

    public void setMerPriv(String merPriv) {
        MerPriv = merPriv;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getReq_url() {
        return req_url;
    }

    public void setReq_url(String req_url) {
        this.req_url = req_url;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(resultCode);
        dest.writeString(Msg);
        dest.writeString(char_set);
        dest.writeString(partner_id);
        dest.writeString(version_no);
        dest.writeString(biz_type);
        dest.writeString(sign_type);
        dest.writeString(MerBillNo);
        dest.writeString(OpenType);
        dest.writeString(IdentType);
        dest.writeString(IdentNo);
        dest.writeString(UsrName);
        dest.writeString(MobileNo);
        dest.writeString(OpenBankId);
        dest.writeString(OpenAcctId);
        dest.writeString(PageReturnUrl);
        dest.writeString(BgRetUrl);
        dest.writeString(MerPriv);
        dest.writeString(mac);
        dest.writeString(req_url);
    }
}
