package moye.ganjiang.com.ganjiang.adapt;

import android.content.Context;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.model.select.GroupEntity;
import moye.ganjiang.com.ganjiang.model.select.SelectBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/28.
 */

public class SelectAdapter extends GroupedRecyclerViewAdapter {


    private  List<GroupEntity> Data=new ArrayList<GroupEntity>();

    public SelectAdapter(Context context, List<GroupEntity> mData) {
          super(context);
          Data = mData;
    }

    @Override
    public int getGroupCount() {
        return Data == null ? 0 : Data.size();
    }

    @Override
    public int getChildrenCount(int i) {
        ArrayList<SelectBean> children = Data.get(i).getChildren();
        return children == null ? 0 : children.size();
    }

    @Override
    public boolean hasHeader(int i) {
        return true;
    }

    @Override
    public boolean hasFooter(int i) {
        return false;
    }

    @Override
    public int getHeaderLayout(int i) {
        return R.layout.ltem_section;
    }

    @Override
    public int getFooterLayout(int i) {
        return 0;
    }

    @Override
    public int getChildLayout(int i) {
        return R.layout.item_select;
    }

    @Override
    public void onBindHeaderViewHolder(BaseViewHolder baseViewHolder, int i) {
        GroupEntity groupEntity = Data.get(i);
        baseViewHolder.setText(R.id.head,groupEntity.getmGroupName());
    }

    @Override
    public void onBindFooterViewHolder(BaseViewHolder baseViewHolder, int i) {

    }

    @Override
    public void onBindChildViewHolder(BaseViewHolder holder, int groupPosition, int childPosition) {
        SelectBean entity = Data.get(groupPosition).getChildren().get(childPosition);
        holder.setText(R.id.section_name, entity.getmName());
        holder.setText(R.id.item_tv_percentage, entity.getmPrecent());
        holder.setText(R.id.section_date, entity.getmDate());
        holder.setText(R.id.section_money, entity.getmMoney());
    }
}
