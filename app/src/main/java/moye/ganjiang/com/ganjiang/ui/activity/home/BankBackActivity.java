package moye.ganjiang.com.ganjiang.ui.activity.home;

import android.os.Bundle;

import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.contract.activity.home.BankBackContract;
import moye.ganjiang.com.ganjiang.model.regist.BankBean;
import moye.ganjiang.com.ganjiang.presenter.home.BankBackPresenter;
import moye.ganjiang.com.ganjiang.utils.ToastUtil;

public class BankBackActivity extends BaseActivity<BankBackPresenter> implements BankBackContract.View {

    private BankBean bankBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected int getLayout() {
        return R.layout.activity_bank_back;
    }

    @Override
    protected void initEventAndData() {
        //订阅获取的数据
         bankBean = getIntent().getParcelableExtra("BankBean");
        mPresenter.getdata(bankBean);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
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
    public void showContent(String s) {
        ToastUtil.shortShow(s);
    }

    @Override
    public void showMoreContent() {

    }
}
