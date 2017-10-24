package moye.ganjiang.com.ganjiang.base;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import moye.ganjiang.com.ganjiang.utils.RxUtil;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/17.
 */

public class Rxbus {
    // 主题
    private final FlowableProcessor<Object> bus;
    // PublishSubject只会把在订阅发生的时间点之后来自原始Flowable的数据发射给观察者
    private Rxbus() {
        bus = PublishProcessor.create().toSerialized();
    }

    public static Rxbus getDefault() {
        return RxBusHolder.sInstance;
    }

    private static class RxBusHolder {
        private static final Rxbus sInstance = new Rxbus();
    }


    // 提供了一个新的事件
    public void post(Object o) {
        bus.onNext(o);

    }

    // 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
    public <T> Flowable<T> toFlowable(Class<T> eventType) {
        return bus.ofType(eventType);
    }

    // 封装默认订阅
    public <T> Disposable toDefaultFlowable(Class<T> eventType, Consumer<T> act) {
        return bus.ofType(eventType).compose(RxUtil.<T>rxSchedulerHelper()).subscribe(act);
    }
}
