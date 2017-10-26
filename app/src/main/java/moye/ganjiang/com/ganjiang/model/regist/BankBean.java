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

    private String status;//状态码
    private String resultCode;//返回状态
    private String Msg;//信息提示

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

    public String getReq_url() {
        return req_url;
    }

    public void setReq_url(String req_url) {
        this.req_url = req_url;
    }

    private String req_url;//请求银行url地址	string

    public BankBean(String status, String resultCode, String msg, String req_url) {
        this.status = status;
        this.resultCode = resultCode;
        Msg = msg;
        this.req_url = req_url;
    }

    protected BankBean(Parcel in) {
        status = in.readString();
        resultCode = in.readString();
        Msg = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(resultCode);
        dest.writeString(Msg);
        dest.writeString(req_url);
    }
}
