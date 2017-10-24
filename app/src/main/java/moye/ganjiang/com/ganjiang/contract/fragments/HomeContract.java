package moye.ganjiang.com.ganjiang.contract.fragments;

import android.content.Context;

import moye.ganjiang.com.ganjiang.base.BasePresenter;
import moye.ganjiang.com.ganjiang.base.BaseView;
import moye.ganjiang.com.ganjiang.model.home.LunBoBean;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/18.
 */

  public interface HomeContract {
    interface View extends BaseView {

        void showContent(LunBoBean bean);

        void showMoreContent();
    }

    interface Presenter extends BasePresenter<View> {

        void getData(int terminal, int itino);

        void getMoreData();
        void setClick(Context context, android.view.View view);
    }
}
