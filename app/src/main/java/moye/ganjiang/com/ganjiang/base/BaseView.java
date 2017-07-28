package moye.ganjiang.com.ganjiang.base;

/**
 * Created by codeest on 2017/7/2.
 * View基类
 */
public interface BaseView {

    void showErrorMsg(String msg);

    void showProgress();
    //=======  State  =======
    void stateError();

    void stateEmpty();

    void stateLoading();

}
