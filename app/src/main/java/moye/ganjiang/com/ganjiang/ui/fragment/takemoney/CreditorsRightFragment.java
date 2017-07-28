package moye.ganjiang.com.ganjiang.ui.fragment.takemoney;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yyydjk.library.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.adapt.CreditorAdapter;
import moye.ganjiang.com.ganjiang.adapt.GirdDropDownAdapter;
import moye.ganjiang.com.ganjiang.base.BaseFragment;
import moye.ganjiang.com.ganjiang.contract.fragments.CreditorContract;
import moye.ganjiang.com.ganjiang.model.takemoney.CreditorEntity;
import moye.ganjiang.com.ganjiang.presenter.takemoney.CreditorPresenter;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/28.
 * 债权列表
 */

public class CreditorsRightFragment extends BaseFragment<CreditorPresenter> implements CreditorContract.View {

    private RecyclerView creditorRec;
    Unbinder unbinder;
    @BindView(R.id.dropDownMenu)
    DropDownMenu mDownMenu;

    private String headers[] = {"默认", "期限", "年利率"};
    private String cust[] = {"不限"};
    private String data[] = {"不限", "3个月", "6个月", "9个月", "12个月"};
    private String year[] = {"不限", "8.04%", "8.05%"};
    private List<View> popupViews = new ArrayList<>();
    private GirdDropDownAdapter custAdapter;
    private GirdDropDownAdapter dataAdapter;
    private GirdDropDownAdapter yearAdapter;
    private ArrayList<CreditorEntity> groups;

    public static CreditorsRightFragment newInstance() {
        Bundle args = new Bundle();
        CreditorsRightFragment fragment = new CreditorsRightFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {
     getFragmentComponent().inject(this);
    }



    private void addItemClickEvent(ListView custView, GirdDropDownAdapter adapter, final String[] cust) {
        custView.setOnItemClickListener((parent, view, position, id) -> {
            custAdapter.setCheckItem(position);
            mDownMenu.setTabText(position == 0 ? headers[0] : cust[position]);
            mDownMenu.closeMenu();
        });
    }




    @Override
    protected int getLayoutId() {
        return R.layout.creditors_fragment;
    }

    @Override
    protected void initEventAndData() {
//         groups = mPresenter.getGroups(1,8);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        initEventAndData();//初始化数据

        return rootView;
    }






    @Override
    public boolean onBackPressedSupport() {
        //退出activity前关闭菜单
        if (mDownMenu.isShowing()) {
            mDownMenu.closeMenu();
        }
        return super.onBackPressedSupport();


    }

    @Override
    public void showContent() {
        //init cust menu
        final ListView custView = new ListView(mContext);
        custAdapter = new GirdDropDownAdapter(mContext, Arrays.asList(cust));
        custView.setDividerHeight(0);
        custView.setAdapter(custAdapter);
        //init data menu
        final ListView dataView = new ListView(mContext);
        dataAdapter = new GirdDropDownAdapter(mContext, Arrays.asList(data));
        dataView.setDividerHeight(0);
        dataView.setAdapter(dataAdapter);
        //init year menu
        final ListView yearView = new ListView(mContext);
        yearAdapter = new GirdDropDownAdapter(mContext, Arrays.asList(year));
        yearView.setDividerHeight(0);
        yearView.setAdapter(yearAdapter);


        //init popupViews
        popupViews.add(custView);
        popupViews.add(dataView);
        popupViews.add(yearView);


        //add item click event
        addItemClickEvent(custView,custAdapter,cust);
        addItemClickEvent(dataView,dataAdapter,data);
        addItemClickEvent(yearView,yearAdapter,year);
        //init context view
        creditorRec=new RecyclerView(mContext);
        creditorRec.setLayoutManager(new LinearLayoutManager(mContext));
        creditorRec.setAdapter(new CreditorAdapter(mContext,groups));
        creditorRec.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, creditorRec);

    }

    @Override
    public void showMoreContent() {

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
}

