package moye.ganjiang.com.ganjiang.adapt;


import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.model.contentdata.Markbean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/10/17.
 * 理财界面的 adapt
 */

public class TakeMoneyRecyclerViewAdapter extends BaseQuickAdapter<Markbean.ListBean,BaseViewHolder> {


    public TakeMoneyRecyclerViewAdapter(@LayoutRes int layoutResId, @Nullable List<Markbean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Markbean.ListBean item) {

            //设置数据
            helper.setText(R.id.tv_mark_title,item.getTno());//编号
            helper.setText(R.id.tv_mark_state,item.getTstatusStr());//标状态
            helper.setText(R.id.tv_interestrate1,item.getInterestrate() );//标利息
            helper.setText(R.id.tv_mark_date,item.getLoantime()+item.getDayormonth());//时间
            helper.setText(R.id.tv_mark_money,item.getLastmoney()+"元");//剩余可投金额
            helper.setProgress(R.id.mark_pb_progressbar,item.getProgressbarForApp());//进度
            helper.setText(R.id.tv_show_pb,item.getProgressbarForApp()+"%");

    }


}
