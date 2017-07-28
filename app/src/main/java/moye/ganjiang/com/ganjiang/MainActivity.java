package moye.ganjiang.com.ganjiang;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.FrameLayout;

import butterknife.BindView;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import moye.ganjiang.com.ganjiang.app.Contants;
import moye.ganjiang.com.ganjiang.base.App;
import moye.ganjiang.com.ganjiang.base.BaseActivity;
import moye.ganjiang.com.ganjiang.base.CommonSubscriber;
import moye.ganjiang.com.ganjiang.contract.activity.MainActivityContract;
import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;
import moye.ganjiang.com.ganjiang.presenter.main.MainActivityPresenter;
import moye.ganjiang.com.ganjiang.ui.activity.regist.RegistOrLoginActivity;
import moye.ganjiang.com.ganjiang.ui.fragment.MainFragment;
import moye.ganjiang.com.ganjiang.utils.RxUtil;
import moye.ganjiang.com.ganjiang.utils.ToastUtil;


public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityContract.View {
    private static final String SHAREDPREFERENCES_NAME = "my_sp";
    private static final String NULL = "";
    @BindView(R.id.fl_container)
    FrameLayout fl_container;
    private SharedPreferences mSPrefs;
    private String string;
    private MainActivityContract.View mView;

    //拿到 layout

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance());
        }

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
//        startService(new Intent(mContext,InitializeService.class));
        mSPrefs = App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
         string = mSPrefs.getString(Contants.SESSIONID, NULL);
        if (TextUtils.isEmpty(string)){
            Intent intent =new Intent(mContext, RegistOrLoginActivity.class);
            startActivity(intent);
        }
        //获取数据
        initData();

    }

    private void initData() {

         App.getAppComponent().getDataManager().fetchGetUserMessage("Mthod", "getUserBaseDetail", string)
                 .compose(RxUtil.<UserMeassageBean>rxSchedulerHelper())
                 .subscribeWith(new CommonSubscriber<UserMeassageBean>(mView) {
                     @Override
                     public void onNext(UserMeassageBean userMeassageBean) {
                         String status = userMeassageBean.getStatus();
                         App.getAppComponent().getDataManager().insertUserMessage(userMeassageBean);
                         if("2".equals(status)){
                             ToastUtil.shortShow(userMeassageBean.getMsg());
                             //重新登入
                             getLogin();
                         }else if("0".equals(userMeassageBean.getStatus())){
                             ToastUtil.shortShow(userMeassageBean.getMsg());
                             getLogin();
                         }
                     }


                 });
    }
    //重新登入
    private void getLogin() {
        Intent login =new Intent(this, RegistOrLoginActivity.class);
        startActivity(login);
    }

    @Override
    public void onBackPressedSupport() {
        // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
        super.onBackPressedSupport();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
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

    @Override
    protected void initInject() {
       getActivityComponent().inject(this);
    }
}
