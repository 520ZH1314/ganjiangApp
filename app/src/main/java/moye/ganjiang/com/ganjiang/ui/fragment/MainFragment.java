package moye.ganjiang.com.ganjiang.ui.fragment;
import android.content.Intent;
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
import moye.ganjiang.com.ganjiang.ui.activity.login.LoginActivity;
import moye.ganjiang.com.ganjiang.ui.fragment.home.HomeFragment;
import moye.ganjiang.com.ganjiang.ui.fragment.mine.MineFragment;
import moye.ganjiang.com.ganjiang.ui.fragment.search.SearchFragment;
import moye.ganjiang.com.ganjiang.ui.fragment.takemoney.TakeMoneyFragment;
import moye.ganjiang.com.ganjiang.widget.BottomBar;
import moye.ganjiang.com.ganjiang.widget.BottomBarTab;

import static moye.ganjiang.com.ganjiang.R.id.bottomBar;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/22.
 * MainFragment
 */

public class MainFragment extends BaseFragment<MainFragmentPresenter> implements MainFragmentContract.View {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOUR = 3;
    private int lastPosition =0;
    @BindView(R.id.fl_tab_container)
    FrameLayout flTabContainer;
    private String[] mTitles = {"首页","理财", "发现", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.home, R.mipmap.find,
            R.mipmap.message,R.mipmap.mine};
    private int[] mIconSelectIds = {
            R.mipmap.home_tab, R.mipmap.find_tab,
            R.mipmap.message_tab,R.mipmap.mine_tab
    };

    private SupportFragment[] mFragments = new SupportFragment[4];
    private BottomBar mBottomBar;
    private MainFragmentContract.View view;
    private String status;//登录状态码
    //判断 SessionId 是否失效
    //判断是否登录
    public    boolean IsLogin() {
        String loginStatus = mPresenter.getLoginStatus();
        if("2".equals(loginStatus)||"0".equals(loginStatus)){
            //没有登录
            return false;
        }else{
            //登录了
            return  true;

        }


    }

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
            mFragments[FIRST] = HomeFragment.newInstance();
            mFragments[SECOND] = TakeMoneyFragment.newInstance();
            mFragments[THIRD] = SearchFragment.newInstance();
            mFragments[FOUR]= MineFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOUR]);

        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findChildFragment(HomeFragment.class);
            mFragments[SECOND] = findChildFragment(TakeMoneyFragment.class);
            mFragments[THIRD] = findChildFragment(SearchFragment.class);
            mFragments[FOUR]=findChildFragment(MineFragment.class);
        }
        mBottomBar = (BottomBar) mView.findViewById(bottomBar);

        initView();

        return mView;
    }



    //重新登入
    private void getLogin() {
        Intent login =new Intent(getContext(),LoginActivity.class);
        startActivity(login);
    }
    protected void initView() {
        mBottomBar
                .addItem(new BottomBarTab(getContext(), mIconUnselectIds[0], mTitles[0]))
                .addItem(new BottomBarTab(getContext(), mIconUnselectIds[1], mTitles[1]))
                .addItem(new BottomBarTab(getContext(), mIconUnselectIds[2], mTitles[2]))
                .addItem(new BottomBarTab(getContext(),mIconUnselectIds[3],mTitles[3]))
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
            IsLogin();//是否登录
        //设置 fragment 布局切换
        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
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
            initEventAndData();
    }

    @Override
    public void showMoreContent() {

    }

    //登录成功后刷新下数据

}
