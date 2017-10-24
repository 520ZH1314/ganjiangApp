package moye.ganjiang.com.ganjiang.model.http;

import io.reactivex.Flowable;
import moye.ganjiang.com.ganjiang.model.contentdata.Markbean;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/10/12.
 * 获取标的请求
 */

public interface ContentData {
    //获取标数据

    @GET("appmoreItem.action?")
    Flowable<Markbean> getContentData(@Query("tstatus") int tstatus, @Query("pageNum") int pageNum);
    //获取更多标数据

    @GET("appmoreItem.action?")
    Flowable<Markbean> getMoreContentData(@Query("tstatus") int tstatus, @Query("pageNum") int pageNum);

}
