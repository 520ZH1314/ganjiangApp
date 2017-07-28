package moye.ganjiang.com.ganjiang.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.base.BaseFragment;
import moye.ganjiang.com.ganjiang.contract.fragments.MainFragmentContract;
import moye.ganjiang.com.ganjiang.presenter.regist.MainFragmentPresenter;
import moye.ganjiang.com.ganjiang.ui.fragment.mine.MineFragment;
import moye.ganjiang.com.ganjiang.ui.fragment.select.SelectFragment;
import moye.ganjiang.com.ganjiang.ui.fragment.takemoney.TakeMoneyFragment;
import moye.ganjiang.com.ganjiang.widget.BottomBar;
import moye.ganjiang.com.ganjiang.widget.BottomBarTab;

import static moye.ganjiang.com.ganjiang.R.id.bottomBar;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/22.
 */

public class MainFragment extends BaseFragment<MainFragmentPresenter> implements MainFragmentContract.View {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    @BindView(R.id.fl_tab_container)
    FrameLayout flTabContainer;
    private String[] mTitles = {"精选", "理财", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.chosen_normal, R.mipmap.financial_normal,
            R.mipmap.my_normal};
    private int[] mIconSelectIds = {
            R.mipmap.chosen_pressed, R.mipmap.financial_pressed,
            R.mipmap.my_pressed
    };

    private SupportFragment[] mFragments = new SupportFragment[3];
    private BottomBar mBottomBar;


    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), null);
        if (savedInstanceState == null) {
            mFragments[FIRST] = SelectFragment.newInstance();
            mFragments[SECOND] = TakeMoneyFragment.newInstance();
            mFragments[THIRD] = MineFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findChildFragment(SelectFragment.class);
            mFragments[SECOND] = findChildFragment(TakeMoneyFragment.class);
            mFragments[THIRD] = findChildFragment(MineFragment.class);
        }
        mBottomBar = (BottomBar) mView.findViewById(bottomBar);

        initView();

        return mView;
    }

    protected void initView() {
        mBottomBar
                .addItem(new BottomBarTab(getContext(), mIconUnselectIds[0], mTitles[0]))
                .addItem(new BottomBarTab(getContext(), mIconUnselectIds[1], mTitles[1]))
                .addItem(new BottomBarTab(getContext(), mIconUnselectIds[2], mTitles[2]))
                .setCurrentItem(0);
    }

    @Override
    protected void initInject() {
    getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment;
    }

    @Override
    protected void initEventAndData() {
        //设置 fragment 布局切换
        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
//                if (position == 2 ) {
//                    if(mPresenter.getSessionId()!=null){
//
//                    }
//                    Intent intent =new Intent(getContext(), RegistOrLoginActivity.class);
//                    startActivity(intent);
//                }
                  showHideFragment(mFragments[position], mFragments[prePosition]);


            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
    public void showContent() {

    }

    @Override
    public void showMoreContent() {

    }
}
