package moye.ganjiang.com.ganjiang.model.takemoney;

import java.util.ArrayList;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/28.
 */

public class CreditorEntity {

    private String mGroupName;
    public ArrayList<CreditorBean> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<CreditorBean> children) {
        this.children = children;
    }

    private ArrayList<CreditorBean> children;
    public CreditorEntity(String groupName,ArrayList<CreditorBean> children){
        this.mGroupName=groupName;
        this.children=children;
    }
    public String getmGroupName() {
        return mGroupName;
    }

    public void setmGroupName(String mGroupName) {
        this.mGroupName = mGroupName;
    }

}
