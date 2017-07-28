package moye.ganjiang.com.ganjiang.ui.fragment.takemoney;

import android.os.Bundle;

import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.base.SimpleFragment;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/28.
 * 转让专区
 */
public class TransferZoneFragment extends SimpleFragment{
    public static TransferZoneFragment newInstance() {
        Bundle args = new Bundle();
        TransferZoneFragment fragment = new TransferZoneFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.transfer_fragment;
    }

    @Override
    protected void initEventAndData() {

    }
}
