package moye.ganjiang.com.ganjiang.model.takemoney;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/26.
 */

public class CreditorBean {


    public String getmMoney() {
        return mMoney;
    }

    public void setmMoney(String mMoney) {
        this.mMoney = mMoney;
    }

    private String mMoney;
    private String mDate;
    private String mPrecent;
    private String mName;



    public CreditorBean(String name, String precent, String money, String date  ) {

        this.mMoney=money;
        this.mDate=date;
        this.mName=name;
        this.mPrecent=precent;

    }


    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmPrecent() {
        return mPrecent;
    }

    public void setmPrecent(String mPrecent) {
        this.mPrecent = mPrecent;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
