package moye.ganjiang.com.ganjiang.ui.fragment.takemoney;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.adapt.WechatPagerFragmentAdapter;
import moye.ganjiang.com.ganjiang.base.BaseFragment;
import moye.ganjiang.com.ganjiang.contract.fragments.TakeMoneyContract;
import moye.ganjiang.com.ganjiang.presenter.takemoney.TakeMoneyPresenter;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/22.
 *
 * 理财界面
 */

public class TakeMoneyFragment extends BaseFragment<TakeMoneyPresenter> implements TakeMoneyContract.View {
    @BindView(R.id.tm_toolbar)
    Toolbar tmToolbar;
    @BindView(R.id.tm_tab)
    TabLayout tmTab;
    @BindView(R.id.tm_viewPager)
    ViewPager tmViewPager;
    Unbinder unbinder;


    public static TakeMoneyFragment newInstance() {
        Bundle args = new Bundle();
        TakeMoneyFragment fragment = new TakeMoneyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.takemoney_fragemt;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showErrorMsg(String msg) {

    }




    @Override
    public void showProgress() {

    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
         unbinder = ButterKnife.bind(this, rootView);
          showContent();
          return rootView;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {
    getFragmentComponent().inject(this);
    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        tmViewPager.setAdapter(new WechatPagerFragmentAdapter(getChildFragmentManager()));
        tmTab.setupWithViewPager(tmViewPager);
    }



    @Override
    public void showContent() {
        //设置 toobar
        tmToolbar.setTitle("理财");
        tmTab.addTab(tmTab.newTab().setText("优选理财"));
        tmTab.addTab(tmTab.newTab().setText("债权列表"));
        tmTab.addTab(tmTab.newTab().setText("转让专区"));
    }

    @Override
    public void showMoreContent() {

    }
}
