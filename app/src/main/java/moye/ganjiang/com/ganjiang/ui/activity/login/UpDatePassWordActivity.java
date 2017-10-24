package moye.ganjiang.com.ganjiang.ui.activity.login;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.contract.activity.login.UpDatePwdContract;
import moye.ganjiang.com.ganjiang.presenter.login.UpDatePassWordActivityPresenter;
import moye.ganjiang.com.ganjiang.utils.ToastUtil;
import moye.ganjiang.com.ganjiang.widget.MyEditText;

/**
 * author:lovezh
 * params:修改新密码的Activity
 * description:
 */
public class UpDatePassWordActivity extends BaseActivity<UpDatePassWordActivityPresenter> implements UpDatePwdContract.View {

    @BindView(R.id.tv_update_pwd_toobar)
    TextView tvUpdatePwdToobar;
    @BindView(R.id.toobar_update_pwd)
    Toolbar toobarUpdatePwd;
    @BindView(R.id.update_phone)
    MyEditText updatePhone;// 获取的手机号码
    @BindView(R.id.update_phone_code)
    MyEditText updatePhoneCode;
    @BindView(R.id.fbtn_update_next)
    Button fbtnUpdateNext;//下一步
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;//获取手机验证码
    private String Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBar(toobarUpdatePwd, " ");

    }

    @Override
    protected void setToolBar(Toolbar toolbar, String title) {
        super.setToolBar(toolbar, title);
        toolbar.setNavigationIcon(R.mipmap.fanhui);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_up_date_pass_word;
    }

    /**
     * author:lovezh
     * params:
     * description:初始化点击事件 后期可以抽取
     */
    @Override
    protected void initEventAndData() {


        tvGetCode.setOnClickListener(v->{
            Phone=updatePhone.getText().toString().trim();
            if(TextUtils.isEmpty(Phone)){
                ToastUtil.shortShow("手机号码不能为空");
                return;
            }
            mPresenter.sendCode(tvGetCode);
            mPresenter.getUpDatePwdCode("getValidationCode",Phone);

        });
    }

    //绑定 Activity
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

}
