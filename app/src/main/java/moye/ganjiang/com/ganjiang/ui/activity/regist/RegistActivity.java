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
import moye.ganjiang.com.ganjiang.contract.activity.RegistContract;
import moye.ganjiang.com.ganjiang.model.regist.CodeResponseBean;
import moye.ganjiang.com.ganjiang.model.regist.RegistResponseBean;
import moye.ganjiang.com.ganjiang.presenter.regist.RegistPresenter;
import moye.ganjiang.com.ganjiang.ui.activity.login.LoginActivity;
import moye.ganjiang.com.ganjiang.utils.ToastUtil;

public class RegistActivity extends BaseActivity<RegistPresenter> implements RegistContract.View, View.OnClickListener {
    @BindView(R.id.tv_regist_toobar)
    TextView tvRegistToobar;//标题
    @BindView(R.id.toobar_regist)
    Toolbar toobarRegist;//toobar
    @BindView(R.id.tv_regist_zc)
    TextView tvRegistZc;//发送至xxx 号码
    @BindView(R.id.et_regist_yzm)
    EditText etRegistYzm;//请输入验证码
    @BindView(R.id.tv_regist_yzm)
    TextView tvRegistYzm;//验证码按钮
    @BindView(R.id.et_regist_loginpass)
    EditText etRegistLoginpass;//输入用户密码
    @BindView(R.id.cb_regist_showpass)
    CheckBox cbRegistShowpass;//是否显示密码
    @BindView(R.id.cb_regist_xy)
    CheckBox cbRegistXy;//确认注册的的checked 按钮
    @BindView(R.id.tv_regist_yhxy)
    TextView tvRegistYhxy;
    @BindView(R.id.fbtn_login_enter)
    Button fbtnLoginEnter;//确定按钮

    private Unbinder unbinder;
    private String PhoneNumber;
    private String code;
    private String password;
    private String mobliephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unbinder = ButterKnife.bind(this);

        Intent intent = getIntent();
        PhoneNumber = intent.getStringExtra(Contants.PHONENUMBER);
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
        setToolBar(toobarRegist, "");
        tvRegistZc.setText("发送至" + PhoneNumber);
        tvRegistYzm.setOnClickListener(this);
        fbtnLoginEnter.setOnClickListener(this);
    }


    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_regist_yzm:
                mPresenter.getPhoneCode(PhoneNumber);
                break;
            case R.id.fbtn_login_enter:
                password=etRegistLoginpass.getText().toString().trim();
                if (!cbRegistXy.isChecked()) {
                    ToastUtil.shortShow(" 请勾选同意选项");
                } else if (TextUtils.isEmpty(etRegistYzm.getText().toString().trim())) {

                    ToastUtil.shortShow(" 验证码不能为空");
                } else if (!code.equals(etRegistYzm.getText().toString().trim())) {

                    ToastUtil.shortShow(" 验证码不正确");
                } else if (TextUtils.isEmpty(password)) {

                    ToastUtil.shortShow(" 密码不能为空");
                } else {
                    //去注册
                    mPresenter.goToRegist(PhoneNumber,password);
                }
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
           Intent login= new Intent(this, LoginActivity.class);
           login.putExtra(Contants.USERNAME,mPresenter.getUserName());
           login.putExtra(Contants.PHONENUMBER,PhoneNumber);
           login.putExtra(Contants.METHOD,mPresenter.getMethod());
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
}
