package moye.ganjiang.com.ganjiang.adapt;


import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * 项目名称:ganjiang
 * Created by lovezh
 * CreatedData: on 2017/7/4.
 */

public class Test {
    public void one(){
        Flowable.just("hello, i am from china" )
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
               
            }
        });

    }

}
