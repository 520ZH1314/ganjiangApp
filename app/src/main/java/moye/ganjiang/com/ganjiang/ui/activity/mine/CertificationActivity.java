package moye.ganjiang.com.ganjiang.ui.activity.mine;

import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.contract.activity.mine.CertificationContract;
import moye.ganjiang.com.ganjiang.presenter.mine.CertificationPresenter;

//实名认证界面
public class CertificationActivity extends BaseActivity<CertificationPresenter> implements CertificationContract.View {


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

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_certification;
    }
    //初始化数据
    @Override
    protected void initEventAndData() {

    }
}
