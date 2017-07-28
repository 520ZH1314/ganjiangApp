package moye.ganjiang.com.ganjiang.adapt;

import android.content.Context;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.model.takemoney.CreditorBean;
import moye.ganjiang.com.ganjiang.model.takemoney.CreditorEntity;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/28.
 */

public class CreditorAdapter extends GroupedRecyclerViewAdapter {


    private  List<CreditorEntity> Data=new ArrayList<CreditorEntity>();

    public CreditorAdapter(Context context, List<CreditorEntity> mData) {
          super(context);
          Data = mData;
    }
    @Override
    public int getGroupCount() {
        return Data == null ? 0 : Data.size();
    }

    @Override
    public int getChildrenCount(int i) {
        ArrayList<CreditorBean> children = Data.get(i).getChildren();
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
        return  R.layout.optimizi_section;
    }

    @Override
    public int getFooterLayout(int i) {
        return 0;
    }

    @Override
    public int getChildLayout(int i) {
        return R.layout.item_creaditors;
    }

    @Override
    public void onBindHeaderViewHolder(BaseViewHolder baseViewHolder, int i) {

    }

    @Override
    public void onBindFooterViewHolder(BaseViewHolder baseViewHolder, int i) {
        CreditorEntity groupEntity = Data.get(i);
        baseViewHolder.setText(R.id.optimizi_head,groupEntity.getmGroupName());
    }

    @Override
    public void onBindChildViewHolder(BaseViewHolder holder, int groupPosition, int childPosition) {
        CreditorBean entity=Data.get(groupPosition).getChildren().get(childPosition);
        holder.setText(R.id.creaditor_company, entity.getmName());
        holder.setText(R.id.creaditor_tv_transfer_rate, entity.getmPrecent());
        holder.setText(R.id.creaditor_tv_transfer_num, entity.getmDate());
        holder.setText(R.id.creaditor_money, entity.getmMoney());
    }
}
