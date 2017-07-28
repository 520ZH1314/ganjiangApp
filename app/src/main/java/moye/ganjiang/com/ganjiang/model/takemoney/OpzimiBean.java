package moye.ganjiang.com.ganjiang.model.takemoney;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/26.
 */

public class OpzimiBean {


    public String getmAddPrecent() {
        return mAddPrecent;
    }

    public void setmAddPrecent(String mAddPrecent) {
        this.mAddPrecent = mAddPrecent;
    }

    private String mAddPrecent;
    private String mDate;
    private String mPrecent;
    private String mName;



    public OpzimiBean(String name,String precent,String mAdd, String date  ) {

        this.mAddPrecent=mAdd;
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
