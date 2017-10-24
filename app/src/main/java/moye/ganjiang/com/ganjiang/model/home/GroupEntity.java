package moye.ganjiang.com.ganjiang.model.home;

import java.util.ArrayList;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/28.
 */

public class GroupEntity {
    private String mGroupName;

    public ArrayList<HomeBean> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<HomeBean> children) {
        this.children = children;
    }

    private ArrayList<HomeBean> children;
    public GroupEntity(String groupName,ArrayList<HomeBean> children){
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
