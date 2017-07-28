package moye.ganjiang.com.ganjiang.model.takemoney;

import java.util.ArrayList;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/28.
 */

public class OpiGroupEntity {
    private String mGroupName;

    public ArrayList<OpzimiBean> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<OpzimiBean> children) {
        this.children = children;
    }

    private ArrayList<OpzimiBean> children;
    public OpiGroupEntity(String groupName, ArrayList<OpzimiBean> children){
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
