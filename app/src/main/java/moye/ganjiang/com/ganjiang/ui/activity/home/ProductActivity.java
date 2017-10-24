package moye.ganjiang.com.ganjiang.ui.activity.home;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.TextView;

import com.qindachang.widget.RulerView;

import butterknife.BindView;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.app.Contants;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.contract.activity.home.ProductContract;
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
            if(TextUtils.isEmpty(mPresenter.getSessionId())){
                //没有登录
                mPresenter.goToOtherActivity(mContext, LoginActivity.class);
            }else{
                //判断是否开通银行账号
                if (mPresenter.IsOpen){
                    //开通了 跳转到购买界面
                    return;
                }
                new OpenDialog(mContext, (view, posion) -> {
                    if (posion== Contants.OPEN){
                        mPresenter.goToOtherActivity(mContext,BankDepositsActivity.class);

                    }

                }).show();

            }


        });
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
        toolbar.setNavigationIcon(R.mipmap.fanhui);
    }
}
