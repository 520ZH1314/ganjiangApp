package moye.ganjiang.com.ganjiang.adapt;

import android.content.Context;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.model.takemoney.OpiGroupEntity;
import moye.ganjiang.com.ganjiang.model.takemoney.OpzimiBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/28.
 */

public class OptimizingAdapter extends GroupedRecyclerViewAdapter {


    private  List<OpiGroupEntity> Data=new ArrayList<OpiGroupEntity>();

    public OptimizingAdapter(Context context, List<OpiGroupEntity> mData) {
          super(context);
          Data = mData;
    }
    @Override
    public int getGroupCount() {
        return Data == null ? 0 : Data.size();
    }

    @Override
    public int getChildrenCount(int i) {
        ArrayList<OpzimiBean> children = Data.get(i).getChildren();
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
        return R.layout.optimizi_section;
    }

    @Override
    public int getFooterLayout(int i) {
        return 0;
    }

    @Override
    public int getChildLayout(int i) {
        return R.layout.item_opzimi;
    }

    @Override
    public void onBindHeaderViewHolder(BaseViewHolder baseViewHolder, int i) {
        OpiGroupEntity groupEntity = Data.get(i);
        baseViewHolder.setText(R.id.optimizi_head,groupEntity.getmGroupName());
    }

    @Override
    public void onBindFooterViewHolder(BaseViewHolder baseViewHolder, int i) {

    }

    @Override
    public void onBindChildViewHolder(BaseViewHolder holder, int groupPosition, int childPosition) {
        OpzimiBean entity = Data.get(groupPosition).getChildren().get(childPosition);
        holder.setText(R.id.op_name, entity.getmName());
        holder.setText(R.id.creaditor_tv_transfer_rate, entity.getmPrecent());
        holder.setText(R.id.creaditor_tv_transfer_num, entity.getmDate());
        holder.setText(R.id.op_up, entity.getmAddPrecent());
    }
}
