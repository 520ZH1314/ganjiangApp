package moye.ganjiang.com.ganjiang.model.select;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import moye.ganjiang.com.ganjiang.R;
import moye.ganjiang.com.ganjiang.base.BaseModel;
import moye.ganjiang.com.ganjiang.utils.UIUtils;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/6/24.
 */

public  class SelectModel implements BaseModel{


    //轮播图
    public ArrayList<String> onLoadImagesData() {
        String[] urls = UIUtils.getResource().getStringArray(R.array.url4);
        ArrayList<String> images = new ArrayList<>(Arrays.asList(urls));
        return  images;
    }
    //热门活动
    public ArrayList<String> onLoadHotActivityData() {
        String[] hots = UIUtils.getResource().getStringArray(R.array.hot_activitys);
        ArrayList<String> hotActivity = new ArrayList<>(Arrays.asList(hots));
        return  hotActivity;
    }
    public ArrayList<String> onloadSelectNames() {
        String[] names = UIUtils.getResource().getStringArray(R.array.select_name);
        ArrayList<String> Names = new ArrayList<>(Arrays.asList(names));
        return  Names;
    }
    public ArrayList<String> onloadSelectMoney() {
        String[] names2 = UIUtils.getResource().getStringArray(R.array.select_money);
        ArrayList<String> Money = new ArrayList<>(Arrays.asList(names2));
        return  Money;
    }
    public ArrayList<String> onloadSelectDate() {
        String[] names3 = UIUtils.getResource().getStringArray(R.array.select_date);
        ArrayList<String> Date = new ArrayList<>(Arrays.asList(names3));
        return  Date;
    }
    public ArrayList<String> onloadSelectPrencent() {
        String[] names4 = UIUtils.getResource().getStringArray(R.array.select_precent);
        ArrayList<String> Prencent = new ArrayList<>(Arrays.asList(names4));
        return  Prencent;
    }
    @Override
    public void onFailed(String error) {
        Toast.makeText(UIUtils.getContext(),"网络错误",Toast.LENGTH_SHORT).show();
    }



}
