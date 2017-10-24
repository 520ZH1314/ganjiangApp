package moye.ganjiang.com.ganjiang.ui.activity.regist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.app.Contants;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.contract.activity.regist.RegistContract;
import moye.ganjiang.com.ganjiang.model.regist.CodeResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistResponseBean;
import moye.ganjiang.com.ganjiang.presenter.regist.RegistPresenter;
import moye.ganjiang.com.ganjiang.ui.activity.login.LoginActivity;
import moye.ganjiang.com.ganjiang.utils.ToastUtil;

import static moye.ganjiang.com.ganjiang.R.id.tv_regist_yzm;
/**
 *author:lovezh
 *params:注册界面
 *description:
 */
public class RegistActivity extends BaseActivity<RegistPresenter> implements RegistContract.View, View.OnClickListener {


    @BindView(R.id.tv_regist_toobar)
    TextView tvRegistToobar;
    @BindView(R.id.toobar_regist)
    Toolbar toobarRegist;
    @BindView(R.id.et_regist_phone)
    EditText etRegistPhone;//注册手机号
    @BindView(R.id.et_regist_loginpass)
    EditText etRegistLoginpass;
    @BindView(R.id.cb_regist_showpass)
    CheckBox cbRegistShowpass;
    @BindView(R.id.cb_regist_xy)
    CheckBox cbRegistXy;
    @BindView(R.id.tv_regist_yhxy)
    TextView tvRegistYhxy;
    @BindView(R.id.fbtn_login_enter)
    Button fbtnLoginEnter;
    @BindView(R.id.et_regist_yzm)
    EditText etRegistYzm;
    @BindView(R.id.tv_regist_yzm)
    TextView tvRegistYzm;

    private Unbinder unbinder;
    private String code;
    private String mobliephone;
    private String password;
    private String PhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unbinder = ButterKnife.bind(this);
        initEventAndData();
    }

    //获取布局
    @Override
    protected int getLayout() {
        return R.layout.activity_regist;
    }

    //初始化数据和事件
    @Override
    protected void initEventAndData() {
        setToolBar(toobarRegist, " ");
        fbtnLoginEnter.setOnClickListener(this);
        tvRegistYzm.setOnClickListener(this);
    }


    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case tv_regist_yzm://验证码

                PhoneNumber = etRegistPhone.getText().toString().trim();
                if(TextUtils.isEmpty(PhoneNumber)){
                    ToastUtil.shortShow("手机号码不能为空");
                    return;
                }
                mPresenter.sendCode(tvRegistYzm);//倒计时发送
                mPresenter.getPhoneCode(PhoneNumber);
                break;
            case R.id.fbtn_login_enter://注册按钮
                password = etRegistLoginpass.getText().toString().trim();

                if (!cbRegistXy.isChecked()) {
                    ToastUtil.shortShow(" 请勾选同意选项");
                } else if (TextUtils.isEmpty(PhoneNumber)) {
                    ToastUtil.shortShow("手机号码不能为空");

                } else if (TextUtils.isEmpty(etRegistYzm.getText().toString().trim())) {

                    ToastUtil.shortShow(" 验证码不能为空");
                } else if (!code.equals(etRegistYzm.getText().toString().trim())) {

                    ToastUtil.shortShow(" 验证码不正确");
                } else if (TextUtils.isEmpty(password)) {

                    ToastUtil.shortShow(" 密码不能为空");
                } else {
                    //去注册
                    mPresenter.goToRegist(PhoneNumber, password);
                }
                break;

                 default:
                     break;
        }
    }




    @Override
    protected void setToolBar(Toolbar toolbar, String title) {
        super.setToolBar(toolbar, title);
        toolbar.setNavigationIcon(R.mipmap.title_bar_back);
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
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

    //获取服务器返回的验证码
    @Override
    public void showContent(CodeResponseBean bean) {
        code = bean.getCode();
    }

    @Override
    public void goToLogin() {
        Intent login = new Intent(this, LoginActivity.class);
        login.putExtra(Contants.PHONENUMBER, PhoneNumber);
        login.putExtra(Contants.METHOD, mPresenter.getMethod());
        startActivity(login);
        finish();
    }

    @Override
    public void showMoreContent() {

    }

    //注册返回的数据
    @Override
    public void showResult(RegistResponseBean bean) {
        mobliephone = bean.getMobliephone();
        mPresenter.setUserName(bean.getUsername());//保存用户名
        mPresenter.setMethod(bean.getMethod());//保存用户请求方式
    }

    @Override
    public void show(String msg) {

    }


}
