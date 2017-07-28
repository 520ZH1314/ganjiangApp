package moye.ganjiang.com.ganjiang.utils;


import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import moye.ganjiang.com.ganjiang.model.response.LRHttpResponse;

/**
 * Created by codeest on 2016/8/3.
 */
public class RxUtil {

    /**
     * 统一线程处理
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                  return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }



    /**
     * 统一返回结果处理
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<LRHttpResponse<T>, T> handleResult() {   //compose判断结果
        return new FlowableTransformer<LRHttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<LRHttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<LRHttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(LRHttpResponse<T> HttpResponse) {
                        if(HttpResponse.getCode()==1||HttpResponse.getCode()==0) {
                             return createData(HttpResponse.getData());
                        } else {
                            return Flowable.error(new ApiException(HttpResponse.getMessage(),HttpResponse.getCode()));
                        }
                    }
                });
            }
        };
    }
//
//    /**
//     * 统一返回结果处理
//     * @param <T>
//     * @return
//     */
//    public static <T> FlowableTransformer<MyHttpResponse<T>, T> handleMyResult() {   //compose判断结果
//        return new FlowableTransformer<MyHttpResponse<T>, T>() {
//            @Override
//            public Flowable<T> apply(Flowable<MyHttpResponse<T>> httpResponseFlowable) {
//                return httpResponseFlowable.flatMap(new Function<MyHttpResponse<T>, Flowable<T>>() {
//                    @Override
//                    public Flowable<T> apply(MyHttpResponse<T> tMyHttpResponse) {
//                        if(tMyHttpResponse.getCode() == 200) {
//                            return createData(tMyHttpResponse.getData());
//                        } else {
//                            return Flowable.error(new ApiException(tMyHttpResponse.getMessage(), tMyHttpResponse.getCode()));
//                        }
//                    }
//                });
//            }
//        };
//    }
//
//    /**
//     * 统一返回结果处理
//     * @param <T>
//     * @return
//     */
//    public static <T> FlowableTransformer<GoldHttpResponse<T>, T> handleGoldResult() {   //compose判断结果
//        return new FlowableTransformer<GoldHttpResponse<T>, T>() {
//            @Override
//            public Flowable<T> apply(Flowable<GoldHttpResponse<T>> httpResponseFlowable) {
//                return httpResponseFlowable.flatMap(new Function<GoldHttpResponse<T>, Flowable<T>>() {
//                    @Override
//                    public Flowable<T> apply(GoldHttpResponse<T> tGoldHttpResponse) {
//                        if(tGoldHttpResponse.getResults() != null) {
//                            return createData(tGoldHttpResponse.getResults());
//                        } else {
//                            return Flowable.error(new ApiException("服务器返回error"));
//                        }
//                    }
//                });
//            }
//        };
//    }

    /**
     * 生成Flowable
     * @param <T>
     * @param
     * @return
     */
    public static <T> Flowable<T> createData(final T data) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(data);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }
}
