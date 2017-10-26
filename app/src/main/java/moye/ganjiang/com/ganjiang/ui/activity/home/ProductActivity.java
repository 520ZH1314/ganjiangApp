package moye.ganjiang.com.ganjiang.ui.activity.home;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.TextView;

import com.qindachang.widget.RulerView;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.app.Contants;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.base.Rxbus;
import moye.ganjiang.com.ganjiang.contract.activity.home.ProductContract;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.presenter.home.ProductPresenter;
import moye.ganjiang.com.ganjiang.ui.activity.login.LoginActivity;
import moye.ganjiang.com.ganjiang.widget.OpenDialog;

/**
 *author:lovezh
 *params:首页点击的产品详情界面
 *description:
 */
public class ProductActivity extends BaseActivity<ProductPresenter> implements ProductContract.View {

    @BindView(R.id.toobar_regist)
    Toolbar toobarRegist;
    @BindView(R.id.tv_product_money)
    TextView tvProductMoney;
    @BindView(R.id.rulerView_height)
    RulerView rulerViewHeight;
    @BindView(R.id.text_kaitong)
    TextView textKaitong;

    private String isOpen;
    private Disposable disposable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setToolBar(toobarRegist," ");
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_product;
    }

    //初始化数据和事件
    @Override
    protected void initEventAndData() {
        //刻度尺的初始化
        rulerViewHeight.setOnValueChangeListener(value -> tvProductMoney.setText((int) value + ""));
        //立刻投资的按钮的点击事件
        textKaitong. setOnClickListener(v -> {
              //判断是否登录
            String loginStatus = mPresenter.getLoginStatus();
            if("2".equals(loginStatus)||"0".equals(loginStatus)|| TextUtils.isEmpty(loginStatus)){
                //没有登录
                mPresenter.goToOtherActivity(mContext, LoginActivity.class);
            }else{
                 mPresenter.IsOpen();
                 mPresenter.getIsOpen();
                 goToBank(isOpen);

            }


        });
    }
   //跳转到银行
    private void goToBank(String isOpen) {

        //判断是否开通银行账号
        if ("1".equals(isOpen)){
            //开通了 跳转到购买界面
            return;
        }else{
            new OpenDialog(mContext, (view, posion) -> {
                if (posion== Contants.OPEN){
                    mPresenter.goToOtherActivity(getApplicationContext(),BankDepositsActivity.class);

                }

            }).show();
        }

    }

    // 绑定 Activity
    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
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
/**
 *author:lovezh
 *params:
 *description:设置 toobar
 */
    @Override
    protected void setToolBar(Toolbar toolbar, String title) {
        super.setToolBar(toolbar, title);
        toolbar.setNavigationIcon(R.mipmap.title_bar_back);
    }


    @Override
    protected void onResume() {
        super.onResume();
         disposable = Rxbus.getDefault().toFlowable(UserMeassageBean.class)
                .subscribe(new Consumer<UserMeassageBean>() {
                    @Override
                    public void accept(UserMeassageBean userMeassageBean) throws Exception {
                        isOpen = userMeassageBean.isopenfsinfo;
                    }
                });
    }

    @Override
    protected void onDestroy() {
        if(!disposable.isDisposed()){
            disposable.dispose();
        }
        super.onDestroy();
    }
}
