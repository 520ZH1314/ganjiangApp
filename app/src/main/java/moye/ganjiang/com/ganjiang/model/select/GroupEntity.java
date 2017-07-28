package moye.ganjiang.com.ganjiang.model.select;

import java.util.ArrayList;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/28.
 */

public class GroupEntity {
    private String mGroupName;

    public ArrayList<SelectBean> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<SelectBean> children) {
        this.children = children;
    }

    private ArrayList<SelectBean> children;
    public GroupEntity(String groupName,ArrayList<SelectBean> children){
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
