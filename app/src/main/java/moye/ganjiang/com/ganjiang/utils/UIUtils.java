package moye.ganjiang.com.ganjiang.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.File;

import moye.ganjiang.com.ganjiang.base.App;
import okhttp3.Cache;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/13.
 */

public class UIUtils {
    /**得到上下文*/
    public static Context getContext() {
        return App.getInstance();
    }

    /**得到Resouce对象*/
    public static Resources getResource() {
        return getContext().getResources();
    }
    //px->dip
    public static  int Px2Dip(int px){
        float density = getResource().getDisplayMetrics().density;
        int dip= (int) (px/density+.5f);
        return dip;

    }
    //dip
    //->px
    public static  int Dpi2Px(int dip){
        float density = getResource().getDisplayMetrics().density;
        int px= (int) (dip*density+.5f);
        return px;

    }
    private static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024;

    public static Cache cache() {
        //设置缓存路径
        File httpCacheDirectory = new File(UIUtils.getContext().getExternalCacheDir(),"HttpResponseCache");
        //设置缓存 10M
        return new Cache(httpCacheDirectory, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);
    }
    public static Boolean isNetworkReachable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo current = cm.getActiveNetworkInfo();
        if (current == null) {
            return false;
        }
        return (current.isAvailable());
    }



}
