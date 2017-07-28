package moye.ganjiang.com.ganjiang.adapt;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import moye.ganjiang.com.ganjiang.ui.fragment.takemoney.CreditorsRightFragment;
import moye.ganjiang.com.ganjiang.ui.fragment.takemoney.OptimizingFinancialFragment;
import moye.ganjiang.com.ganjiang.ui.fragment.takemoney.TransferZoneFragment;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/28.
 */

public class WechatPagerFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTab = new String[]{"优选理财", "债权列表","转让专区"};

    public WechatPagerFragmentAdapter(FragmentManager childFragmentManager) {
        super(childFragmentManager);

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return OptimizingFinancialFragment.newInstance();// 优选理财
        } else if(position==1){
            return CreditorsRightFragment.newInstance();// 债权列表
        }else {
            return TransferZoneFragment.newInstance();//转让列表
        }
    }

    @Override
    public int getCount() {
        return mTab.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mTab[position];
    }

}
